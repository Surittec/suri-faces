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

import java.util.Map;

public class Dataset extends ObjectValue {
	
	private static final long serialVersionUID = 1L;
	
	public static final String LABEL			 		= "label";
	public static final String DATA			 			= "data";
	
	public static final String BACKGROUND_COLOR 		= "backgroundColor";
	public static final String BORDER_COLOR 			= "borderColor";
	public static final String BORDER_WIDTH 			= "borderWidth";
	public static final String HOVER_BACKGROUND_COLOR 	= "hoverBackgroundColor";
	public static final String HOVER_BORDER_COLOR 		= "hoverBorderColor";
	public static final String HOVER_BORDER_WIDTH 		= "hoverBorderWidth";
	public static final String HOVER_RADIUS 			= "hoverRadius";
	public static final String PONIT_LABEL				=  "pointLabel";
	
	/*
	 * Constructors
	 */

	public Dataset() {
		super();
	}
	
	public Dataset(Map<String, Object> attributes) {
		super(attributes);
	}
	
	public Dataset(String label) {
		super();
		withLabel(label);
	}
	
	/*
	 * Public Methods
	 */
	
	@Override
	public Dataset with(String name, Object value){
		return (Dataset) super.with(name, value);
	}
	
	public Dataset withString(String name, String value){
		Object valueHolder = getAttribute(name);
		if(valueHolder == null){
			with(name, new StringValue(value));
			
		}else if(valueHolder instanceof StringArrayValue){
			((StringArrayValue)valueHolder).with(value);
			
		}else{
			StringArrayValue sav = add(name, new StringArrayValue(((StringValue)valueHolder).getValue()));
			sav.with(value);
		}
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public <T> Dataset withValue(String name, T value){
		Object valueHolder = getAttribute(name);
		if(valueHolder == null){
			with(name, value);
			
		}else if(valueHolder instanceof ArrayValue){
			((ArrayValue<T>)valueHolder).with(value);
			
		}else{
			ArrayValue<T> av = add(name, new ArrayValue<T>((T)valueHolder));
			av.with(value);
		}
		return this;
	}
	
	public Dataset withLabel(String label){
		return with(LABEL, new StringValue(label));
	}
	
	public DataArrayValue getData(){
		DataArrayValue data = (DataArrayValue) getAttribute(DATA);
		if(data == null) data = add(DATA, new DataArrayValue());
		return data;
	}
	
	public Dataset setBackgroundColor(String color){
		return with(BACKGROUND_COLOR, new StringValue(color));
	}
	
	public Dataset withBackgroundColor(String color){
		return withString(BACKGROUND_COLOR, color);
	}
	
	public Dataset setBoderColor(String color){
		return with(BORDER_COLOR, new StringValue(color));
	}
	
	public Dataset withBoderColor(String color){
		return withString(BORDER_COLOR, color);
	}
	
	public Dataset setBorderWidth(int width){
		return with(BORDER_WIDTH, width);
	}
	
	public Dataset withBorderWidth(int width){
		return withValue(BORDER_WIDTH, width);
	}
	
	public Dataset setHoverBackgroundColor(String color){
		return with(HOVER_BACKGROUND_COLOR, new StringValue(color));
	}
	
	public Dataset withHoverBackgroundColor(String color){
		return withString(HOVER_BACKGROUND_COLOR, color);
	}
	
	public Dataset setHoverBoderColor(String color){
		return with(HOVER_BORDER_COLOR, new StringValue(color));
	}
	
	public Dataset withHoverBoderColor(String color){
		return withString(HOVER_BORDER_COLOR, color);
	}
	
	public Dataset setHoverBorderWidth(int width){
		return with(HOVER_BORDER_WIDTH, width);
	}
	
	public Dataset withHoverBorderWidth(int width){
		return withValue(HOVER_BORDER_WIDTH, width);
	}
	
	public Dataset setHoverRadius(int radius){
		return with(HOVER_RADIUS, radius);
	}
	
	public Dataset withHoverRadius(int radius){
		return withValue(HOVER_RADIUS, radius);
	}
	
	public PointLabel getPointLabel(){
		PointLabel pointLabel = (PointLabel) getAttribute(PONIT_LABEL);
		if(pointLabel == null) pointLabel = add(PONIT_LABEL, new PointLabel());
		return pointLabel;
	}
	
}
