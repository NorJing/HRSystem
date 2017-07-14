<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>username</th>
				<th>email</th>
				<th>password</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.password}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="common/footer.jspf"%>