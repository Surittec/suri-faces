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
package br.com.surittec.surifaces.exception.handler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.OptimisticLockException;

import org.ocpsoft.rewrite.exception.RewriteException;
import org.ocpsoft.rewrite.faces.navigate.Navigate;
import org.primefaces.application.exceptionhandler.ExceptionInfo;
import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.surittec.surifaces.util.FacesUtils;
import br.com.surittec.util.exception.ExceptionUtil;

import com.sun.faces.context.FacesFileNotFoundException;

/**
 * Exception Handler
 * 
 * @author Lucas Lins
 *
 */
public class ExceptionHandler extends ExceptionHandlerWrapper {

	private final javax.faces.context.ExceptionHandler wrapped;

	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

	private static final String DATE_FORMAT_PATTERN = "dd/MM/yyyy HH:mm:ss";

	private boolean catched;

	public ExceptionHandler(final javax.faces.context.ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public javax.faces.context.ExceptionHandler getWrapped() {
		return this.wrapped;
	}

	@Override
	public void handle() throws FacesException {
		catched = false;

		for (final Iterator<ExceptionQueuedEvent> it = getUnhandledExceptionQueuedEvents().iterator(); it.hasNext();) {
			Throwable t = ExceptionUtil.getRootCause(it.next().getContext().getException());

			if (handleException(it, t, FacesFileNotFoundException.class, "com.sun.faces.context.FacesFileNotFoundException.message"))
				continue;
			if (handleException(it, t, RewriteException.class, "org.ocpsoft.rewrite.exception.RewriteException.message"))
				continue;
			if (handleException(it, t, EntityNotFoundException.class, "javax.persistence.EntityNotFoundException.message"))
				continue;
			if (handleException(it, t, EntityExistsException.class, "javax.persistence.EntityExistsException.message"))
				continue;
			if (handleException(it, t, OptimisticLockException.class, "javax.persistence.OptimisticLockException.message"))
				continue;
			if (handleException(it, t, ViewExpiredException.class, "javax.faces.application.ViewExpiredException.message"))
				continue;
			if (handleException(it, t, Exception.class, "java.lang.Exception.message"))
				continue;

		}
		getWrapped().handle();
	}

	protected boolean handleException(Iterator<ExceptionQueuedEvent> it, Throwable t, Class<? extends Throwable> type, String message) {
		if (type.isAssignableFrom(t.getClass())) {
			try {
				if (!catched) {

					FacesContext context = FacesUtils.getContext();

					FacesUtils.addMsgErro(message);
					FacesUtils.getRequestMap().put(ExceptionInfo.ATTRIBUTE_NAME, createExceptionInfo(t));
					context.getApplication().getNavigationHandler().handleNavigation(context, null, getOutcome(t));

					return true;
				}
			} finally {
				catched = true;
				logger.error(t.getLocalizedMessage(), t);
				it.remove();
			}
		}
		return false;
	}

	protected String getOutcome(Throwable rootCause) {
		Map<String, String> errorPages = RequestContext.getCurrentInstance().getApplicationContext().getConfig().getErrorPages();

		// get error page by exception type
		String errorPage = errorPages.get(rootCause.getClass().getName());

		// get default error page
		if (errorPage == null) {
			errorPage = errorPages.get(null);
		}
		
		return errorPage != null ? Navigate.to(errorPage).build() : null;
	}

	protected ExceptionInfo createExceptionInfo(Throwable rootCause) {
		ExceptionInfo info = new ExceptionInfo();
		info.setException(rootCause);
		info.setMessage(rootCause.getMessage());
		info.setStackTrace(rootCause.getStackTrace());
		info.setTimestamp(new Date());
		info.setType(rootCause.getClass().getName());
		info.setFormattedStackTrace(ExceptionUtil.getStackTrace(rootCause).replaceAll("(\r\n|\n)", "<br/>"));
		info.setFormattedTimestamp(new SimpleDateFormat(DATE_FORMAT_PATTERN).format(info.getTimestamp()));
		return info;
	}
}
