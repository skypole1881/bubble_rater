//initial chosen-select dropdown
$( ".chosen-select" ).chosen({
	search_contains: true,
	allow_single_deselect: true
});
//let lazyload class img lazyload
lazyload();

$(".change-top").on("touchend", touchEnd);
function touchEnd(event){
	if( $(this).hasClass("store")){
		if( $(this).hasClass("hover")){
			$(this).removeClass("hover");
			// $(this).children(".change-second").css("opacity", 0);
			// $(this).children(".change-first").removeClass("d-none");
			// $(this).children(".change-first").addClass("d-block");
		}
		else{
			// $(".store .change-first.d-none").addClass("d-block");
			// $(".store .change-first.d-none").removeClass("d-none");
			// $(".store .change-second").css("opacity", 0);
			$(".store.hover").removeClass("hover");
			// $(this).children(".change-first").removeClass("d-block");
			// $(this).children(".change-first").addClass("d-none");
			// $(this).children(".change-second").css("opacity", 1);
			$(this).addClass("hover");
		}
	}
	else{
	}
}