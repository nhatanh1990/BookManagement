package vn.anhtcn.lab.BookManagement.Datatable;

public class ObjectDatatable {
	private int recordsTotal;
	private int recordsFiltered;
	private Object data;
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}	
}
