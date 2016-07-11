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
package br.com.surittec.surifaces.chartjs;

import br.com.surittec.surifaces.chartjs.model.ObjectValue;
import br.com.surittec.surifaces.chartjs.model.StringValue;

public class Chart extends ObjectValue {

	private static final long serialVersionUID = 1L;
	
	private static final String TYPE_ATTRIBUTE 		= "type";
	private static final String DATA_ATTRIBUTE 		= "data";
	private static final String OPTIONS_ATTRIBUTE 	= "options";
	
	public static final String LINE 			= "line";
	public static final String BAR 				= "bar";
	public static final String HORIZONTAL_BAR 	= "horizontalBar";
	public static final String RADAR 			= "radar";
	public static final String POLAR_AREA 		= "polarArea";
	public static final String PIE 				= "pie";
	public static final String DOUGHNUT 		= "doughnut";
	
	/*
	 * Constructor
	 */
	
	public Chart(String type){
		with(TYPE_ATTRIBUTE, new StringValue(type));
		with(DATA_ATTRIBUTE, new ObjectValue());
		with(OPTIONS_ATTRIBUTE, new ObjectValue());
	}

	/*
	 * Public Methods
	 */
	
	public StringValue getType(){
		return (StringValue) getAttribute(TYPE_ATTRIBUTE);
	}
	
	public ObjectValue getData(){
		return (ObjectValue) getAttribute(DATA_ATTRIBUTE);
	}
	
	public ObjectValue getOptions(){
		return (ObjectValue) getAttribute(OPTIONS_ATTRIBUTE);
	}
	
}
