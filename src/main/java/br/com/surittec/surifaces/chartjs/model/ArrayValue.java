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

import org.apache.commons.lang.StringUtils;

import br.com.surittec.surifaces.chartjs.util.ChartUtil;

public class ArrayValue implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Collection<Object> values;
	
	/*
	 * Constructors
	 */
	
	public ArrayValue() {
		this.values = new ArrayList<>();
	}
	
	public ArrayValue(Object ... values) {
		this.values = Arrays.asList(values);
	}
	
	public ArrayValue(Collection<Object> values) {
		this.values = values;
	}
	
	/*
	 * Public Methods
	 */
	
	@Override
	public String toString() {
		return String.format("%s%s%s", ChartUtil.ARRAY_PREFIX, StringUtils.join(values, ChartUtil.VALUE_SEPARATOR), ChartUtil.ARRAY_SUFFIX);
	}

	public ArrayValue with(Object value){
		values.add(value);
		return this;
	}
	
	public <T> T add(T value){
		values.add(value);
		return value;
	}
	
	public Collection<Object> getValues() {
		return values;
	}

	public void setValues(Collection<Object> values) {
		this.values = values;
	}

}
