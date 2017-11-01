package vn.anhtcn.lab.BookManagement.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.anhtcn.lab.BookManagement.book.model.Book;
import vn.anhtcn.lab.BookManagement.book.model.validator.BookValidator;
import vn.anhtcn.lab.BookManagement.book.services.BookServices;

@Controller
public class BookController {
	@Autowired
	private BookValidator bookValidator;

	@Autowired
	BookServices bookServices;

	@RequestMapping("/bookList")
	public ModelAndView bookList(Model model) {
		int countBook = bookServices.countAllBook();
		if (countBook > 0) {
			return new ModelAndView("book/bookList");
		} 
		return new ModelAndView("redirect:/createBook");
		
	}

	@RequestMapping(value = "/createBook", method = RequestMethod.GET)
	public ModelAndView createBook(Model model) {
		return new ModelAndView("book/createBook", "book", new Book());
	}

	@RequestMapping(value = "/createBook", method = RequestMethod.POST)
	public String createBook(@ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
		bookValidator.validate(book, bindingResult);
		if (bindingResult.hasErrors()) {
			return "book/createBook";
		}
		bookServices.create(book);
		return "redirect:/bookList";
	}

	@GetMapping(value = "/updateBook/{id}")
	public String updateBook(Model model, @PathVariable("id") Integer id) {
		if (!(id instanceof Integer)) {
			return "redirect:/bookList";
		}
		if (id == 0) {
			return "redirect:/bookList";
		}

		model.addAttribute("book", bookServices.findOne(id));
		return "book/updateBook";
	}
	
	@RequestMapping(value = "/updateBook", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
		bookValidator.validate(book, bindingResult);
		if (bindingResult.hasErrors()) {
			return "book/updateBook";
		}
		bookServices.update(book);
		return "redirect:/bookList";
	}
	
	@GetMapping(value = "/detailBook/{id}")
	public String detailBook(Model model, @PathVariable("id") Integer id) {
		if (!(id instanceof Integer)) {
			return "redirect:/bookList";
		}
		if (id == 0) {
			return "redirect:/bookList";
		}

		model.addAttribute("book", bookServices.findOne(id));
		return "book/detailBook";
	}
	
	
}
