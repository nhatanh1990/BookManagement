<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 0.0.0
    </div>
    <strong>Copyright &copy; 2017 <a href="#">ANHTCN</a>.</strong> All rights
    reserved.
  </footer>

  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
<!--   <div class="control-sidebar-bg"></div>
</div> -->
<script type="text/javascript">
$(function() {
	$.ajaxSetup({
		complete : onRequestCompleted
	});
})
function onRequestCompleted(xhr, textStatus) {
	/* console.log(xhr); */
	console.log('adasddasd');
	if (xhr.status == 302) {
	      location.href = '';
	   }
	CompletedCheckLogin(xhr, textStatus);

}
</script>
<!-- ./wrapper -->