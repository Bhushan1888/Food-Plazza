<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="validation.js"> </script>
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="UserHeader.jsp"></jsp:include>

	<div id="templatemo_container">
		<form class="main" action="feedback" method="post" onsubmit="return AddFeedvalidation()">
			<table border="1">
				<caption>
					<h1>Add Feedback</h1>
				</caption>

				<tr>
					<td>Name:</td>
					<td><input type="text" name="cname" id="cname"></td>
					<td><span id="cnameerror" style="color: red"></span></td>
				</tr>

				<tr>
					<td>Review:</td>
					<td><input type="text" name="review" id="review"></td>
					<td><span id="reviewerror" style="color: red"></span></td>
				</tr>

				<tr>
					<td>Ranking:</td>
					<td><input type="number" name="rank" id="rank"></td>
					<td><span id="rankerror" style="color: red"></span></td>
				</tr>

				<tr>
					<td>Suggestion:</td>
					<td><input type="text" name="sug" id="sug"></td>
					<td><span id="sugerror" style="color: red"></span></td>
				</tr>

			</table>
			
			<input type="submit" name="action" value="AddFeedback">
			<input type="reset" value="clear">
		</form>
	</div>
	
		<jsp:include page="Footer.jsp"></jsp:include>
	

</body>
</html>