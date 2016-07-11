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

import br.com.surittec.surifaces.chartjs.Chart;

/**
 * 
 * @deprecated Use {@link Chart}
 *
 */
@Deprecated
public class AreaItem {
	private final int value;
	private final String color;
	private final String highlight;
	private final String label;

	public AreaItem(final int value, final String color, final String highlight, final String label) {
		super();
		this.value = value;
		this.color = color;
		this.highlight = highlight;
		this.label = label;
	}

	public int getValue() {
		return value;
	}

	public String getColor() {
		return color;
	}

	public String getHighlight() {
		return highlight;
	}

	public String getLabel() {
		return label;
	}

	@Override
	public String toString() {
		return "{value: " + value + ", color: '" + color + "', highlight: '" + highlight + "', label: '" + label + "'}";
	}

}
