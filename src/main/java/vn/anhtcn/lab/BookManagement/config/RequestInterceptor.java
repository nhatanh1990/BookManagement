package vn.anhtcn.lab.BookManagement.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		System.out.println("In preHandle we are Intercepting the Request");
		System.out.println("____________________________________________");
		String uri = request.getRequestURI();
		if (uri.indexOf("resources") > 0) {
			return true;
		}
		HttpSession session = request.getSession(true);
		if (!uri.endsWith("login") && !uri.endsWith("logout")) {
			if (session == null) {
				response.sendRedirect(request.getContextPath() + "/login");
				return false;
			}
			if (session.getAttribute("email") == null) {
				response.sendRedirect(request.getContextPath() + "/login");
				return false;
			}
		}
		System.out.println("____________________________________________");
		return true;
	}
}
