package vn.anhtcn.lab.BookManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan("vn.anhtcn.lab.BookManagement")
public class BookManagement1Application {

	public static void main(String[] args) {
		SpringApplication.run(BookManagement1Application.class, args);
	}
}
