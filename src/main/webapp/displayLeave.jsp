<!DOCTYPE html>
<%@page import="com.hrms.leave.leaveFetch"%>
<%@page import="com.hrms.displayEmployee"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
	<title>Table V04</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="table/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="table/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="table/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="table/vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="table/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="table/vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="table/css/util.css">
	<link rel="stylesheet" type="text/css" href="table/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	 <%
 	String admin = (String) session.getAttribute("admin");
 	List<leaveFetch> leave = (List<leaveFetch>) session.getAttribute("leave");
 	%>
 	<!-- Image and text -->
<nav class="navbar navbar-light bg-light">
  <a class="navbar-brand" href="admin.jsp">
    Home
  </a>
</nav>
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100 ver1 m-b-110">
					<div class="table100-head">
						<table>
							<thead>
								<tr class="row100 head">
									<th class="cell100 column1">No</th>
									<th class="cell100 column2">Name</th>
									<th class="cell100 column3">EmpId</th>
									<th class="cell100 column4">Email</th>
									<th class="cell100 column5">Mobile</th>
									<th class="cell100 column5">Reason</th>
									<th class="cell100 column5">Created</th>
								</tr>
							</thead>
						</table>
					</div>

					<div class="table100-body js-pscroll">
						<table>
							<tbody>
							
							 <%
  								for(leaveFetch user : leave){
	  
							%>   
								<tr class="row100 body">
									<td class="cell100 column1"><%=user.getNo() %></td>
									<td class="cell100 column2"><%=user.getName() %></td>
									<td class="cell100 column3"><%=user.getEmpId() %></td>
									<td class="cell100 column4"><%=user.getEmail() %></td>
									<td class="cell100 column5"><%=user.getMobile() %></td>
									<td class="cell100 column5"><%=user.getReason() %></td>
									<td class="cell100 column5"><%=user.getCreated() %></td>
								</tr>
							<%
  								}
							%>	
							</tbody>
						</table>
					</div>
				</div>
				
			</div>
		</div>
	</div>


<!--===============================================================================================-->	
	<script src="table/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="table/vendor/bootstrap/js/popper.js"></script>
	<script src="table/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="table/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="table/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll').each(function(){
			var ps = new PerfectScrollbar(this);

			$(window).on('resize', function(){
				ps.update();
			})
		});
			
		
	</script>
<!--===============================================================================================-->
	<script src="table/js/main.js"></script>

</body>
</html>