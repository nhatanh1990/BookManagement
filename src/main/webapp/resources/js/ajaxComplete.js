function CompletedCheckLogin(xhr, textStatus) {
	
			if (xhr.responseText.includes('input type="email" name="email" class="form-control"')) {
				window.location.href = "";
			}
}