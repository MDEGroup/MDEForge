/* ==========================================================
 * QuickAdmin v1.4.0
 * sliders.js
 * 
 * http://www.mosaicpro.biz
 * Copyright MosaicPro
 *
 * Built exclusively for sale @Envato Marketplaces
 * ========================================================== */ 

$(function()
{
	/* jQRangeSliders */
	
	
	
	/*
	 * JQueryUI Slider: Range fixed minimum
	 */
	if ($('.slider-range-min').size() > 0)
	{
		$( ".slider-range-min .slider" ).slider({
			create: JQSliderCreate,
            range: "min",
            value: $( "#actual_threshold" ).val(),
            min: 0,
            max: 99,
            slide: function( event, ui ) {
                $( ".slider-range-min .amount" ).val( "0." + ui.value );
            },
            start: function() { if (typeof mainYScroller != 'undefined') mainYScroller.disable(); },
	        stop: function() { if (typeof mainYScroller != 'undefined') mainYScroller.enable(); }
        });
        $( ".slider-range-min .amount" ).val( "0." + $( ".slider-range-min .slider" ).slider( "value" ) );
	}
	

});