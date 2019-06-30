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
			console.log(data);
			query_result = data;
			chosenOptionChange(query_result)
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

// select選單替換方法
function chosenOptionChange(query_result) {
	myElement = document.getElementById("query_suggeest");
	$("#query_suggeest").empty();
	for (i = 0; i < query_result.length; i++) {
		var newOption = document.createElement("option");
		newOption.value = query_result[i];
		newOption.innerHTML = query_result[i];
		myElement.appendChild(newOption);
	}
	$("#query_suggeest").trigger("chosen:updated");
}
