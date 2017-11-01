
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:directive.include file="include/init.jsp" />

<body class="hold-transition login-page">
	<div class="wrapper_login">
		<h2 class="login-logo">
			<spring:message code="application.title" />
		</h2>
		<div class="login-box">
			<div class="login-box-body">
				<h2 class="login-box-msg text-primary"
					style="text-transform: uppercase;">
					<spring:message code="login.title" />
				</h2>
				<!-- /.login-box-msg  -->

				<form:form action="login" method="post" role="form"
					modelAttribute="user" id="loginForm">
					<div class="form-group has-feedback">
						<c:if test="${not empty errorMessage}">
							<div style="text-align: center; color: red">
								<spring:message code="${errorMessage}" />
							</div>

						</c:if>
					</div>

					<div class="form-group has-feedback">
						<span class="glyphicon glyphicon-user form-control-feedback"></span>
						<input type="email" name="email" class="form-control"
							placeholder='<spring:message code="login.placeholder.email" />'>
					</div>

					<div class="form-group has-feedback">
						<span class="glyphicon glyphicon-lock form-control-feedback"></span>
						<input type="password" name="password" id="loginPassword"
							class="form-control"
							placeholder='********' />
					</div>
					<div class="form-group has-feedback text-center">
						<button type="submit" class="btn btn-primary btn-block btn-flat">
							<spring:message code="login.btn.submit" />
						</button>
						<!-- /.col -->
					</div>
				</form:form>
			</div>
			<!-- /.login-box-body -->
			<div class="clearfix"></div>

		</div>
		<!-- /.login-box -->

		<div class="clearfix"></div>
		<div class="footer_login text-center">
			<b>Công Ty A</b>
			<p>
				Bản quyền &copy; 2017<span> ANHTCN</span>
			</p>
			<address>Giải pháp: ANHTCN</address>
		</div>
	</div>
	<!-- /.wrapper_login -->

</body>
</html>
