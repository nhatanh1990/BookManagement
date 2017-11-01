<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE body PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:directive.include file="../include/init.jsp" />
<!-- top -->
<jsp:directive.include file="../include/top.jsp" />
<!-- Left side column. contains the logo and sidebar -->
<jsp:directive.include file="../include/menu.jsp" />
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	<h1>
		<spring:message code="booklist.title"></spring:message>
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
						<a class="btn btn-success btn-sm"
							href='${pageContext.request.contextPath}/createBook'> <spring:message
								code="book.create.title"></spring:message>
						</a>

					</h3>
				</div>
				<div class="clearfix"></div>
				<div class="box-body">
					<table id="bookList" class="table table-bordered table-striped">
						<thead>
							<tr>
								<th><spring:message code="book.booklist.lbl.title"></spring:message></th>
								<th><spring:message code="book.booklist.lbl.author"></spring:message></th>
								<th><spring:message code="book.booklist.lbl.description"></spring:message></th>
								<th></th>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->
<script>
	$(function() {
		loadBookList();
	});
	function loadBookList() {
		$('#bookList')
		.DataTable(
				{
					destroy : true,
					"autoWidth" : true,
					"lengthChange" : true,
					"searching" : false,
					"processing" : true,
					"deferRender" : true,
					"orderable" : false,
					"serverSide" : true,
					"lengthChange" : true,
					"ajax" : '/getBookAll',
					"columns" : [
							{
								"data" : "title",
								"orderable" : false,
								"render" : function(data, type, full,
										meta) {
									return '<span title="'+full.title+'">'
											+ full.title + '</span>';
								}
							},
							{
								"data" : "author",
								"orderable" : false,
								"render" : function(data, type, full,
										meta) {
									return '<span title="'+full.author+'">'
											+ full.author + '</span>';
								}
							},
							{
								"data" : "description",
								"orderable" : false,
								"render" : function(data, type, full,
										meta) {
									return '<span title="'+full.description+'">'
											+ full.description
											+ '</span>';
								}
							},
							{
								"data" : "null",
								"orderable" : false,
								"className" : "text-center",
								"render" : function(data, type, full,
										meta) {
									return '<a class=\'btn btn-sm btn-info \' style=\"margin:3px;\" onclick="return detailBook(\''
											+ full.id
											+ '\') " data-toggle=\'tooltip\' '
											+ 'data-original-title=\'<bean:message key="btn.list.update" />\''
											+ '> <i class=\'fa fa-eye\'></i></a>'
											+ '<a class=\'btn btn-sm btn-warning \' style=\"margin:3px;\" onclick="return updateBook(\''
											+ full.id
											+ '\') " data-toggle=\'tooltip\' '
											+ 'data-original-title=\'<bean:message key="btn.list.update" />\''
											+ '> <i class=\'fa fa-edit\'></i></a>'
											+ '<a class=\'btn btn-sm btn-danger\' onclick="return deleteBook(\''
											+ full.id
											+ '\')" data-toggle="tooltip" '
											+ 'data-original-title=\'<bean:message key="btn.list.delete" />\''
											+ '><i class=\'fa fa-trash\'></i></a>';
								}
							} ]
				});
	}
	function detailBook(id) {
		window.location = '${pageContext.request.contextPath}/detailBook/' + id;
	}
	function updateBook(id) {
		window.location = '${pageContext.request.contextPath}/updateBook/' + id;
	}
	function deleteBook(id) {
		$
				.confirm({
					title : 'Prompt!',
					content : '<spring:message code="jalert.confirm" />',
					buttons : {
						formSubmit : {
							text : 'Submit',
							btnClass : 'btn-blue',
							action : function() {
								var controllerPath = '${pageContext.request.contextPath}/deleteBook/'
										+ id;
								$
										.post(
												controllerPath,
												function(data) {
													if (data
															.localeCompare('success') == 0) {
														loadBookList();
														var priority = '<spring:message code="toast.status.info" />';
														var title = '<spring:message code="toast.status.info.title" />';
														var message = '<spring:message code="toast.status.deleteok" />';
														$
																.toaster({
																	priority : priority,
																	title : title,
																	message : message,
																	timeout : 5000,
																});
													}
												});
							}
						},
						cancel : function() {
							//close
						},
					}
				});
	}
</script>
<jsp:directive.include file="../include/bottom.jsp" />

