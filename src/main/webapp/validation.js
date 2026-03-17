/**
 * 
 */
let flag = 1 ;

function LoginValidation(){
	
	/*type1 = getElementId('type').value;
	if(type1==""){
		document.getElementById('selecterror').innerHTML = "Please enter EmailId :";
		flag=0;
	}*/
	
	email = document.getElementById('email').value;
	if(email==""){
		document.getElementById('emailerror').innerHTML = "Please enter EmailId";
		flag =0;
	}

	pass = document.getElementById('pass').value;
	if(pass==""){
		document.getElementById('passerror').innerHTML = "Please enter Password";
		flag =0;
	}
	
	if(flag)
	{
		return true;
	}
	else{
		return false;
	}
	
}

function ChangePassValidation(){
	
	email = document.getElementById('email').value;
	if(email==""){
		document.getElementById('emailerror').innerHTML = "Please Enter Email";
		/*return false;*/
		flag=0;
	}
	
	pass = document.getElementById('pass').value;
	if(pass==""){
		document.getElementById('passerror').innerHTML = "Please Enter password";
		/*return false;*/
		flag=0;
	}
	
	npass = document.getElementById('npass').value;
	if(npass==""){
		document.getElementById('npasserror').innerHTML = "Please Enter New password";
		/*return false;*/
		flag=0;
	}
	
	cpass = document.getElementById('cpass').value;
	if(cpass==""){
		document.getElementById('cpasserror').innerHTML = "Please Enter Re-Enter password";
		/*return false;*/
		flag=0;
	}
	if(flag)
	{
	return true;
	}
	else{
		return false;
	}
	
}

function  AddCustValidation()
{
	 Name = document.getElementById('cname').value;
	
	if(Name == "")
	{
		document.getElementById('cnameerror').innerHTML = "Please Enter Name";
		flag =0;
	}
	
	email = document.getElementById('email').value;
	if(email == "")
	{
		document.getElementById('emailerror').innerHTML = "Please Enter Email";
		flag =0;
	}
	
	pass = document.getElementById('pass').value;
	if(pass == "")
	{
		document.getElementById('passerror').innerHTML = "Please Enter Password";
		flag =0;
	}
	
	adr = document.getElementById('adr').value;
	if(adr == "")
	{
		document.getElementById('adrerror').innerHTML = "Please Enter Address";
		flag =0;
	}
	
	con = document.getElementById('cNo').value;
	if(adr == "")
	{
		document.getElementById('cNoerror').innerHTML = "Please Enter Contact No";
		flag =0;
	}
	    

	if(con.length!=10)
	{
		document.getElementById('cNoerror').innerHTML = "Please Enter Valid Contact No"
		flag =0;
	}
	
	if(flag)
	{
	return true;
	}
	else{
		return false;
	}
}


function AddFoodValidation()
{
	Name = document.getElementById('fname').value;
	if(Name == "")
	{
		document.getElementById('fnameerror').innerHTML = "Please enter FoodName";	
		flag =0;
	}
	
	type = document.getElementById('ftype').value;
	if(type == "")
	{
		document.getElementById('ftypeerror').innerHTML = "Please Enter FoodType";
		flag = 0;
	}
	
	quan = document.getElementById('fquan').value;
	
	if(quan == "")
	{
		document.getElementById('fquanerror').innerHTML = "Please Enter Quantity";
		flag = 0;
	}
	
	price = document.getElementById('fprice').value;
	
	if(price == "")
	{
		document.getElementById('fpriceerror').innerHTML = "Please Enter Price";
		flag =0;
	}
	
	if(flag)
	{
		return true;
	}
	else{
		return false;
	}
}

function UpdateFoodValidation()
{
	foodId = document.getElementById('fId').value;
	
	if(foodId == "")
	{
		document.getElementById('fiderror').innerHTML = "Please Enter foodId";
		flag =0;
	}
	
	Name = document.getElementById('fname').value;
	if(Name == "")
	{
		document.getElementById('fnameerror').innerHTML = "Please Enter Food Name";
		flag=0;
	}
	
	type = document.getElementById('ftype').value;
	
	if(type == "")
	{
		document.getElementById('ftypeerror').innerHTML = "Please Enter FoodType";
		flag =0;
	}
	
	quan = document.getElementById('fquan').value;
	if(quan == "")
	{
		document.getElementById('fquanerror').innerHTML = "Please Enter Food Quantity";
		flag =0;
	}
	
	price = document.getElementById('fprice').value;
	
	if(price == "")
	{
		document.getElementById('fpriceerror').innerHTML = "Please Enter Food Price";
		flag =0;
	}
	
	if(flag)
	{
		return true;
	}
	else{
		return false;
	}
}

function UpdateCustValidation()
{
	Name = document.getElementById('cname').value;
	if(Name == "")
	{
		document.getElementById('cnameerror').innerHTML = "Please Enter Name";
		flag =0;
	}	
	
	adr = document.getElementById('adr').value;
	if(adr == "")
	{
		document.getElementById('adrerror').innerHTML = "Please Enter Address";
		flag=0;
	}
	
	cNo = document.getElementById('cNo').value;
	if(cNo == "")
	{
		document.getElementById('cNoerror').innerHTML = "Please Enter Contact No";
		flag =0;
	}
	
	if(flag)
	{
		return true;
	}
	else{
		return false;
	}	
}

function AddFeedvalidation()
{
	Name = document.getElementById('cname').value;
	
	if(Name == "")
	{
		document.getElementById('cnameerror').innerHTML="Please Enter Name";
		flag =0;
	}
	
	review = document.getElementById('review').value;
	if(review=="")
	{
		document.getElementById('reviewerror').innerHTML = "Please Enter Review";
		flag =0;
	}
	
	rank = document.getElementById('rank').value;
	if(rank =="")
	{
		document.getElementById('rankerror').innerHTML="Please Enter Rank";
		flag =0;
	}
	
	
	sug = document.getElementById('sug').value;
	if(sug =="")
	{
		document.getElementById('sugerror').innerHTML = "Please Enter Suggestion";
		flag=0;
	}
	
	if(flag)
	{
		return true;
	}
	else{
		return false;
	}
}

function AddToCartValidation()
{
	fId = document.getElementById('fid').value;
	if(fId == "")
	{
		document.getElementById('fiderror').innerHTML = "Please Enter FoodId";
		flag =0;
	}
	
	email = document.getElementById('email').value;
	if(email == "")
	{
		document.getElementById('emailrror').innerHTML = "Please Enter Email";
		flag =0;
	}
	
	Name = document.getElementById('fname').value;
	if(Name == "")
	{
		document.getElementById('fnameerror').innerHTML = "Please Enter Name";
		flag =0;
	}
	
	quan = document.getElementById('fquan').value;
	if(quan == "")
	{
		document.getElementById('fquanerror').innerHTML = "Please Enter Quantity";
		flag =0;
	}
	
	price = document.getElementById('fprice').value;
	if(price == "")
	{
		document.getElementById('fpriceerror').innerHTML = "Please Enter Price";
		flag =0;
	}
	
	tprice = document.getElementById('tprice').value;
	if(tprice == "")
	{
		document.getElementById('tpriceerror').innerHTML = "Please Enter Total Price";
		flag =0;
	}

	if(flag)
	{
		return true;
	}	
	else{
		return false;
	}
} 
