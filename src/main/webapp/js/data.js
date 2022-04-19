$(document).ready(function(){
	
	const json = './json/data.json';
	$.getJSON(json, function(data){
		console.log(data);
		
		let memberData = "";
		
		$.each(data['people'], function(key, value){
			/*
			memberData+="<tr>";
			memberData+="<td>"+value.name+"</td>"
			memberData+="<td>"+value.age+"</td>"
			memberData+="<td>"+value.address+"</td>"
			memberData+="</tr>"
			*/
			memberData+=`<tr><td>${value.name}</td><td>${value.age}</td><td>${value.address}</td></tr>`
		});
		
		console.log(memberData);
		$("#member_table").append(memberData);
	});
	
});