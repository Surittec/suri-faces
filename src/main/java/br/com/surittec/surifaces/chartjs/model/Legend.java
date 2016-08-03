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

public class Legend extends ObjectValue {
	
	private static final long serialVersionUID = 1L;
	
	public static final String DISPLAY 		=  "display";
	public static final String FULL_WIDTH 	=  "fullWidth";
	
	public static final String POSITION 		=  "position";
	public static final String POSITION_RIGHT 	=  "right";
	public static final String POSITION_LEFT 	=  "left";
	public static final String POSITION_TOP 	=  "top";
	public static final String POSITION_BOTTOM 	=  "bottom";
	
	/*
	 * Constructors
	 */
	
	public Legend() {
		super();
	}
	
	public Legend(Map<String, Object> attributes) {
		super(attributes);
	}
	
	/*
	 * Public Methods
	 */
	
	@Override
	public Legend with(String name, Object value){
		return (Legend) super.with(name, value);
	}
	
	public Legend withDisplay(boolean display){
		return with(DISPLAY, display);
	}
	
	public Legend withFullWidth(boolean fullWidth){
		return with(FULL_WIDTH, fullWidth);
	}
	
	public Legend withPosition(String position){
		return with(POSITION, new StringValue(position));
	}
	
	public Legend withPositionRight(){
		return withPosition(POSITION_RIGHT);
	}
	
	public Legend withPositionLeft(){
		return withPosition(POSITION_LEFT);
	}
	
	public Legend withPositionTop(){
		return withPosition(POSITION_TOP);
	}
	
	public Legend withPositionBottom(){
		return withPosition(POSITION_BOTTOM);
	}
	
}
