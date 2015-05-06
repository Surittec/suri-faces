package br.com.surittec.surifaces.exception.resolver;

import java.beans.FeatureDescriptor;
import java.util.Iterator;

import javax.el.ELContext;
import javax.el.ELResolver;

import org.primefaces.application.exceptionhandler.ExceptionInfo;

import br.com.surittec.surifaces.util.FacesUtils;

public class ExceptionInfoELResolver extends ELResolver {

	private static final String EL_NAME = "exceptionInfo";

	@Override
	public Object getValue(ELContext elContext, Object base, Object property) {
		if (EL_NAME.equals(property)) {
			elContext.setPropertyResolved(true);
			return FacesUtils.getRequestMap().get(ExceptionInfo.ATTRIBUTE_NAME);
		}
		return null;
	}

	@Override
	public Class<?> getCommonPropertyType(ELContext arg0, Object arg1) {
		return null;
	}

	@Override
	public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext arg0, Object arg1) {
		return null;
	}

	@Override
	public Class<?> getType(ELContext arg0, Object arg1, Object arg2) {
		return null;
	}

	@Override
	public boolean isReadOnly(ELContext arg0, Object arg1, Object arg2) {
		return true;
	}

	@Override
	public void setValue(ELContext arg0, Object arg1, Object arg2, Object arg3) {
	}

}
