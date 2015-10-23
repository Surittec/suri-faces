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
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author Luis Gustavo
 *
 */
public abstract class ChartJS {

	protected static final String EMPTY_OBJECT = "{}";
	protected static final String EMPTY_ARR = "[]";

	private final Map<String, String> config = new HashMap<>();

	/*
	 * Constructor
	 */
	
	public ChartJS() {
		setConfig("responsive", "true");
	}
	
	/*
	 * Public Methods
	 */
	
	public abstract String getJsClass();

	public abstract String getData();
	
	public abstract boolean hasData();

	public String getConfig() {
		if (config.isEmpty()) {
			return EMPTY_OBJECT;
		}

		return config();
	}

	public void setConfig(final String key, final String value) {
		config.put(key, value);
	}

	public void setConfigString(final String key, final String value) {
		config.put(key, String.format("\"%s\"", value));
	}

	public void addAllConfigs(final Map<String, String> config) {
		this.config.putAll(config);
	}

	/*
	 * Private Methods
	 */
	
	private String config() {
		if (config.isEmpty())
			return EMPTY_OBJECT;

		final StringBuilder sb = new StringBuilder();
		final Iterator<Entry<String, String>> it = config.entrySet().iterator();
		sb.append('{');
		for (;;) {
			Entry<String, String> entry = it.next();
			sb.append(entry.getKey())
					.append(':').append(' ')
					.append(entry.getValue());
			if (it.hasNext()) {
				sb.append(',').append(' ');
			} else {
				break;
			}
		}

		return sb.append('}').toString();
	}
}
