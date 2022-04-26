$(document).ready(function(){
	
	$.ajax({
		
		url:"https://apis.data.go.kr/3740000/suwonEvChrstn/getdatalist?serviceKey=033N%2Fclu5wO9iSA%2FIwTkOaXO4zp3MQ707sWmnYC6E2dPjkqGSmna1XHJYB5gCfIXeq4vMf7l8z64kckLQ3xSoA%3D%3D&numOfRows=10&pageNo=0&sortKey=chrstnType&filterKey=chrstnType&filterValues=DC%EC%BD%A4%EB%B3%B4&type=Json",
		type:"GET",
		dataType:"Json",
		
		success:function(data){
			
			let api_data ="";
			$.each(data.items, function(key, value){
				api_data+="<tr>"
				api_data+="<td>"+(key+1)+"</td>"
				api_data+="<td>"+value.chrstnNm+"</td>"
				api_data+="<td>"+value.useOpenTime+"</td>"
				api_data+="<td>"+value.rdnmadr+"</td>"
				api_data+="<td>"+value.location_detail+"</td>"
				api_data+="</tr>"	
			})
			
			$('#member_table').append(api_data);
			
		}
	})
	
});