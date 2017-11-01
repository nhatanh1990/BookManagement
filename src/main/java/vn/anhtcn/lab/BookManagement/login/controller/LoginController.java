package vn.anhtcn.lab.BookManagement.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vn.anhtcn.lab.BookManagement.user.model.User;
import vn.anhtcn.lab.BookManagement.user.services.UserServices;

@RestController
public class LoginController {
	@Autowired
	private UserServices userServices;

	@RequestMapping({ "/login", "/" })
	public ModelAndView login(Model model) {

		return new ModelAndView("login");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView excuteLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user, ModelMap mm) {

		User userCheck = userServices.getByEmailPassword(user.getEmail(), user.getPassword());

		if (userCheck == null) {
			ModelAndView model = new ModelAndView("login");
			mm.put("errorMessage", "login.bad");
			return model;
		}
		HttpSession session = request.getSession();
		session.setAttribute("email", user.getEmail());
		return new ModelAndView("redirect:/bookList");
	}

	@RequestMapping(value = "/logout")
	public ModelAndView excuteLogout(HttpServletRequest request, HttpServletResponse response) {

		// release toàn bộ các session khởi tạo.
		request.getSession().removeAttribute("email");
		return new ModelAndView("redirect:/login");
	}
}
