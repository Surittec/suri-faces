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

public class Scales extends ObjectValue{

	private static final long serialVersionUID = 1L;
	
	public static final String XAXES 	=  "xAxes";
	public static final String YAXES 	=  "yAxes";
	
	/*
	 * Constructors
	 */
	
	public Scales() {
		super();
	}
	
	public Scales(Map<String, Object> attributes) {
		super(attributes);
	}
	
	/*
	 * Public Methods
	 */
	
	@Override
	public Scales with(String name, Object value){
		return (Scales) super.with(name, value);
	}
	
	public Axes getXAxes(){
		return getScalesAxes(XAXES);
	}
	
	public Axes getYAxes(){
		return getScalesAxes(YAXES);
	}
	
	/*
	 * Protected Methods
	 */
	
	protected Axes getScalesAxes(String axesName){
		Axes axes = (Axes) getAttribute(axesName);
		if(axes == null) axes = add(axesName, new Axes());
		return axes;
	}
}
