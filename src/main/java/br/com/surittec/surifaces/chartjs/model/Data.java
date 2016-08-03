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

import java.util.LinkedHashSet;
import java.util.Map;

public class Data extends ObjectValue{
	
	private static final long serialVersionUID = 1L;

	private static final String LABELS 		= "labels";
	private static final String DATASETS 	= "datasets";
	
	/*
	 * Constructors
	 */

	public Data() {
		super();
	}
	
	public Data(Map<String, Object> attributes) {
		super(attributes);
	}
	
	/*
	 * Public Methods
	 */
	
	@Override
	public Data with(String name, Object value){
		return (Data) super.with(name, value);
	}
	
	public StringArrayValue getLabels() {
		StringArrayValue labels = (StringArrayValue) getAttribute(LABELS);
		if(labels == null) labels = add(LABELS, new StringArrayValue(new LinkedHashSet<String>()));
		return labels;
	}

	public DatasetArrayValue getDatasets() {
		DatasetArrayValue datasets = (DatasetArrayValue) getAttribute(DATASETS);
		if(datasets == null) datasets = add(DATASETS, new DatasetArrayValue());
		return datasets;
	}

}
