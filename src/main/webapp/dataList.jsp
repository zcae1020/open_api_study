<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>dataList</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="./js/data.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	</head>
	<body>
	
		<div class="container">
			<h1 style="text-align:center; padding:50px 0">JSON 데이터 리스트</h1>
			<table class="table table-striped"id="member_table">
				<thead>
					<tr>
						<th>No</th>
						<th>충전소명</th>
						<th>사용시간</th>
						<th>도로명주소</th>
						<th>세부위치</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>			
		</div>
		
	</body>
</html>