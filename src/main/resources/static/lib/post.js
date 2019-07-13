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
		if( $(this).hasClass("bg-black")){
			$(this).removeClass("bg-black");
			$(this).children(".change-second").css("opacity", 0);
			$(this).children(".change-first").removeClass("d-none");
			$(this).children(".change-first").addClass("d-block");
		}
		else{
			$(".store.bg-black .change-first").removeClass("d-none");
			$(".store.bg-black .change-first").addClass("d-block");
			$(".store.bg-black .change-second").css("opacity", 0);
			$(".store.bg-black").removeClass("bg-black");
			$(this).addClass("bg-black");
			$(this).children(".change-first").removeClass("d-block");
			$(this).children(".change-first").addClass("d-none");
			$(this).children(".change-second").css("opacity", 1);
		}
	}
	else{
	}
}