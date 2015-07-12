
 $(function() {
    
	$( "#txtfecha" ).datepicker({
		/*showOn: "button",
		buttonImage: "images/calendar.gif",
		buttonImageOnly: true,*/
		dateFormat: 'yy-mm-dd',
		changeMonth:true,
		changeYear:true,
		yearRange:'-100:+0',
		showAnim: 'slideDown',
		autoclose: true,
		});
	$("#txtfechaCita").datepicker({
		minDate: 0,
		maxDate:7,
		dateFormat: 'yy-mm-dd',
		showAnim: 'slideDown',
		autoclose: true,
	});
  });