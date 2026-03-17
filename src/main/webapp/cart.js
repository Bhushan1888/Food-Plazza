function searchdata(a)
{
	var fname1 = document.getElementById("fname").value;
	var price1 = document.getElementById("fprice").value;
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange= ()=>
	{
		if(xhr.status == 200 && xhr.readyState == 4)
		{
			console.log("Data send successfully...");
		}
	}
	
	//prepare the request
	xhr.open("POST" ,"adddata.jsp?q="+a+"&fname="+fname1+"&fprice="+price1, true);
	
	//send the request
	
	xhr.send();
}
searchdata(a);