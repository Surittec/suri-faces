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
package br.com.surittec.surifaces.chartjs.model;

import java.util.Collection;

public class Axes extends ArrayValue<ObjectValue> {

	private static final long serialVersionUID = 1L;

	public static final String STACKED 	=  "stacked";
	public static final String TICKS 	=  "ticks";
	
	/*
	 * Constructors
	 */
	
	public Axes() {
		super(new ObjectValue());
	}
	
	public Axes(ObjectValue ... values) {
		super(values);
	}
	
	public Axes(Collection<ObjectValue> values) {
		super(values);
	}
	
	/*
	 * Public Methods
	 */
	
	public void setStacked(boolean stacked){
		getObject().with(STACKED, stacked);
	}
	
	public Ticks getTicks(){
		Ticks ticks = (Ticks) getObject().getAttribute(TICKS);
		if(ticks == null) ticks = getObject().add(TICKS, new Ticks());
		return ticks;
	}
	
	public ObjectValue getObject(){
		if(getValues().isEmpty()){
			ObjectValue object = new ObjectValue();
			getValues().add(object);
			return object;
		}
		return ((ObjectValue)getValues().iterator().next());
	}
}
