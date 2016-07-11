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

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.com.surittec.surifaces.chartjs.util.ChartUtil;

public class ObjectValue implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Map<String, Object> attributes;

	/*
	 * Constructors
	 */

	public ObjectValue() {
		this.attributes = new HashMap<String, Object>();
	}
	
	public ObjectValue(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
	/*
	 * Public Methods
	 */
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ChartUtil.OBJECT_PREFIX);
		
		boolean appendSeparator = false;
		for(String attribute : attributes.keySet()){
			if(appendSeparator) sb.append(ChartUtil.VALUE_SEPARATOR);
			sb.append(attribute).append(ChartUtil.ATTRIBUTE_DEFINITION_SEPARATOR).append(attributes.get(attribute));
			appendSeparator = true;
		}
		
		sb.append(ChartUtil.OBJECT_SUFFIX);
		
		return sb.toString();
	}

	public ObjectValue with(String name, Object value){
		attributes.put(name, value);
		return this;
	}
	
	public <T> T add(String name, T value){
		attributes.put(name, value);
		return value;
	}
	
	public Object getAttribute(String name){
		return attributes.get(name);
	}
	
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
}
