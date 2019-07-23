isMobile();
//let lazyload class img lazyload
lazyload();
var touch = true;
addtouch();

function isMobile(){
	if(navigator.userAgent.match(/(iphone|android);?/i)){
		$("body").addClass("ismobile");
	}
}
function addtouch(element){
	element = element || ".change-top";
	$(element).on("touchend", touchEnd);
	$(element).on("touchstart", touchStart);
	$(element).on("touchmove", touchMove);
}
function touchStart(event){
	touch = true;
}
function touchMove(event){
	touch = false;
}
function touchEnd(event){
	if(touch){
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
}
//initial chosen-select dropdown
//run latest because run in mobile maybe crash
$( ".chosen-select" ).chosen({
	search_contains: true,
	allow_single_deselect: true
});