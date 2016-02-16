/*
 * SURITTEC
 * Copyright 2015, TTUS TECNOLOGIA DA INFORMACAO LTDA, 
 * and individual contributors as indicated by the @authors tag
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package br.com.surittec.surifaces.rewrite.handler;

import org.ocpsoft.rewrite.annotation.api.ClassContext;
import org.ocpsoft.rewrite.annotation.api.FieldContext;
import org.ocpsoft.rewrite.annotation.api.HandlerChain;
import org.ocpsoft.rewrite.annotation.api.MethodContext;
import org.ocpsoft.rewrite.annotation.handler.HandlerWeights;
import org.ocpsoft.rewrite.annotation.spi.AnnotationHandler;
import org.ocpsoft.rewrite.bind.Binding;
import org.ocpsoft.rewrite.config.Operation;

import br.com.surittec.surifaces.rewrite.annotation.IgnoreResponseCommitted;
import br.com.surittec.surifaces.rewrite.config.IgnoreResponseCommittedBinding;
import br.com.surittec.surifaces.rewrite.config.IgnoreResponseCommittedOperation;

public class IgnoreResponseCommittedHandler implements AnnotationHandler<IgnoreResponseCommitted>{

	@Override
	public int priority() {
		/*
		 * Must be executed after @Deferred but before all others so that the IgnoreResponseCommitted wrappers
		 * are deferred but also wrap everything else
		 */
		return HandlerWeights.WEIGHT_TYPE_ENRICHING + 6;
	}

	@Override
	public Class<IgnoreResponseCommitted> handles() {
		return IgnoreResponseCommitted.class;
	}

	@Override
	public void process(ClassContext context, IgnoreResponseCommitted annotation, HandlerChain chain) {
		
		if (context instanceof MethodContext) {
	         Operation operation = (Operation) context.get(Operation.class);
	         if (operation != null) {
	            // replace the operation with a wrapped one that ignores committed responses
	            context.put(Operation.class, new IgnoreResponseCommittedOperation(operation));
	         }
	      }

	      if (context instanceof FieldContext) {
	         Binding binding = (Binding) context.get(Binding.class);
	         if (binding != null) {
	            // replace the binding with a wrapped one that ignores committed responses
	            context.put(Binding.class, new IgnoreResponseCommittedBinding(binding));
	         }
	      }

	      // first let subsequent handlers wrap or enrich the binding/operation
	      chain.proceed();
		
	}

}
