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

public class DataArrayValue implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private StringArrayValue labels;
	
	private Map<String, Object> values;
	
	/*
	 * Constructors
	 */
	
	public DataArrayValue(StringArrayValue labels) {
		this(labels, new HashMap<String, Object>());
	}
	
	public DataArrayValue(StringArrayValue labels, Map<String, Object> values) {
		this.labels = labels;
		this.values = values;
	}
	
	/*
	 * Protected Methods
	 */
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ChartUtil.ARRAY_PREFIX);
		
		boolean appendSeparator = false;
		for(String label : labels.getValues()){
			if(appendSeparator) sb.append(ChartUtil.VALUE_SEPARATOR);
			appendValue(sb, label);
			appendSeparator = true;
		}
		
		sb.append(ChartUtil.ARRAY_SUFFIX);
		
		return sb.toString();
	}

	protected void appendValue(StringBuilder sb, String label){
		Object value = values.get(label);
		if(value != null){
			sb.append(value);
		}else{
			sb.append("0");
		}
	}
	
	/*
	 * Public Methods
	 */
	
	public DataArrayValue with(String label, Object value){
		values.put(label, value);
		return this;
	}
	
	public <T> T add(String label, T value){
		values.put(label, value);
		return value;
	}

	public Map<String, Object> getValues() {
		return values;
	}

	public void setValues(Map<String, Object> values) {
		this.values = values;
	}

	public StringArrayValue getLabels() {
		return labels;
	}

}
