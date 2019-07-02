function bindLoadButton(){
	$('#loadButton').on("click",function () {
		var url = '/loadsix?';
		console.log(data_condition);
		console.log("aaaa");
		data_condition.token = index;
		$.ajax({
			url: url,
			type: 'get',
			data: data_condition,
			success: function (data) {
				note = data
				console.log(data);
				loadsix(data);
			}
		});
// url = '/loadbu?';
// $.ajax({
// url: url,
// type: 'get',
// data: {
// token:token,
// },
// success: function (data) {
// console.log(data);
// $('#bu').html(data);
// },
// error: function (error) {
// }
// })
		index++;
	});
}
	
  
function loadsix(data){
	console.log("into loadsix");
	for(var i = 0 ; i < data.blogs.length ; i ++){
		var divId = $("<div>").attr({id:`search${data.blogs[i].blogId}`}).addClass("col-md-4 text-white change-top");
		var div2 = $("<div>").addClass("otherinfo change-first");
		var img = $("<img>").attr({src:`${data.blogs[i].photoLink}`}).addClass("img-fluid lazyload");
		var div2_1 = $("<div>");
		var div2_1_1 = $("<div>").addClass("bg-blur");
		var tableTextCenter = $("<table>").addClass("storename text-center");
		var textCenterTr1 = $("<tr>");
		var textCenterTd1_1 = $("<td>").append(`<div>${data.blogs[i].storeBrand}${data.blogs[i].storeCity}-${data.blogs[i].storeDistrict}</div>`);
		var textCenterTd1_2 = $("<td>").attr({rowspan:"2"}).append(`<div>${data.blogs[i].totalRate.toFixed(1)}</div>`);
		textCenterTr1.append(textCenterTd1_1).append(textCenterTd1_2);
		var textCenterTr2 = $("<tr>");
		var textCenterTd2_1 = $("<td>").append(`<div>${data.blogs[i].item}</div>`);
		textCenterTr2.append(textCenterTd2_1);
		tableTextCenter.append(textCenterTr1).append(textCenterTr2);
		div2_1_1.append(tableTextCenter);
		div2_1.append(div2_1_1);
		div2.append(img).append(div2_1);
		divId.append(div2);
		
		var div3 = $("<div>").addClass("othercomment change-second bg-blur");
		var tableStoreName = $("<table>").addClass("storename");
		var storeNameTr1 = $("<tr>").append(`<td><div>${data.blogs[i].storeBrand}</div></td>`)
		                    .append(`<td rowspan="2"><div class="text-center">${data.blogs[i].totalRate.toFixed(1)}</div></td>`);
		var storeNameTr2 = $("<tr>").append(`<td><div>${data.blogs[i].item}</div></td>`);
		tableStoreName.append(storeNameTr1).append(storeNameTr2);
		
		var tableScoretable = $("<table>").addClass("scoretable");
		var ScoreTableTr1 = $("<tr>").append(`<td>珍珠彈性</td>`).append(`<td>${data.blogs[i].bubbleRatePR.toFixed(1)}</td>`)
		                    .append(`<td>珍探給分</td>`).append(`<td>${data.blogs[i].godfeelingRate.toFixed(1)}</td>`);
		var ScoreTableTr2 = $("<tr>").append(`<td>奶茶濃度</td>`).append(`<td>${data.blogs[i].teaRatePR.toFixed(1)}</td>`)
		                    .append(`<td>甜度等級</td>`).append(`<td>${data.blogs[i].sweetness}</td>`);
		tableScoretable.append(ScoreTableTr1).append(ScoreTableTr2);
		
		var p = $("<p>").addClass("comment").text(`${data.blogs[i].content1}`);
		var btnClickModal = $("<button>").attr({id:`btnClickModal${data.blogs[i].blogId}`,type:"button","data-toggle":"modal","data-target":"#myModal"}).text("顯示更多")
		                    .addClass("btn btn-outline-light btn-sm modal-btn")
		                    .on("click", function(){
		                      var btnId = $(this).attr("id");
		                      var id = btnId.substr(13);
		                      openModal(id);
		                    });
		var divInvisible = $("<div>").attr({id:`invisibleId${data.blogs[i].blogId}`}).addClass("invisible").text(`${data.blogs[i].blogId}`);
		div3.append(tableStoreName).append(tableScoretable).append(p).append(btnClickModal).append(divInvisible);
		divId.append(div3);
		
		var div4 = $("<div>").addClass("newstore").text("新 進 榜");
		divId.append(div4);
		var styleString = `<style type="text/css">
		                    #search${data.blogs[i].blogId} .otherinfo .bg-blur:before, #search${data.blogs[i].blogId} .othercomment:before {
		                      background-image: url("${data.blogs[i].photoLink}");
		                    }
		                  </style>`;
		divId.append(styleString);
		$("#blogAppend").append(divId);
	}
}