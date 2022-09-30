<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script>
	$(function() {
		refreshPage();
		/* $('#delete').on('click',cartDeleteStorage);
		$("#tbody").on("click", "#plus", addQuantity);
		$("#tbody").on("click", "#minus", minusQuantity); */
	});
	
/* 	function addQuantity(){
		var key = $(this).attr("name");
		var strPrice = "#" + key;
		var strQuantity = "#" + key + "quantity";
		var quantity = $(strQuantity).text();
		$(strQuantity).text(parseInt(quantity) + 1);
		$("#price").html(parseInt($("#price").text()) + parseInt($(strPrice).text()));
	}
	
	function minusQuantity(){
		var key = $(this).attr("name");
		var strPrice = "#" + key;
		var strQuantity = "#" + key + "quantity";
		var quantity = $(strQuantity).text();
		if(quantity != '1'){
			$(strQuantity).text(parseInt(quantity) - 1);
			$("#price").html(parseInt($("#price").text()) - parseInt($(strPrice).text()));
		}
	} */
	function refreshPage() {
		var html = "";
		var totalPrice = 0;
		for ( var key in localStorage) {
			if (key == "length")
				break;
			var data = localStorage.getItem(key).split(",");
			html += "<tr><td>"
					+ key
					+ "</td><td>"
					+ data[1]
					+ "</td><td id='"+ key +"'>"
					+ data[2]
					+ "</td></tr>";
			$("#tbody").html(html);
		}
	} //
	
	function cartDeleteStorage() {
        if($('[type=checkbox]:checked').length==0){
            return false;
        }
        $('[type=checkbox]:checked').each(function(){
            localStorage.removeItem($(this).val());
        });
        refreshPage();
    }
</script>
<style>
.title{
	text-align: center;
	font-weight: 900;
}
table thead tr th{
	text-align: center;
	background-color: blueviolet;
	color: white;
}
table td{
	text-align: center;
	vertical-align: middle !important;
	border: 2px solid blueviolet;
}
#delete, #plus, #minus{
	background-color: blueviolet;
	border: 1px solid white;
	color: white;
}
#plus, #minus{
	width: 30px;
}
span{
	color: blueviolet;
	font-weight: 500;
}
</style>
</head>
<body>
	<div class="container">
  		<h2 class="title">장바구니</h2>
			<table class="table table-hover">
				<thead class="thead-primary">
					<tr>
						<th>번호</th>
						<th>모델</th>
						<th>가격</th>
					</tr>
				</thead>
				<tbody id="tbody"></tbody>
			</table>
	</div>
</body>
</html>