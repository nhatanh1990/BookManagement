<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE body PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:directive.include file="../include/init.jsp" />
<!-- top -->
<jsp:directive.include file="../include/top.jsp" />
<!-- Left side column. contains the logo and sidebar -->
<jsp:directive.include file="../include/menu.jsp" />
<!-- Content Wrapper. Contains page content -->
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<h1>
		<spring:message code="book.update.title"></spring:message>
	</h1>
	</section>

	<!-- Main content -->
	<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">
						<spring:message code="book.update.title"></spring:message>
					</h3>
				</div>
				<!-- /.box-header -->
				<!-- form start -->
				<form:form method="POST" commandName="book" action="/updateBook">
					<div class="box-body">
						<div class="form-group col-sm-6 col-sm-offset-3">
							<label><spring:message code="book.update.lbl.title"></spring:message>
								<span class="error">*</span></label>
							<form:input type="text" class="form-control" id="title"
								placeholder="Enter title" path="title" />
							<form:errors class="error" path="title"></form:errors>
							<form:input type="hidden" class="form-control" id="id" path="id" />
						</div>
						<div class="form-group col-sm-6 col-sm-offset-3">
							<label><spring:message code="book.update.lbl.description"></spring:message>
								<span class="error">*</span></label>
							<form:input type="text" class="form-control" id="author"
								placeholder="Enter author" path="author" />
							<form:errors class="error" path="author"></form:errors>
						</div>
						<div class="form-group col-sm-6 col-sm-offset-3">
							<label><spring:message code="book.update.lbl.description"></spring:message>
								<span class="error">*</span></label>
							<form:input type="text" class="form-control " id="description"
								placeholder="Enter description" path="description" />
							<form:errors class="error" path="description"></form:errors>
						</div>

					</div>
					<div class="box-footer">
						<div class="col-sm-6 col-sm-offset-3">
							<a class="btn btn-default pull-left "
								href="${pageContext.request.contextPath}/bookList"> <spring:message
									code="book.detail.btn.back"></spring:message>
							</a>
							<button type="submit" class="btn btn-primary pull-right ">
								<spring:message code="book.update.btn.submit"></spring:message>
							</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>

	</section>
	<!-- /.content -->
</div>
<script>
	$(function() {

	});
</script>
<!-- /.content-wrapper -->
<jsp:directive.include file="../include/bottom.jsp" />

