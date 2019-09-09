// 選單1(冷飲、熱飲、不拘)
$('.filter_category').on("click", function() {
	var myElement = document.getElementById("btnGroupDrop1");
	myElement.setAttribute('value', this.value);
	if (this.value == 'cold') {
		switch(Cookies.get('lang')) {
		    case "en":
		    	myElement.innerHTML = "Cold";
		    	break;
		    case "ja":
		    	myElement.innerHTML = "\u30A2\u30A4\u30B9";
		    	break;
		    case "zh":
		    	myElement.innerHTML = "冷飲";
		    	break;
		    default:
		    	switch(getBrowserLang()) {
				    case "en":
				    	myElement.innerHTML = "Cold";
				    	break;
				    case "ja":
				    	myElement.innerHTML = "\u30A2\u30A4\u30B9";
				    	break;
				    case "zh":
				    	myElement.innerHTML = "冷飲";
				    	break;
				    default:
				    	myElement.innerHTML = "冷飲";
			    }
	    }
	} else if (this.value == 'hot') {
		switch(Cookies.get('lang')) {
		    case "en":
		    	myElement.innerHTML = "Hot";
		    	break;
		    case "ja":
		    	myElement.innerHTML = "\u30DB\u30C3\u30C8";
		    	break;
		    case "zh":
		    	myElement.innerHTML = "熱飲";
		    	break;
		    default:
		    	switch(getBrowserLang()) {
				    case "en":
				    	myElement.innerHTML = "Hot";
				    	break;
				    case "ja":
				    	myElement.innerHTML = "\u30DB\u30C3\u30C8";
				    	break;
				    case "zh":
				    	myElement.innerHTML = "熱飲";
				    	break;
				    default:
				    	myElement.innerHTML = "熱飲";
			    }
	    }
	} else {
		switch(Cookies.get('lang')) {
		    case "en":
		    	myElement.innerHTML = "All";
		    	break;
		    case "ja":
		    	myElement.innerHTML = "\u3059\u3079\u3066";
		    	break;
		    case "zh":
		    	myElement.innerHTML = "不拘";
		    	break;
		    default:
		    	switch(getBrowserLang) {
				    case "en":
				    	myElement.innerHTML = "All";
				    	break;
				    case "ja":
				    	myElement.innerHTML = "\u3059\u3079\u3066";
				    	break;
				    case "zh":
				    	myElement.innerHTML = "不拘";
				    	break;
				    default:
				    	myElement.innerHTML = "不拘";
			    }
	    }
	}
	var url = "/querykeyword";
	$.ajax({
		url : url,
		type : 'get',
		async : false,
		data : {
			"First" : document.getElementById("btnGroupDrop1").value,
			"Second" : document.getElementById("btnGroupDrop2").value,
		},
		success : function(data) {
			query_result = data;
			chosenOptionChange(query_result);
		}
	})
});

// 選單2(縣市、區域、店家)
$('.filter_region').on("click", function() {
	var myElement = document.getElementById("btnGroupDrop2");
	myElement.setAttribute('value', this.value);
	if (this.value == 'city') {
		switch(Cookies.get('lang')) {
		    case "en":
		    	myElement.innerHTML = "County";
		    	break;
		    case "ja":
		    	myElement.innerHTML = "\u770C";
		    	break;
		    case "zh":
		    	myElement.innerHTML = "找縣市";
		    	break;
		    default:
		    	switch(getBrowserLang()) {
				    case "en":
				    	myElement.innerHTML = "County";
				    	break;
				    case "ja":
				    	myElement.innerHTML = "\u770C";
				    	break;
				    case "zh":
				    	myElement.innerHTML = "找縣市";
				    	break;
				    default:
				    	myElement.innerHTML = "找縣市";
			    }
	    }
	} else if (this.value == 'district') {
		switch(Cookies.get('lang')) {
		    case "en":
		    	myElement.innerHTML = "District";
		    	break;
		    case "ja":
		    	myElement.innerHTML = "\u304E\u304F";
		    	break;
		    case "zh":
		    	myElement.innerHTML = "找區域";
		    	break;
		    default:
		    	switch(getBrowserLang()) {
				    case "en":
				    	myElement.innerHTML = "District";
				    	break;
				    case "ja":
				    	myElement.innerHTML = "\u304E\u304F";
				    	break;
				    case "zh":
				    	myElement.innerHTML = "找區域";
				    	break;
				    default:
				    	myElement.innerHTML = "找區域";
			    }
	    }
	} else if (this.value == 'store') {
		switch(Cookies.get('lang')) {
		    case "en":
		    	myElement.innerHTML = "Store";
		    	break;
		    case "ja":
		    	myElement.innerHTML = "\u5E97\u8217";
		    	break;
		    case "zh":
		    	myElement.innerHTML = "找店家";
		    	break;
		    default:
		    	switch(getBrowserLang()) {
				    case "en":
				    	myElement.innerHTML = "Store";
				    	break;
				    case "ja":
				    	myElement.innerHTML = "\u5E97\u8217";
				    	break;
				    case "zh":
				    	myElement.innerHTML = "找店家";
				    	break;
				    default:
				    	myElement.innerHTML = "找店家";
			    }
	    }
	}
	var url = "/querykeyword";
	$.ajax({
		url : url,
		type : 'get',
		async : false,
		data : {
			"First" : document.getElementById("btnGroupDrop1").value,
			"Second" : document.getElementById("btnGroupDrop2").value
		},
		success : function(data) {
			query_result = data;
			chosenOptionChange(query_result);
		}
	})
});

// 排序
$('.dropdown-item.sort').on("click", function() {
	var myElement = document.getElementById("btnGroupDrop3");
	myElement.setAttribute('value', this.value);
	if (this.value == 'totalRate') {
		switch(Cookies.get('lang')) {
		    case "en":
		    	myElement.innerHTML = "Overall Ranking";
		    	break;
		    case "ja":
		    	myElement.innerHTML = "\u30E9\u30F3\u30AD\u30F3\u30B0";
		    	break;
		    case "zh":
		    	myElement.innerHTML = "依照總分";
		    	break;
		    default:
		    	switch(getBrowserLang()) {
				    case "en":
				    	myElement.innerHTML = "Overall Ranking";
				    	break;
				    case "ja":
				    	myElement.innerHTML = "\u30E9\u30F3\u30AD\u30F3\u30B0";
				    	break;
				    case "zh":
				    	myElement.innerHTML = "依照總分";
				    	break;
				    default:
				    	myElement.innerHTML = "依照總分";
			    }
	    }
	} else if (this.value == 'createdDtm') {
		switch(Cookies.get('lang')) {
		    case "en":
		    	myElement.innerHTML = "Recently";
		    	break;
		    case "ja":
		    	myElement.innerHTML = "\u30A2\u30C3\u30D7\u30ED\u30FC\u30C9\u65E5";
		    	break;
		    case "zh":
		    	myElement.innerHTML = "依照時間";
		    	break;
		    default:
		    	switch(getBrowserLang()) {
				    case "en":
				    	myElement.innerHTML = "Recently";
				    	break;
				    case "ja":
				    	myElement.innerHTML = "\u30A2\u30C3\u30D7\u30ED\u30FC\u30C9\u65E5";
				    	break;
				    case "zh":
				    	myElement.innerHTML = "依照時間";
				    	break;
				    default:
				    	myElement.innerHTML = "依照時間";
			    }
	    }
	} else if (this.value == 'bubbleRatePR') {
		switch(Cookies.get('lang')) {
		    case "en":
		    	myElement.innerHTML = "Pearls\u2018 Bounciness";
		    	break;
		    case "ja":
		    	myElement.innerHTML = "\u30BF\u30D4\u30AA\u30AB\u306E\u5F3E\u529B";
		    	break;
		    case "zh":
		    	myElement.innerHTML = "珍珠彈性";
		    	break;
		    default:
		    	switch(getBrowserLang()) {
				    case "en":
				    	myElement.innerHTML = "Pearls\u2018 Bounciness";
				    	break;
				    case "ja":
				    	myElement.innerHTML = "\u30BF\u30D4\u30AA\u30AB\u306E\u5F3E\u529B";
				    	break;
				    case "zh":
				    	myElement.innerHTML = "珍珠彈性";
				    	break;
				    default:
				    	myElement.innerHTML = "珍珠彈性";
			    }
	    }
	} else if (this.value == 'teaRatePR') {
		switch(Cookies.get('lang')) {
		    case "en":
		    	myElement.innerHTML = "Milk\u2019s Richness";
		    	break;
		    case "ja":
		    	myElement.innerHTML = "\u30DF\u30EB\u30AF\u30C6\u30A3\u30FC\u306E\u5B58\u5728\u611F";
		    	break;
		    case "zh":
		    	myElement.innerHTML = "奶茶口感";
		    	break;
		    default:
		    	switch(getBrowserLang()) {
				    case "en":
				    	myElement.innerHTML = "Milk\u2019s Richness";
				    	break;
				    case "ja":
				    	myElement.innerHTML = "\u30DF\u30EB\u30AF\u30C6\u30A3\u30FC\u306E\u5B58\u5728\u611F";
				    	break;
				    case "zh":
				    	myElement.innerHTML = "奶茶口感";
				    	break;
				    default:
				    	myElement.innerHTML = "奶茶口感";
			    }
	    }
	} else if (this.value == 'godfeelingRate') {
		switch(Cookies.get('lang')) {
		    case "en":
		    	myElement.innerHTML = "B.R.\u2018s Review";
		    	break;
		    case "ja":
		    	myElement.innerHTML = "B.R.\u30EC\u30D3\u30E5\u30FC";
		    	break;
		    case "zh":
		    	myElement.innerHTML = "小編評比";
		    	break;
		    default:
		    	switch(getBrowserLang()) {
				    case "en":
				    	myElement.innerHTML = "B.R.\u2018s Review";
				    	break;
				    case "ja":
				    	myElement.innerHTML = "B.R.\u30EC\u30D3\u30E5\u30FC";
				    	break;
				    case "zh":
				    	myElement.innerHTML = "小編評比";
				    	break;
				    default:
				    	myElement.innerHTML = "小編評比";
			    }
	    }
	}
});

// 搜尋
$('#GO').on("click", function() {
	// index 回到1 (重新搜尋至多12筆資料)
	index = 1;
	data_condition.cold = $(`#btnGroupDrop1`).val();
	data_condition.criteria = $(`#btnGroupDrop2`).val();
	data_condition.orderby = $(`#btnGroupDrop3`).val();
	data_condition.keyword = $(`#query_suggeest`).val();
	data_condition.limitNumEnd = 13;
	if(data_condition.keyword == "搜尋更多..."){
		data_condition.keyword = "";
	}
	console.log(data_condition);
	var url = '/search';
	$.ajax({
		url : url,
		type : 'get',
		data : data_condition,
		success : function(data) {
			$('#searchPack').html(data);
			$("#bu").show();
			bindLoadButton();
			addtouch();
		}
	});
});

// select選單替換方法
function chosenOptionChange(query_result) {
	myElement = document.getElementById("query_suggeest");
	$("#query_suggeest").empty();
	console.log(query_result);
	for (i = 0; i < query_result.length; i++) {
		var newOption = document.createElement("option");
		if(query_result[i] == null){
			query_result[i] = "";
		}
		newOption.value = query_result[i];
		newOption.innerHTML = query_result[i];
		myElement.appendChild(newOption);
	}
	$("#query_suggeest").trigger("chosen:updated");
	console.log(query_result);
}