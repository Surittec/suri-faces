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

import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Map;

public class NumberFormat extends ObjectValue {

	private static final long serialVersionUID = 1L;

	public static final String DECIMAL_SEPARATOR 		= "decimalSeparator";
	public static final String THOUSANDS_SEPARATOR 		= "thousandsSeparator";
	public static final String CURRENCY 				= "currency";
	public static final String FRACTION_DIGITS 			= "fractionDigits";
	public static final String POINT_LABEL_CURRENCY 	= "pointLabelCurrency";
	public static final String POINT_LABEL_PERCENT 		= "pointLabelPercent";
	public static final String TICK_CURRENCY 			= "tickCurrency";
	public static final String TICK_PERCENT 			= "tickPercent";
	public static final String TOOLTIP_CURRENCY 		= "tooltipCurrency";
	public static final String TOOLTIP_PERCENT			= "tooltipPercent";
	
	/*
	 * Constructors
	 */

	public NumberFormat() {
		super();
	}
	
	public NumberFormat(Map<String, Object> attributes) {
		super(attributes);
	}
	
	/*
	 * Public Methods
	 */
	
	@Override
	public NumberFormat with(String name, Object value){
		return (NumberFormat) super.with(name, value);
	}
	
	public NumberFormat withLocaleSeparators(Locale locale){
		DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance(locale);
		withDecimalSeparator(String.valueOf(dfs.getDecimalSeparator()));
		withThousandsSeparator(String.valueOf(dfs.getGroupingSeparator()));
		return this;
	}
	
	public NumberFormat withLocaleCurrency(Locale locale){
		DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance(locale);
		return withCurrency(dfs.getCurrencySymbol());
	}
	
	public NumberFormat withDecimalSeparator(String decimalSeparator){
		return with(DECIMAL_SEPARATOR, new StringValue(decimalSeparator));
	}
	
	public NumberFormat withThousandsSeparator(String thousandsSeparator){
		return with(THOUSANDS_SEPARATOR, new StringValue(thousandsSeparator));
	}
	
	public NumberFormat withCurrency(String currency){
		return with(CURRENCY, new StringValue(currency));
	}
	
	public NumberFormat withFractionDigits(int fractionDigits){
		return with(FRACTION_DIGITS, fractionDigits);
	}
	
	public NumberFormat withPointLabelCurrency(boolean pointLabelCurrency){
		return with(POINT_LABEL_CURRENCY, pointLabelCurrency);
	}
	
	public NumberFormat withPointLabelPercent(boolean pointLabelPercent){
		return with(POINT_LABEL_PERCENT, pointLabelPercent);
	}
	
	public NumberFormat withTickCurrency(boolean tickCurrency){
		return with(TICK_CURRENCY, tickCurrency);
	}
	
	public NumberFormat withTickPercent(boolean tickPercent){
		return with(TICK_PERCENT, tickPercent);
	}
	
	public NumberFormat withTooltipCurrency(boolean tooltipCurrency){
		return with(TOOLTIP_CURRENCY, tooltipCurrency);
	}
	
	public NumberFormat withTooltipPercent(boolean tooltipPercent){
		return with(TOOLTIP_PERCENT, tooltipPercent);
	}
}
