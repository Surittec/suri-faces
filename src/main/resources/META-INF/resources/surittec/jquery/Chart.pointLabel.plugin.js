Chart.defaults.global.pointLabel = {
	display: true,
	fontColor: '#666',
	fontFamily: '"Helvetica Neue", Helvetica, Arial, sans-serif',
	fontSize: 13,
	fontStyle: 'bold',
	padding: 5,
	skipZero: false,
	getLabel: function(value, chartInstance){
		var numberFormat = chartInstance.options.numberFormat,
			ds = numberFormat.decimalSeparator,
			ts = numberFormat.thousandsSeparator,
			fd = numberFormat.fractionDigits,
			pf = numberFormat.pointLabelCurrency ? numberFormat.currency : '',
			sf = numberFormat.pointLabelPercent ? '%' : '';
		return Chart.helpers.formatNumber(value, ds, ts, fd, pf, sf);
	}
};

Chart.defaults.global.numberFormat = {
	decimalSeparator: '.',
	thousandsSeparator: ',',
	currency: '$ ',
	fractionDigits: 2,
	pointLabelCurrency: false,
	pointLabelPercent: false,
	tickCurrency: false,
	tickPercent: false,
	tooltipCurrency: false,
	tooltipPercent: false
};

Chart.defaults.global.tooltips.callbacks.label = function(tooltipItem, data) {
	var numberFormat = this._chart.config.options.numberFormat,
		ds = numberFormat.decimalSeparator,
		ts = numberFormat.thousandsSeparator,
		fd = numberFormat.fractionDigits,
		pf = numberFormat.tooltipCurrency ? numberFormat.currency : '',
		sf = numberFormat.tooltipPercent ? '%' : '';
	var datasetLabel = data.datasets[tooltipItem.datasetIndex].label || '';
	return datasetLabel + ': ' + Chart.helpers.formatNumber(tooltipItem.yLabel, ds, ts, fd, pf, sf);
};

Chart.defaults.horizontalBar.tooltips.callbacks.label = function(tooltipItem, data) {
	var numberFormat = this._chart.config.options.numberFormat,
		ds = numberFormat.decimalSeparator,
		ts = numberFormat.thousandsSeparator,
		fd = numberFormat.fractionDigits,
		pf = numberFormat.tooltipCurrency ? numberFormat.currency : '',
		sf = numberFormat.tooltipPercent ? '%' : '';
	var datasetLabel = data.datasets[tooltipItem.datasetIndex].label || '';
	return datasetLabel + ': ' + Chart.helpers.formatNumber(tooltipItem.xLabel, ds, ts, fd, pf, sf);
};

Chart.defaults.doughnut.tooltips.callbacks.label = function(tooltipItem, data) {
	var numberFormat = this._chart.config.options.numberFormat,
		ds = numberFormat.decimalSeparator,
		ts = numberFormat.thousandsSeparator,
		fd = numberFormat.fractionDigits,
		pf = numberFormat.tooltipCurrency ? numberFormat.currency : '',
		sf = numberFormat.tooltipPercent ? '%' : '';
	return data.labels[tooltipItem.index] + ': ' + Chart.helpers.formatNumber(data.datasets[tooltipItem.datasetIndex].data[tooltipItem.index], ds, ts, fd, pf, sf);
};

Chart.defaults.pie.tooltips.callbacks.label = function(tooltipItem, data) {
	var numberFormat = this._chart.config.options.numberFormat,
		ds = numberFormat.decimalSeparator,
		ts = numberFormat.thousandsSeparator,
		fd = numberFormat.fractionDigits,
		pf = numberFormat.tooltipCurrency ? numberFormat.currency : '',
		sf = numberFormat.tooltipPercent ? '%' : '';
	return data.labels[tooltipItem.index] + ': ' + Chart.helpers.formatNumber(data.datasets[tooltipItem.datasetIndex].data[tooltipItem.index], ds, ts, fd, pf, sf);
};

Chart.defaults.polarArea.tooltips.callbacks.label = function(tooltipItem, data) {
	var numberFormat = this._chart.config.options.numberFormat,
		ds = numberFormat.decimalSeparator,
		ts = numberFormat.thousandsSeparator,
		fd = numberFormat.fractionDigits,
		pf = numberFormat.tooltipCurrency ? numberFormat.currency : '',
		sf = numberFormat.tooltipPercent ? '%' : '';
	return data.labels[tooltipItem.index] + ': ' + Chart.helpers.formatNumber(tooltipItem.yLabel, ds, ts, fd, pf, sf);
};

Chart.helpers.formatNumber = function(n, d, t, c, pf, sf){
	var c = isNaN(c = Math.abs(c)) ? 2 : c, 
	    d = d == undefined ? "." : d, 
	    t = t == undefined ? "," : t, 
	    s = n < 0 ? "-" : "", 
		pf = pf == undefined ? "" : pf,
		sf = sf == undefined ? "" : sf,
	    i = parseInt(n = Math.abs(+n || 0).toFixed(c)) + "", 
	    j = (j = i.length) > 3 ? j % 3 : 0;
	return pf + s + (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t) + (c ? d + Math.abs(n - i).toFixed(c).slice(2) : "") + sf;
};

Chart.Scale.prototype.convertTicksToLabels = function() {
	var me = this;
	me.ticks = me.ticks.map(function(numericalTick, index, ticks) {
			if (me.options.ticks.userCallback) {
				return me.options.ticks.userCallback(numericalTick, index, ticks, me);
			}
			return me.options.ticks.callback(numericalTick, index, ticks, me);
		},
		me);
};

Chart.scaleService.updateScaleDefaults('linear', {
    ticks: {
		callback: function(tickValue, index, ticks, chartInstance) {
			// If we have lots of ticks, don't use the ones
			var delta = ticks.length > 3 ? ticks[2] - ticks[1] : ticks[1] - ticks[0];

			// If we have a number like 2.5 as the delta, figure out how many decimal places we need
			if (Math.abs(delta) > 1) {
				if (tickValue !== Math.floor(tickValue)) {
					// not an integer
					delta = tickValue - Math.floor(tickValue);
				}
			}

			var logDelta = Chart.helpers.log10(Math.abs(delta));
			var tickString = '';

			if (tickValue !== 0) {
				var fd = -1 * Math.floor(logDelta);
				fd = Math.max(Math.min(fd, 20), 0); // toFixed has a max of 20 decimal places
				var numberFormat = chartInstance.chart.options.numberFormat,
					ds = numberFormat.decimalSeparator,
					ts = numberFormat.thousandsSeparator,
					pf = numberFormat.tickCurrency ? numberFormat.currency : '',
					sf = numberFormat.tickPercent ? '%' : '';
				tickString = Chart.helpers.formatNumber(tickValue, ds, ts, fd, pf, sf);
			} else {
				tickString = '0'; // never show decimal places for 0
			}
			
			return tickString;
		}
    }
});

Chart.pluginService.register({
	afterDatasetsDraw: function(chartInstance, easing) {
		var helpers = Chart.helpers;		
		var pointLabelGlobalOptions = chartInstance.options.pointLabel;
		
		if(pointLabelGlobalOptions.display){
			var chart = chartInstance.chart;
			var ctx = chart.ctx;
			var chartType = chart.config.type;
			
            helpers.each(chartInstance.data.datasets.forEach(function (dataset, i) {
				if(chart.controller.isDatasetVisible(i)){
                	var meta = chart.controller.getDatasetMeta(i);

                    helpers.each(meta.data.forEach(function (c, index) {
						if(!c.hidden){
							var pointLabelOptions = $.extend({}, pointLabelGlobalOptions, dataset.pointLabel);
							if(pointLabelOptions.display){
			
								var indexValue = dataset.data[index];
			
								if(indexValue != null && (indexValue != 0 || !pointLabelOptions.skipZero)){
									var tooltipPosition = c.tooltipPosition();
									var x = tooltipPosition.x;
									var y = tooltipPosition.y;
				
									if(chartType === 'line' || chartType === 'bar'){
										if (indexValue >= 0) {
											ctx.textBaseline = "bottom";
											y -= pointLabelOptions.padding;
										} else {
											ctx.textBaseline = "top";
											y += pointLabelOptions.padding;
										}
										ctx.textAlign = 'center';
				
									} else if(chartType === 'horizontalBar'){
										if (indexValue >= 0){
											ctx.textAlign = 'left';
											x += pointLabelOptions.padding;
										} else {
											ctx.textAlign = 'right';
											x -= pointLabelOptions.padding;
										}
										ctx.textBaseline = "middle";
						
									} else if(chartType === 'pie' || chartType === 'doughnut' || chartType === 'polarArea'){
										ctx.textAlign = 'center';
										ctx.textBaseline = "middle";
				
									}
				
									ctx.font = pointLabelOptions.fontStyle + ' ' + pointLabelOptions.fontSize + 'px ' + pointLabelOptions.fontFamily;
									ctx.fillStyle = helpers.getValueAtIndexOrDefault(pointLabelOptions.fontColor, index, pointLabelOptions.fontColor);
									ctx.fillText(pointLabelOptions.getLabel(indexValue, chartInstance), x, y);
								}
							}
						}
                    }),chartInstance);
				}
            }),chartInstance);
		}
	}
});
