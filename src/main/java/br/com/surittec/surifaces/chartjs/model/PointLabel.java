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

public class PointLabel extends ObjectValue {

	private static final long serialVersionUID = 1L;

	public static final String DISPLAY 		= "display";
	public static final String FONT_COLOR 	= "fontColor";
	public static final String FONT_FAMILY 	= "fontFamily";
	public static final String FONT_SIZE 	= "fontSize";
	public static final String FONT_STYLE 	= "fontStyle";
	public static final String PADDING 		= "padding";
	public static final String SKIP_ZERO 	= "skipZero";
	public static final String GET_LABEL 	= "getLabel";
	
	/*
	 * Constructors
	 */

	public PointLabel() {
		super();
	}
	
	public PointLabel(Map<String, Object> attributes) {
		super(attributes);
	}
	
	/*
	 * Public Methods
	 */
	
	@Override
	public PointLabel with(String name, Object value){
		return (PointLabel) super.with(name, value);
	}
	
	public PointLabel withString(String name, String value){
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

	public PointLabel withDisplay(boolean display){
		return with(DISPLAY, display);
	}
	
	public PointLabel setFontColor(String fontColor){
		return with(FONT_COLOR, new StringValue(fontColor));
	}
	
	public PointLabel withFontColor(String fontColor){
		return withString(FONT_COLOR, fontColor);
	}
	
	public PointLabel withFontFamily(String fontFamily){
		return with(FONT_FAMILY, new StringValue(fontFamily));
	}
	
	public PointLabel withFontSize(int fontSize){
		return with(FONT_SIZE, fontSize);
	}
	
	public PointLabel withFontStyle(String fontStyle){
		return with(FONT_STYLE, new StringValue(fontStyle));
	}
	
	public PointLabel withPadding(int padding){
		return with(PADDING, padding);
	}
	
	public PointLabel withSkipZero(boolean skipZero){
		return with(SKIP_ZERO, skipZero);
	}
	
	public PointLabel withGetLabel(String getLabel){
		return with(GET_LABEL, getLabel);
	}
}
