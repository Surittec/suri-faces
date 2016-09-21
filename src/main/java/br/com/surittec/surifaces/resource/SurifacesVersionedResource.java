package br.com.surittec.surifaces.resource;

import javax.faces.application.Resource;
import javax.faces.application.ResourceWrapper;

public class SurifacesVersionedResource extends ResourceWrapper {
    
	private Resource wrapped;
	private String version;

	public SurifacesVersionedResource(final Resource resource, final String version) {
		super();
		this.wrapped = resource;
		this.version = "&v=" + version;
	}

	@Override
	public Resource getWrapped() {
		return wrapped;
	}

	@Override
	public String getRequestPath() {
		return super.getRequestPath() + version;
	}

	@Override
	public String getContentType() {
		return getWrapped().getContentType();
	}

	@Override
	public String getLibraryName() {
		return getWrapped().getLibraryName();
	}

	@Override
	public String getResourceName() {
		return getWrapped().getResourceName();
	}

	@Override
	public void setContentType(final String contentType) {
		getWrapped().setContentType(contentType);
	}

	@Override
	public void setLibraryName(final String libraryName) {
		getWrapped().setLibraryName(libraryName);
	}

	@Override
	public void setResourceName(final String resourceName) {
		getWrapped().setResourceName(resourceName);
	}

	@Override
	public String toString() {
		return getWrapped().toString();
	}
}
