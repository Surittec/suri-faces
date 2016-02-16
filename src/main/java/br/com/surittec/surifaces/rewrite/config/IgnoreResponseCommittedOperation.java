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
package br.com.surittec.surifaces.rewrite.config;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.ocpsoft.common.util.Assert;
import org.ocpsoft.rewrite.config.Operation;
import org.ocpsoft.rewrite.context.EvaluationContext;
import org.ocpsoft.rewrite.event.Rewrite;

public class IgnoreResponseCommittedOperation implements Operation {

	private final Operation delegate;

	public IgnoreResponseCommittedOperation(Operation delegate) {
		this.delegate = delegate;
	}

	@Override
	public void perform(Rewrite event, EvaluationContext context) {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		Assert.notNull(facesContext, "FacesContext.getCurrentInstance() returned null. You should use @Deferred so the operation gets executed within the JSF lifecycle.");
		
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		if (!response.isCommitted()) {
			delegate.perform(event, context);
		}

	}

}
