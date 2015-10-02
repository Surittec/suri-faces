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

import br.com.surittec.surifaces.chartjs.support.ItemDataset;

/**
 * 
 * @author Luis Gustavo
 *
 */
public class BarDataset extends ItemDataset {

	private final String fillColor;
	private final String strokeColor;
	private final String highlightFill;
	private final String highlightStroke;

	public BarDataset(final String label, final String fillColor, final String strokeColor, final String highlightFill,
			final String highlightStroke) {
		super(label);
		this.fillColor = fillColor;
		this.strokeColor = strokeColor;
		this.highlightFill = highlightFill;
		this.highlightStroke = highlightStroke;
	}

	public String getFillColor() {
		return fillColor;
	}

	public String getStrokeColor() {
		return strokeColor;
	}

	public String getHighlightFill() {
		return highlightFill;
	}

	public String getHighlightStroke() {
		return highlightStroke;
	}

	@Override
	public StringBuilder addJSONObject(final String[] labels, final StringBuilder sb) {
		sb.append('{');
		return addJSONFields(labels, sb)
				.append(',').append(' ')
				.append("fillColor: '").append(fillColor).append('\'').append(',').append(' ')
				.append("strokeColor: '").append(strokeColor).append('\'').append(',').append(' ')
				.append("highlightFill: '").append(highlightFill).append('\'').append(',').append(' ')
				.append("highlightStroke: '").append(highlightStroke).append('\'').append('}');
	}
}
