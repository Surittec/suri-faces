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
import org.ocpsoft.rewrite.bind.Binding;
import org.ocpsoft.rewrite.context.EvaluationContext;
import org.ocpsoft.rewrite.event.Rewrite;

public class IgnoreResponseCommittedBinding implements Binding {

	private final Binding delegate;

	public IgnoreResponseCommittedBinding(Binding delegate) {
		this.delegate = delegate;
	}

	@Override
	public Object retrieve(Rewrite event, EvaluationContext context) {
		if (!isCommitted()) {
			return delegate.retrieve(event, context);
		}
		return null;
	}

	@Override
	public Object submit(Rewrite event, EvaluationContext context, Object value) {
		if (!isCommitted()) {
			return delegate.submit(event, context, value);
		}
		return null;
	}

	@Override
	public boolean supportsRetrieval() {
		return delegate.supportsRetrieval();
	}

	@Override
	public boolean supportsSubmission() {
		return delegate.supportsSubmission();
	}

	private boolean isCommitted() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Assert.notNull(facesContext, "FacesContext.getCurrentInstance() returned null. You should use @Deferred so the binding gets executed within the JSF lifecycle.");
		return ((HttpServletResponse) facesContext.getExternalContext().getResponse()).isCommitted();
	}
}
