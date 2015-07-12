$(document).ready(main);
function main () {
$('.submenu').click(function(){
		$(this).children('.children').slideToggle();
	});
}