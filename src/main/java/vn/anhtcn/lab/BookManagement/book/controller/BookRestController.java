package vn.anhtcn.lab.BookManagement.book.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vn.anhtcn.lab.BookManagement.Datatable.ObjectDatatable;
import vn.anhtcn.lab.BookManagement.book.services.BookServices;

@RestController
public class BookRestController {
	@Autowired
	BookServices bookServices;

	@RequestMapping(value = "/getBookAll", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Object getBookALl(HttpServletRequest request, HttpServletResponse response) {

		int start = Integer.parseInt(request.getParameter("start"));
		int length = Integer.parseInt(request.getParameter("length"));

		ObjectDatatable oDatatable = new ObjectDatatable();
		oDatatable.setRecordsTotal(bookServices.countAllBook());
		oDatatable.setRecordsFiltered(bookServices.countAllBook());
		oDatatable.setData(bookServices.findAll(start, length));
		return oDatatable;
	}
	@RequestMapping(value = "/deleteBook/{id}")
	public String deleteBook( @PathVariable("id") Integer id, Model model) {
		try {
			bookServices.delete(id);
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}
}
