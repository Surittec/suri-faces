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
 * @deprecated Use {@link Chart}
 *
 */
@Deprecated
public class PointDataset extends ItemDataset {

	private final String fillColor;
	private final String strokeColor;
	private final String pointColor;
	private final String pointStrokeColor;
	private final String pointHighlightFill;
	private final String pointHighlightStroke;

	public PointDataset(final String label, final String fillColor, final String strokeColor, final String pointColor, final String pointStrokeColor,
			final String pointHighlightFill,
			final String pointHighlightStroke) {
		super(label);
		this.fillColor = fillColor;
		this.strokeColor = strokeColor;
		this.pointColor = pointColor;
		this.pointStrokeColor = pointStrokeColor;
		this.pointHighlightFill = pointHighlightFill;
		this.pointHighlightStroke = pointHighlightStroke;
	}

	@Override
	public StringBuilder addJSONObject(final String[] labels, final StringBuilder sb) {
		sb.append('{');
		return addJSONFields(labels, sb)
				.append(',').append(' ')
				.append("fillColor: '").append(fillColor).append('\'').append(',').append(' ')
				.append("strokeColor: '").append(strokeColor).append('\'').append(',').append(' ')
				.append("pointColor: '").append(pointColor).append('\'').append(',').append(' ')
				.append("pointStrokeColor: '").append(pointStrokeColor).append('\'').append(',').append(' ')
				.append("pointHighlightFill: '").append(pointHighlightFill).append('\'').append(',').append(' ')
				.append("pointHighlightStroke: '").append(pointHighlightStroke).append('\'').append('}');
	}

	public String getFillColor() {
		return fillColor;
	}

	public String getStrokeColor() {
		return strokeColor;
	}

	public String getPointColor() {
		return pointColor;
	}

	public String getPointStrokeColor() {
		return pointStrokeColor;
	}

	public String getPointHighlightFill() {
		return pointHighlightFill;
	}

	public String getPointHighlightStroke() {
		return pointHighlightStroke;
	}
}
