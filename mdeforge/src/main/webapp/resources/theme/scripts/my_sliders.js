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
	
	/*
	 * JQueryUI Slider: Range fixed minimum
	 */
	if ($('.slider-range-min2').size() > 0)
	{
		$( ".slider-range-min2 .slider" ).slider({
			create: JQSliderCreate,
            range: "min",
            value: $( "#actual_threshold" ).val(),
            min: 0,
            max: 99,
            slide: function( event, ui ) {
                $( ".slider-range-min2 .amount" ).val( "0." + ui.value );
            },
            start: function() { if (typeof mainYScroller != 'undefined') mainYScroller.disable(); },
	        stop: function() { if (typeof mainYScroller != 'undefined') mainYScroller.enable(); }
        });
        $( ".slider-range-min2 .amount" ).val( "0." + $( ".slider-range-min2 .slider" ).slider( "value" ) );
	}
	
	/*
	 * JQueryUI Slider: Range fixed minimum
	 */
	if ($('.slider-range-min3').size() > 0)
	{
		$( ".slider-range-min3 .slider" ).slider({
			create: JQSliderCreate,
            range: "min",
            value: $( "#actual_threshold" ).val(),
            min: 0,
            max: 99,
            slide: function( event, ui ) {
                $( ".slider-range-min3 .amount" ).val( "0." + ui.value );
            },
            start: function() { if (typeof mainYScroller != 'undefined') mainYScroller.disable(); },
	        stop: function() { if (typeof mainYScroller != 'undefined') mainYScroller.enable(); }
        });
        $( ".slider-range-min3 .amount" ).val( "0." + $( ".slider-range-min3 .slider" ).slider( "value" ) );
	}
	
	/*
	 * JQueryUI Slider: Range fixed minimum
	 */
	if ($('.slider-range-min4').size() > 0)
	{
		$( ".slider-range-min4 .slider" ).slider({
			create: JQSliderCreate,
            range: "min",
            value: $( "#actual_threshold" ).val(),
            min: 0,
            max: 99,
            slide: function( event, ui ) {
                $( ".slider-range-min4 .amount" ).val( "0." + ui.value );
            },
            start: function() { if (typeof mainYScroller != 'undefined') mainYScroller.disable(); },
	        stop: function() { if (typeof mainYScroller != 'undefined') mainYScroller.enable(); }
        });
        $( ".slider-range-min4 .amount" ).val( "0." + $( ".slider-range-min4 .slider" ).slider( "value" ) );
	}
	
	
	
	 
//	if ($('.range-slider').size() > 0)
//    {
//		$( ".range-slider .slider" ).slider({
//			create: JQSliderCreate,
//	        range: true,
//	        min: 0,
//	        max: 99,	    
//	        values: [ 3, 99 ],
//	       
//	        slide: function( event, ui ) {
//	            $( ".range-slider .amount" ).val( "0." + ui.values[ 0 ] + " - 0." + ui.values[ 1 ] );
//	        },
//	        start: function() { if (typeof mainYScroller != 'undefined') mainYScroller.disable(); },
//	        stop: function() { if (typeof mainYScroller != 'undefined') mainYScroller.enable(); }
//	    });
//    	$( ".range-slider .amount" ).val( "0." + $( ".range-slider .slider" ).slider( "values", 0 ) +
//    			" - 0." + $( ".range-slider .slider" ).slider( "values", 1 ) );
//    	$ (".range-slider .slider:first").draggable( false);
//    }
//	

});