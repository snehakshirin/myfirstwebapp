<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	
    <title>Add Todos </title>
</head>
<body>
	<div class="container">
		<h1>Enter Todos Details </h1> 
	
		<form:form method="post" modelAttribute="todo">
		
		<fieldset class="mb-3">
			<form:label path="description">Description</form:label>
			<form:input type="text" path="description" required="required" />
			<form:errors path="description" cssClass="text-warning"/>
		</fieldset>
		
		<fieldset class="mb-3">
			<form:label path="targetDate">TargetDate</form:label>
			<form:input type="text" path="targetDate" required="required" />
			<form:errors path="targetDate" cssClass="text-warning"/>
		</fieldset>
		
		
		<form:input type="hidden" path="id"/>
		<form:input type="hidden" path="done"  />

		<input type="submit" class="btn btn-success" />
		</form:form>
		<script src ="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
		
	
	</div>
</body>

</html>