package vn.anhtcn.lab.BookManagement.book.model.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import vn.anhtcn.lab.BookManagement.book.model.Book;

@Component
public class BookValidator  implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object o, Errors errors) {
		Book book = (Book) o;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "NotEmpty");
		
		if (book.getTitle().length() >100) {
			 errors.rejectValue("title", "size.title");
		}
		
		if (book.getAuthor().length() >100) {
			 errors.rejectValue("author", "size.author");
		}
		
		if (book.getDescription().length() >100) {
			 errors.rejectValue("description", "size.description");
		}
		
		
	}

}
