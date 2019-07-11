// 選單1(冷飲、熱飲、不拘)
$('.filter_category').on("click", function() {
	var myElement = document.getElementById("btnGroupDrop1");
	myElement.setAttribute('value', this.value);
	if (this.value == 'cold') {
		myElement.innerHTML = "冷飲";
	} else if (this.value == 'hot') {
		myElement.innerHTML = "熱飲";
	} else {
		myElement.innerHTML = "不拘";
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
		myElement.innerHTML = "找縣市";
	} else if (this.value == 'district') {
		myElement.innerHTML = "找區域";
	} else if (this.value == 'store') {
		myElement.innerHTML = "找店家";
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
		myElement.innerHTML = "依照總分";
	} else if (this.value == 'createdDtm') {
		myElement.innerHTML = "依照時間";
	} else if (this.value == 'bubbleRatePR') {
		myElement.innerHTML = "珍珠彈性";
	} else if (this.value == 'teaRatePR') {
		myElement.innerHTML = "奶茶口感";
	} else if (this.value == 'godfeelingRate') {
		myElement.innerHTML = "小編評比";
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