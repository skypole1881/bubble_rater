function bindLoadButton(){
	$('#loadButton').on("click",function () {
		var url = '/loadsix?';
		console.log(data_condition);
		data_condition.token = index;
		$.ajax({
			url: url,
			type: 'get',
			data: data_condition,
			success: function (data) {
				note = data
				loadsix(data);
			}
		});
		index++;
	});
}
//query string array
function getUrlVars()
{
    var vars = [], hash;
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for(var i = 0; i < hashes.length; i++)
    {
        hash = hashes[i].split('=');
        vars.push(hash[0]);
        vars[hash[0]] = hash[1];
    }
    return vars;
}
  
function loadsix(data){
	if(data.num == false){
		$("#bu").hide();
	}
    switch(Cookies.get('lang')) {
	    case "en":
	    	loadsixEn(data);
	    	break;
	    case "ja":
		    loadsixJa(data);
	    	break;
	    case "zh":
		    loadsixDefault(data);
	    	break;
	    default:
	    	switch(getBrowserLang()) {
			    case "en":
			    	loadsixEn(data);
			    	break;
			    case "ja":
				    loadsixJa(data);
			    	break;
			    case "zh":
				    loadsixDefault(data);
			    	break;
			    default:
			    	loadsixDefault(data);
		    }
    }
}
function loadsixDefault(data){
	for(var i = 0 ; i < data.blogs.length ; i ++){
		var divId = $("<div>").attr({id:`search${data.blogs[i].blogId}`}).addClass("col-md-4 text-white otherstore change-top");
		addtouch(divId);
		var div2 = $("<div>").addClass("otherinfo");
//		var img = $("<img>").attr({src:`${data.blogs[i].photoLink}`}).addClass("img-fluid lazyload");
		var div2_1 = $("<div>").addClass("bg-blur");
		var tableTextCenter = $("<table>").addClass("storename text-center");
		var textCenterTr1 = $("<tr>");
		var textCenterTd1_1 = $("<td>").append(`<div>${data.blogs[i].storeBrand}</div>`);
		var textCenterTd1_2 = $("<td>").attr({rowspan:"3"}).append(`<div>${data.blogs[i].totalRate.toFixed(1)}</div>`);
		textCenterTr1.append(textCenterTd1_1).append(textCenterTd1_2);
		var textCenterTr2 = $("<tr>");
		var textCenterTd2_1 = $("<td>").append(`<div>${data.blogs[i].storeCity}-${data.blogs[i].storeDistrict}</div>`);
		textCenterTr2.append(textCenterTd2_1);
		var textCenterTr3 = $("<tr>");
		if(data.blogs[i].cold == false){
			var textCenterTd3_1 = $("<td>").append(`<div>${data.blogs[i].item} (熱)</div>`);
		}else {
			var textCenterTd3_1 = $("<td>").append(`<div>${data.blogs[i].item}</div>`);
		}
		textCenterTr3.append(textCenterTd3_1);
		tableTextCenter.append(textCenterTr1).append(textCenterTr2).append(textCenterTr3);
		div2_1.append(tableTextCenter);
		div2.append(div2_1);
		divId.append(div2);
		
		var div3 = $("<div>").addClass("othercomment change-second bg-blur");
		var div3_1 = $("<div>");
		var tableStoreName = $("<table>").addClass("storename");
		var storeNameTr1 = $("<tr>").append(`<td><div>${data.blogs[i].storeBrand}</div></td>`)
		                    .append(`<td rowspan="2"><div class="text-center">${data.blogs[i].totalRate.toFixed(1)}</div></td>`);
		if(data.blogs[i].cold == false){
			var storeNameTr2 = $("<tr>").append(`<td><div>${data.blogs[i].item} (熱)</div></td>`);
		}else{
			var storeNameTr2 = $("<tr>").append(`<td><div>${data.blogs[i].item}</div></td>`);
		}
		tableStoreName.append(storeNameTr1).append(storeNameTr2);
		
		var tableScoretable = $("<table>").addClass("scoretable");
		var ScoreTableTr1 = $("<tr>").append(`<td>珍珠彈性</td>`).append(`<td>${data.blogs[i].bubbleRatePR.toFixed(1)}</td>`)
		                    .append(`<td>珍探給分</td>`).append(`<td>${data.blogs[i].godfeelingRate.toFixed(1)}</td>`);
		var ScoreTableTr2 = $("<tr>").append(`<td>奶茶濃度</td>`).append(`<td>${data.blogs[i].teaRatePR.toFixed(1)}</td>`)
		                    .append(`<td>甜度等級</td>`).append(`<td>${data.blogs[i].sweetness}</td>`);
		tableScoretable.append(ScoreTableTr1).append(ScoreTableTr2);
		
		var p = $("<p>").addClass("comment").html(`${data.blogs[i].content1}`);
		var btnClickModal = $("<button>").attr({id:`btnClickModal${data.blogs[i].blogId}`,type:"button","data-toggle":"modal","data-target":"#myModal"}).text("顯示更多")
		                    .addClass("btn btn-outline-light btn-sm modal-btn")
		                    .on("click", function(){
		                      var btnId = $(this).attr("id");
		                      var id = btnId.substr(13);
		                      openModal(id);
		                    });
		var singlelink = $("<a>").attr({href:`/single/${data.blogs[i].blogId}`}).text("顯示更多").addClass("btn btn-outline-light btn-sm single-link");
		var divInvisible = $("<div>").attr({id:`invisibleId${data.blogs[i].blogId}`}).addClass("d-none").text(`${data.blogs[i].blogId}`);
		div3_1.append(tableStoreName).append(tableScoretable).append(p).append(btnClickModal).append(singlelink).append(divInvisible);
		div3.append(div3_1);
		divId.append(div3);
		
		if(data.blogs[i].latest == true){
			var div4 = $("<div>").addClass("newstore").text("新 進 榜");
			divId.append(div4);
		}
		var styleString = `<style type="text/css">
		                    #search${data.blogs[i].blogId}:before, #search${data.blogs[i].blogId} .otherinfo .bg-blur:before {
		                      background-image: url("${data.blogs[i].photoLink}");
		                    }
		                  </style>`;
		divId.append(styleString);
		$("#blogAppend").append(divId);
	}
}
function loadsixEn(data){
	for(var i = 0 ; i < data.blogs.length ; i ++){
		var divId = $("<div>").attr({id:`search${data.blogs[i].blogId}`}).addClass("col-md-4 text-white otherstore change-top");
		addtouch(divId);
		var div2 = $("<div>").addClass("otherinfo");
//		var img = $("<img>").attr({src:`${data.blogs[i].photoLink}`}).addClass("img-fluid lazyload");
		var div2_1 = $("<div>").addClass("bg-blur");
		var tableTextCenter = $("<table>").addClass("storename text-center");
		var textCenterTr1 = $("<tr>");
		var textCenterTd1_1 = $("<td>").append(`<div>${data.blogs[i].storeBrand}</div>`);
		var textCenterTd1_2 = $("<td>").attr({rowspan:"3"}).append(`<div>${data.blogs[i].totalRate.toFixed(1)}</div>`);
		textCenterTr1.append(textCenterTd1_1).append(textCenterTd1_2);
		var textCenterTr2 = $("<tr>");
		var textCenterTd2_1 = $("<td>").append(`<div>${data.blogs[i].storeCity}-${data.blogs[i].storeDistrict}</div>`);
		textCenterTr2.append(textCenterTd2_1);
		var textCenterTr3 = $("<tr>");
		if(data.blogs[i].cold == false){
			var textCenterTd3_1 = $("<td>").append(`<div>${data.blogs[i].item} (熱)</div>`);
		}else {
			var textCenterTd3_1 = $("<td>").append(`<div>${data.blogs[i].item}</div>`);
		}
		textCenterTr3.append(textCenterTd3_1);
		tableTextCenter.append(textCenterTr1).append(textCenterTr2).append(textCenterTr3);
		div2_1.append(tableTextCenter);
		div2.append(div2_1);
		divId.append(div2);
		
		var div3 = $("<div>").addClass("othercomment change-second bg-blur");
		var div3_1 = $("<div>");
		var tableStoreName = $("<table>").addClass("storename");
		var storeNameTr1 = $("<tr>").append(`<td><div>${data.blogs[i].storeBrand}</div></td>`)
		                    .append(`<td rowspan="2"><div class="text-center">${data.blogs[i].totalRate.toFixed(1)}</div></td>`);
		if(data.blogs[i].cold == false){
			var storeNameTr2 = $("<tr>").append(`<td><div>${data.blogs[i].item} (熱)</div></td>`);
		}else{
			var storeNameTr2 = $("<tr>").append(`<td><div>${data.blogs[i].item}</div></td>`);
		}
		tableStoreName.append(storeNameTr1).append(storeNameTr2);
		
		var tableScoretable = $("<table>").addClass("scoretable");
		var ScoreTableTr1 = $("<tr>").append(`<td>Pearls\u2018 Bounciness</td>`).append(`<td>${data.blogs[i].bubbleRatePR.toFixed(1)}</td>`)
		                    .append(`<td>B.R.\u2018s Review</td>`).append(`<td>${data.blogs[i].godfeelingRate.toFixed(1)}</td>`);
		var ScoreTableTr2 = $("<tr>").append(`<td>Milk\u2019s Richness</td>`).append(`<td>${data.blogs[i].teaRatePR.toFixed(1)}</td>`)
		                    .append(`<td>Sweetness</td>`).append(`<td>${data.blogs[i].sweetness}</td>`);
		tableScoretable.append(ScoreTableTr1).append(ScoreTableTr2);
		
		var p = $("<p>").addClass("comment").html(`${data.blogs[i].content1}`);
		var btnClickModal = $("<button>").attr({id:`btnClickModal${data.blogs[i].blogId}`,type:"button","data-toggle":"modal","data-target":"#myModal"}).text("顯示更多")
		                    .addClass("btn btn-outline-light btn-sm modal-btn")
		                    .on("click", function(){
		                      var btnId = $(this).attr("id");
		                      var id = btnId.substr(13);
		                      openModal(id);
		                    });
		var singlelink = $("<a>").attr({href:`/single/${data.blogs[i].blogId}`}).text("顯示更多").addClass("btn btn-outline-light btn-sm single-link");
		var divInvisible = $("<div>").attr({id:`invisibleId${data.blogs[i].blogId}`}).addClass("d-none").text(`${data.blogs[i].blogId}`);
		div3_1.append(tableStoreName).append(tableScoretable).append(p).append(btnClickModal).append(singlelink).append(divInvisible);
		div3.append(div3_1);
		divId.append(div3);
		
		if(data.blogs[i].latest == true){
			var div4 = $("<div>").addClass("newstore").text("NEW");
			divId.append(div4);
		}
		var styleString = `<style type="text/css">
		                    #search${data.blogs[i].blogId}:before, #search${data.blogs[i].blogId} .otherinfo .bg-blur:before {
		                      background-image: url("${data.blogs[i].photoLink}");
		                    }
		                  </style>`;
		divId.append(styleString);
		$("#blogAppend").append(divId);
	}
}
function loadsixJa(data){
	for(var i = 0 ; i < data.blogs.length ; i ++){
		var divId = $("<div>").attr({id:`search${data.blogs[i].blogId}`}).addClass("col-md-4 text-white otherstore change-top");
		addtouch(divId);
		var div2 = $("<div>").addClass("otherinfo");
//		var img = $("<img>").attr({src:`${data.blogs[i].photoLink}`}).addClass("img-fluid lazyload");
		var div2_1 = $("<div>").addClass("bg-blur");
		var tableTextCenter = $("<table>").addClass("storename text-center");
		var textCenterTr1 = $("<tr>");
		var textCenterTd1_1 = $("<td>").append(`<div>${data.blogs[i].storeBrand}</div>`);
		var textCenterTd1_2 = $("<td>").attr({rowspan:"3"}).append(`<div>${data.blogs[i].totalRate.toFixed(1)}</div>`);
		textCenterTr1.append(textCenterTd1_1).append(textCenterTd1_2);
		var textCenterTr2 = $("<tr>");
		var textCenterTd2_1 = $("<td>").append(`<div>${data.blogs[i].storeCity}-${data.blogs[i].storeDistrict}</div>`);
		textCenterTr2.append(textCenterTd2_1);
		var textCenterTr3 = $("<tr>");
		if(data.blogs[i].cold == false){
			var textCenterTd3_1 = $("<td>").append(`<div>${data.blogs[i].item} (熱)</div>`);
		}else {
			var textCenterTd3_1 = $("<td>").append(`<div>${data.blogs[i].item}</div>`);
		}
		textCenterTr3.append(textCenterTd3_1);
		tableTextCenter.append(textCenterTr1).append(textCenterTr2).append(textCenterTr3);
		div2_1.append(tableTextCenter);
		div2.append(div2_1);
		divId.append(div2);
		
		var div3 = $("<div>").addClass("othercomment change-second bg-blur");
		var div3_1 = $("<div>");
		var tableStoreName = $("<table>").addClass("storename");
		var storeNameTr1 = $("<tr>").append(`<td><div>${data.blogs[i].storeBrand}</div></td>`)
		                    .append(`<td rowspan="2"><div class="text-center">${data.blogs[i].totalRate.toFixed(1)}</div></td>`);
		if(data.blogs[i].cold == false){
			var storeNameTr2 = $("<tr>").append(`<td><div>${data.blogs[i].item} (熱)</div></td>`);
		}else{
			var storeNameTr2 = $("<tr>").append(`<td><div>${data.blogs[i].item}</div></td>`);
		}
		tableStoreName.append(storeNameTr1).append(storeNameTr2);
		
		var tableScoretable = $("<table>").addClass("scoretable");
		var ScoreTableTr1 = $("<tr>").append(`<td>\u30BF\u30D4\u30AA\u30AB\u306E\u5F3E\u529B</td>`).append(`<td>${data.blogs[i].bubbleRatePR.toFixed(1)}</td>`)
		                    .append(`<td>B.R.\u30EC\u30D3\u30E5\u30FC</td>`).append(`<td>${data.blogs[i].godfeelingRate.toFixed(1)}</td>`);
		var ScoreTableTr2 = $("<tr>").append(`<td>\u30DF\u30EB\u30AF\u30C6\u30A3\u30FC\u306E\u5B58\u5728\u611F</td>`).append(`<td>${data.blogs[i].teaRatePR.toFixed(1)}</td>`)
		                    .append(`<td>\u7518\u3055</td>`).append(`<td>${data.blogs[i].sweetness}</td>`);
		tableScoretable.append(ScoreTableTr1).append(ScoreTableTr2);
		
		var p = $("<p>").addClass("comment").html(`${data.blogs[i].content1}`);
		var btnClickModal = $("<button>").attr({id:`btnClickModal${data.blogs[i].blogId}`,type:"button","data-toggle":"modal","data-target":"#myModal"}).text("顯示更多")
		                    .addClass("btn btn-outline-light btn-sm modal-btn")
		                    .on("click", function(){
		                      var btnId = $(this).attr("id");
		                      var id = btnId.substr(13);
		                      openModal(id);
		                    });
		var singlelink = $("<a>").attr({href:`/single/${data.blogs[i].blogId}`}).text("顯示更多").addClass("btn btn-outline-light btn-sm single-link");
		var divInvisible = $("<div>").attr({id:`invisibleId${data.blogs[i].blogId}`}).addClass("d-none").text(`${data.blogs[i].blogId}`);
		div3_1.append(tableStoreName).append(tableScoretable).append(p).append(btnClickModal).append(singlelink).append(divInvisible);
		div3.append(div3_1);
		divId.append(div3);
		
		if(data.blogs[i].latest == true){
			var div4 = $("<div>").addClass("newstore").text("\u65B0\u3057\u3044");
			divId.append(div4);
		}
		var styleString = `<style type="text/css">
		                    #search${data.blogs[i].blogId}:before, #search${data.blogs[i].blogId} .otherinfo .bg-blur:before {
		                      background-image: url("${data.blogs[i].photoLink}");
		                    }
		                  </style>`;
		divId.append(styleString);
		$("#blogAppend").append(divId);
	}
}