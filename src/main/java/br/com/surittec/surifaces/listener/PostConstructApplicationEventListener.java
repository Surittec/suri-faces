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
package br.com.surittec.surifaces.listener;

import java.lang.reflect.Field;
import java.util.Map;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

import org.primefaces.component.paginator.PaginatorElementRenderer;
import org.primefaces.renderkit.DataRenderer;

import br.com.surittec.surifaces.primefaces.component.data.renderer.FirstPageLinkRenderer;
import br.com.surittec.surifaces.primefaces.component.data.renderer.LastPageLinkRenderer;
import br.com.surittec.surifaces.primefaces.component.data.renderer.NextPageLinkRenderer;
import br.com.surittec.surifaces.primefaces.component.data.renderer.PrevPageLinkRenderer;

public class PostConstructApplicationEventListener implements SystemEventListener {

    public boolean isListenerForSource(Object source) {
        return true;
    }

    public void processEvent(SystemEvent event) throws AbortProcessingException {
    	fixPrimefaces();
    }
    
    @SuppressWarnings("unchecked")
	private static void fixPrimefaces(){
    	try{
    		Field field = DataRenderer.class.getDeclaredField("PAGINATOR_ELEMENTS");
    		field.setAccessible(true);
    		Map<String,PaginatorElementRenderer> PAGINATOR_ELEMENTS = (Map<String,PaginatorElementRenderer>) field.get(null);
    		PAGINATOR_ELEMENTS.put("{FirstPageLink}", new FirstPageLinkRenderer());
    		PAGINATOR_ELEMENTS.put("{PreviousPageLink}", new PrevPageLinkRenderer());
    		PAGINATOR_ELEMENTS.put("{NextPageLink}", new NextPageLinkRenderer());
    		PAGINATOR_ELEMENTS.put("{LastPageLink}", new LastPageLinkRenderer());
    	}catch(Exception e){
    		throw new RuntimeException(e);
    	}
    }
}
