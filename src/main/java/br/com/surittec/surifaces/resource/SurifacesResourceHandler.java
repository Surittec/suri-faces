package br.com.surittec.surifaces.resource;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.application.ResourceHandlerWrapper;

public abstract class SurifacesResourceHandler extends ResourceHandlerWrapper {
    
	private final ResourceHandler wrapped;
    
    public SurifacesResourceHandler(ResourceHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ResourceHandler getWrapped() {
        return this.wrapped;
    }

    @Override
    public Resource createResource(String resourceName, String libraryName) {
        Resource resource = super.createResource(resourceName, libraryName);
        
        if(resource != null && libraryName != null && libraryName.equalsIgnoreCase(getLibrary())) {
            return new SurifacesVersionedResource(resource, getVersion());
        }
        return resource;
    }

	@Override
    public Resource createResource(String resourceName, String libraryName, String contentType) {
        Resource resource = super.createResource(resourceName, libraryName, contentType);
        
        if(resource != null && libraryName != null && libraryName.equalsIgnoreCase(getLibrary())) {
            return new SurifacesVersionedResource(resource, getVersion());
        }
        return resource;
    }
	
	protected abstract String getVersion();
	
	protected abstract String getLibrary();

}
