<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
	<h1>${name} Employees </h1>
	<div class="container">
		<table class="table table-striped">
			<caption>Your Employees are</caption>
			<thead>
				<tr>
					<th>Id</th>
					<th>Employee Id</th>
					<th>Employee name</th>
					<th>Age</th>
					<th>Business title</th>
					<th>Salary</th>
					<th>Employee date</th>
					<th>Hired</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${employees}" var="employee">
					<tr>
						<td>${employee.id}</td>
						<td>${employee.employeeId}</td>
						<td>${employee.employeeName}</td>
						<td>${employee.age}</td>
						<td>${employee.businessTitle}</td>
						<td>${employee.salary}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${employee.employDate}" /></td>
						<td>${employee.isHired}</td>
						<td>
							<a type="button" class="btn btn-primary" href="/update-employee?id=${employee.id}">Edit</a>
							<a type="button" class="btn btn-warning" href="/delete-employee?id=${employee.id}">Delete</a>	
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a type="button" class="btn btn-success" href="/add-employee">Add</a>
		</div>
	</div>
<%@ include file="common/footer.jspf"%>
