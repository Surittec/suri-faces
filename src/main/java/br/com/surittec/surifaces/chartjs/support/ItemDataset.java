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
package br.com.surittec.surifaces.chartjs.support;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Luis Gustavo
 *
 */
public abstract class ItemDataset {

	private final String label;
	private final Map<String, Integer> data;

	public ItemDataset(final String label) {
		this.label = label;
		this.data = new HashMap<>();
	}

	public abstract StringBuilder addJSONObject(String[] labels, StringBuilder sb);

	public void setData(final String key, final Integer value) {
		this.data.put(key, value);
	}

	public void addAllData(final Map<String, Integer> data) {
		this.data.putAll(data);
	}

	public String getLabel() {
		return label;
	}

	public StringBuilder addJSONFields(final String[] labels, final StringBuilder sb) {
		sb.append("label: '")
				.append(label)
				.append('\'')
				.append(',')
				.append(' ')
				.append("data: ");

		return data(labels, sb);
	}

	private StringBuilder data(final String[] labels, final StringBuilder sb) {
		if (labels == null || labels.length == 0) {
			return sb.append('[').append(']');
		}
		sb.append('[');

		appendWithDefault(labels[0], sb);

		for (int x = 1; x < labels.length; x++) {
			sb.append(',').append(' ');
			appendWithDefault(labels[x], sb);
		}

		return sb.append(']');
	}

	private void appendWithDefault(final String label, final StringBuilder sb) {
		if (this.data.containsKey(label))
			sb.append(this.data.get(label).toString());
		else
			sb.append('0');
	}
}
