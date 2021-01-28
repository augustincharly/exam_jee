package augustin_charly_jee.jee.servlets.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import augustin_charly_jee.jee.model.User;
import augustin_charly_jee.jee.services.UserService;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/admin/create_user")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateUserServlet() {
		super();
		us = new UserService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("../create_user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("login") != null && request.getParameter("password") != null
				&& request.getParameter("lastname") != null && request.getParameter("firstname") != null
				&& request.getParameter("entered_at") != null && request.getParameter("number") != null
				&& request.getParameter("role") != null) {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String lastname = request.getParameter("lastname");
			String firstname = request.getParameter("firstname");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date entered_at = null;
			try {
				entered_at = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("entered_at"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String number = request.getParameter("number");
			String role = request.getParameter("role");
			String image_url = "https://images.squarespace-cdn.com/content/51654f04e4b0d3f496672620/1545823250251-EF37HQLR90ZN678OTQMM/photographe+portrait+corporate+Paris+75+prestations+portrait+entreprise+corporate+08.JPG?content-type=image%2Fjpeg";
			if (us.getByLogin(login) == null) {
				User user = new User(login, password, lastname, firstname, entered_at, number, role, image_url);
				System.out.println(user);
				us.create(user);
				response.sendRedirect(request.getContextPath() + "/dashboard");
			} else {
				response.sendRedirect(request.getContextPath() + "/admin/create_user");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/create_user");
		}
	}
}