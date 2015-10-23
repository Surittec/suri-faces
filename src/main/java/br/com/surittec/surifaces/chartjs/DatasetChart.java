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
package br.com.surittec.surifaces.chartjs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.surittec.surifaces.chartjs.support.ChartJS;
import br.com.surittec.surifaces.chartjs.support.ItemDataset;

/**
 * 
 * @author Luis Gustavo
 *
 */
public abstract class DatasetChart<T extends ItemDataset> extends ChartJS {

	private final String[] labels;
	private final List<T> lines;

	protected DatasetChart(final String... labels) {
		this.labels = labels;
		this.lines = new ArrayList<T>();
	}

	public void add(final T line) {
		this.lines.add(line);
	}

	@Override
	public boolean hasData() {
		return !lines.isEmpty();
	}
	
	@Override
	public String getData() {
		StringBuilder sb = new StringBuilder();
		sb.append('{')
				.append("labels: ");

		labels(sb)
				.append(',').append(' ')
				.append("datasets: ");

		return lines(sb)
				.append('}').toString();
	}

	private StringBuilder labels(final StringBuilder sb) {
		if (labels.length == 0)
			return sb.append(EMPTY_ARR);

		sb.append('[');
		sb.append('\'').append(labels[0]).append('\'');
		for (int x = 1; x < labels.length; x++)
			sb.append(',').append(' ').append('\'').append(labels[x]).append('\'');
		return sb.append(']');
	}

	private StringBuilder lines(final StringBuilder sb) {
		Iterator<T> it = lines.iterator();
		if (!it.hasNext())
			return sb.append('[').append(']');

		sb.append('[');

		for (;;) {
			final T line = it.next();
			line.addJSONObject(labels, sb);

			if (it.hasNext())
				sb.append(',').append(' ');
			else
				break;
		}

		return sb.append(']');
	}
}
