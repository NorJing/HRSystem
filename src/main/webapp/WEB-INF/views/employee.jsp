<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<div class="container">
		<form:form method="post" commandName="employee" cssClass="form-horizontal">
			<%-- <form:hidden path="id" /> --%>
			
			<fieldset class="form-group">
				<form:label path="id">Id</form:label>
				<form:input path="id" type="text" class="form-control" required="required" />
				<form:errors path="id" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="employeeId">Employee Id</form:label>
				<form:input path="employeeId" type="text" class="form-control" required="required" />
				<form:errors path="employeeId" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="employeeName">Employee name</form:label>
				<form:input path="employeeName" type="text" class="form-control" required="required" />
				<form:errors path="employeeName" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="form-group">
                <form:label path="age">Age</form:label>
                <form:input path="age" type="text" class="form-control" required="required" />
                <form:errors path="age" cssClass="text-warning" />
            </fieldset>
            
            <fieldset class="form-group">
                <form:label path="businessTitle">Business title</form:label>
                <form:input path="businessTitle" type="text" class="form-control" required="required" />
                <form:errors path="businessTitle" cssClass="text-warning" />
            </fieldset>
            
            <fieldset class="form-group">
                <form:label path="salary">Salary</form:label>
                <form:input path="salary" type="text" class="form-control" required="required" />
                <form:errors path="salary" cssClass="text-warning" />
            </fieldset>
            
			<fieldset class="form-group">
                <form:label path="employDate">Employ date</form:label>
                <form:input path="employDate" type="text" class="form-control" required="required" />
                <form:errors path="employDate" cssClass="text-warning" />
            </fieldset>
   			
   			<fieldset class="form-group">
   				<form:label path="isHired">Hired or not</form:label>
   				<table>
   					<tr>
	   					<td><form:radiobutton path="isHired" value="true"/>true
	   						<form:radiobutton path="isHired" value="false"/>false</td>
	   					<td><form:errors path="isHired" cssClass="text-warning" /></td>
   					</tr>
   				</table>
   			</fieldset>
			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
	</div>
	
<%@ include file="common/footer.jspf"%>
	
	<script>
        $('#employDate').datepicker({
            format : 'dd/mm/yyyy'
        });
    </script>
