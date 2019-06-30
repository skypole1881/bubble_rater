$('#myModal').on('hidden.bs.modal', function() {
	var stateObj = {
		foo : "bar"
	};
	history.pushState(stateObj, "home.html", "/");
});

function openModal(id) {
	$.ajax({
		url : "/modal/" + id,
		success : function(data) {
			var stateObj = {
				foo : "bar"
			};
			history.pushState(stateObj, "page 2", "/single/" + id);
			modalPrint(data);
		}
	});
}

function modalPrint(data) {
	$("#modalRanking").html(`${data.rank}`);
	$("#modalPhotoLink").attr({
		src : `${data.blog.photoLink}`
	});
	$("#modalStoreBrand").html(`${data.blog.storeBrand}`);
	$("#modalTotalRate").html(`${data.blog.totalRate.toFixed(1)}`);
	$("#modalStoreDistrict").html(`${data.blog.storeDistrict}`);
	$("#modalItem").html(`${data.blog.item}`);
	$("#modalBubbleRatePR").html(`${data.blog.bubbleRatePR.toFixed(1)}`);
	$("#modalTeaRatePR").html(`${data.blog.teaRatePR.toFixed(1)}`);
	$("#modalGodfeelingRate").html(`${data.blog.godfeelingRate.toFixed(1)}`);
	$("#modalSweetness").html(`${data.blog.sweetness}`);
	$("#modalContent").html(`${data.blog.content1}`);
}