package augustin_charly_jee.jee.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import augustin_charly_jee.jee.model.User;
import augustin_charly_jee.jee.services.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		us = new UserService();
	}

	public boolean processRequest(HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession().getAttribute("user") == null) {
			return false;
		}
		return true;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (processRequest(request, response)) {
			response.sendRedirect(request.getContextPath() + "/dashboard");
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> errors = new ArrayList<String>();
		if (request.getParameter("user") != null && request.getParameter("password") != null) {
			String login = request.getParameter("user");
			String password = request.getParameter("password");
			User user = us.getByLogin(login);
			if (user != null && password.equals(user.getPassword())) {
				request.getSession().setAttribute("user", user);
				response.sendRedirect(request.getContextPath() + "/dashboard");
			} else {
				errors.add("mauvais identifiants");
				request.setAttribute("error", errors);
				response.sendRedirect(request.getContextPath() + "/login");
			}
		} else {
			errors.add("utilisateur n'existe pas");
			request.setAttribute("error", errors);
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

}
