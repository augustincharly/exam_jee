package augustin_charly_jee.jee.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import augustin_charly_jee.jee.model.User;

public class AdminFilter implements Filter {

	public void init(FilterConfig config) throws ServletException {
		// ...
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		User session = (User) req.getSession().getAttribute("user");
		if (session != null) {
			if (session.getRole().equals("admin")) {
				chain.doFilter(request, response);
			} else {
				resp.sendRedirect(req.getContextPath()+"/dashboard");
			}
		} else {
			resp.sendRedirect(req.getContextPath()+"/login");
		}

	}

	public void destroy() {
		// ...
	}
}