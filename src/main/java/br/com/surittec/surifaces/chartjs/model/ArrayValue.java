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

public class ArrayValue<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Collection<T> values;
	
	/*
	 * Constructors
	 */
	
	public ArrayValue() {
		this(new ArrayList<T>());
	}
	
	@SafeVarargs
	public ArrayValue(T ... values){
		this(new ArrayList<T>(Arrays.asList(values)));
	}
	
	public ArrayValue(Collection<T> values) {
		this.values = values;
	}
	
	/*
	 * Public Methods
	 */
	
	@Override
	public String toString() {
		return String.format("%s%s%s", ChartUtil.ARRAY_PREFIX, StringUtils.join(values, ChartUtil.VALUE_SEPARATOR), ChartUtil.ARRAY_SUFFIX);
	}

	public ArrayValue<T> with(T value){
		values.add(value);
		return this;
	}
	
	public T add(T value){
		values.add(value);
		return value;
	}
	
	public Collection<T> getValues() {
		return values;
	}

	public void setValues(Collection<T> values) {
		this.values = values;
	}

}
