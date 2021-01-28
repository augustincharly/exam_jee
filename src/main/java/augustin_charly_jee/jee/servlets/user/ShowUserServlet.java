package augustin_charly_jee.jee.servlets.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import augustin_charly_jee.jee.model.User;
import augustin_charly_jee.jee.services.UserService;

/**
 * Servlet implementation class ShowUserServlet
 */
public class ShowUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowUserServlet() {
		super();
		us = new UserService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("id") != null) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				User user = us.getById(id);
				System.out.println(user);
				request.setAttribute("user", user);
				request.getRequestDispatcher("../show_user.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				response.sendRedirect(request.getContextPath() + "/dashboard");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/dashboard");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
