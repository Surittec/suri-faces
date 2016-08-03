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

public class Options extends ObjectValue {
	
	private static final long serialVersionUID = 1L;
	
	public static final String RESPONSIVE 				=  "responsive";
	public static final String MAINTAIN_ASPECT_RATIO 	=  "maintainAspectRatio";
	public static final String SCALES 					=  "scales";
	public static final String PONIT_LABEL				=  "pointLabel";
	public static final String NUMBER_FORMAT			=  "numberFormat";
	public static final String LEGEND					=  "legend";
	
	/*
	 * Constructors
	 */
	
	public Options() {
		super();
	}
	
	public Options(Map<String, Object> attributes) {
		super(attributes);
	}
	
	/*
	 * Public Methods
	 */
	
	@Override
	public Options with(String name, Object value){
		return (Options) super.with(name, value);
	}
	
	public Options withResponsive(boolean responsive){
		return with(RESPONSIVE, responsive);
	}
	
	public Options withMaintainAspectRatio(boolean maintainAspectRatio){
		return with(MAINTAIN_ASPECT_RATIO, maintainAspectRatio);
	}
	
	public Scales getScales(){
		Scales scales = (Scales) getAttribute(SCALES);
		if(scales == null) scales = add(SCALES, new Scales());
		return scales;
	}
	
	public PointLabel getPointLabel(){
		PointLabel pointLabel = (PointLabel) getAttribute(PONIT_LABEL);
		if(pointLabel == null) pointLabel = add(PONIT_LABEL, new PointLabel());
		return pointLabel;
	}
	
	public NumberFormat getNumberFormat(){
		NumberFormat numberFormat = (NumberFormat) getAttribute(NUMBER_FORMAT);
		if(numberFormat == null) numberFormat = add(NUMBER_FORMAT, new NumberFormat());
		return numberFormat;
	}
	
	public Legend getLegend(){
		Legend legend = (Legend) getAttribute(LEGEND);
		if(legend == null) legend = add(LEGEND, new Legend());
		return legend;
	}
	
}
