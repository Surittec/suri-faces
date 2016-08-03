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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import br.com.surittec.surifaces.chartjs.Chart;
import br.com.surittec.surifaces.chartjs.util.ChartUtil;

public class DataArrayValue implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private StringArrayValue labels;
	private Map<String, Integer> mapLabelValueIndex;
	
	private List<Object> values;
	
	private boolean nullValuesAsZero;
	
	/*
	 * Constructors
	 */
	
	public DataArrayValue() {
		this(new ArrayList<>());
	}
	
	public DataArrayValue(List<Object> values){
		this.values = values;
	}
	
	/*
	 * Protected Methods
	 */
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ChartUtil.ARRAY_PREFIX);

		if(labels != null){
			boolean appendSeparator = false;
			for(String label : labels.getValues()){
				if(appendSeparator) sb.append(ChartUtil.VALUE_SEPARATOR);
				
				Integer index = mapLabelValueIndex.get(label);
				if(index != null){
					sb.append(values.get(index));
				}else{
					sb.append(nullValuesAsZero ? "0" : "null");
				}
				appendSeparator = true;
			}
		}
		else{
			sb.append(StringUtils.join(values, ChartUtil.VALUE_SEPARATOR));
		}
		
		sb.append(ChartUtil.ARRAY_SUFFIX);
		
		return sb.toString();
	}
	
	/*
	 * Public Methods
	 */
	
	public DataArrayValue with(Object value){
		values.add(value);
		return this;
	}
	
	public Object add(Object value){
		values.add(value);
		return value;
	}
	
	public DataArrayValue with(Chart chart, String label, Object value){
		if(labels == null) labels = chart.getData().getLabels();
		if(mapLabelValueIndex == null) mapLabelValueIndex = new HashMap<String, Integer>();
		int index = values.size();

		labels.with(label);
		values.add(value);
		mapLabelValueIndex.put(label, index);
		return this;
	}
	
	public <T> T add(Chart chart, String label, T value){
		with(chart, label, value);
		return value;
	}

	public List<Object> getValues() {
		return values;
	}

	public void setValues(List<Object> values) {
		this.values = values;
	}

	public boolean isNullValuesAsZero() {
		return nullValuesAsZero;
	}

	public void setNullValuesAsZero(boolean nullValuesAsZero) {
		this.nullValuesAsZero = nullValuesAsZero;
	}

}
