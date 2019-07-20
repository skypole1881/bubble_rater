//let lazyload class img lazyload
lazyload();
addtouch();
function addtouch(){
	$(".change-top").on("touchend", touchEnd);
}
function touchEnd(event){
	if( $(this).hasClass("touched")){
		$(this).removeClass("touched");
	}
	else{
		$(".touched").addClass("change-top");
		$(".touched").removeClass("touched");
		$(this).addClass("touched");
		$(this).removeClass("change-top");
	}
}
//initial chosen-select dropdown
//run latest because run in mobile maybe crash
$( ".chosen-select" ).chosen({
	search_contains: true,
	allow_single_deselect: true
});