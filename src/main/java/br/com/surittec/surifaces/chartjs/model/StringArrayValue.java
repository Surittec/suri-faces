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
import java.util.Arrays;
import java.util.Collection;

import br.com.surittec.surifaces.chartjs.util.ChartUtil;

public class StringArrayValue implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Collection<String> values;
	
	/*
	 * Constructors
	 */
	
	public StringArrayValue() {
		this.values = new ArrayList<>();
	}
	
	public StringArrayValue(String ... values) {
		this.values = Arrays.asList(values);
	}
	
	public StringArrayValue(Collection<String> values) {
		this.values = values;
	}
	
	/*
	 * Public Methods
	 */
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ChartUtil.ARRAY_PREFIX);
		boolean appendSeparator = false;
		for(String value : values){
			if(appendSeparator) sb.append(ChartUtil.VALUE_SEPARATOR);
			sb.append("'").append(value).append("'");
			appendSeparator = true;
		}
		sb.append(ChartUtil.ARRAY_SUFFIX);
		return sb.toString();
	}

	public StringArrayValue with(String value){
		values.add(value);
		return this;
	}
	
	public Collection<String> getValues() {
		return values;
	}

	public void setValues(Collection<String> values) {
		this.values = values;
	}

}
