
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.app.metier.GestUsers;
import com.app.metier.Utilisateur;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("user") != null)
			response.sendRedirect("UserInfo");
		else
			request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("user") != null)
			response.sendRedirect("UserInfo");
		else

		{
			String login = request.getParameter("login");
			String pass = request.getParameter("password");
			if (login == null ||login == "" || pass == null || pass == "") {
				request.setAttribute("AuthError", "Un ou plusieurs Champs Vides");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			GestUsers gestUsers = new GestUsers();
			Utilisateur user = gestUsers.Chercher(login, pass);

			if (user != null) {
				HttpSession maSession = request.getSession(true);
				maSession.setAttribute("user", user);
				response.sendRedirect("UserInfo");

			} else {
				request.setAttribute("AuthError", "Probleme authentification");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
	}

}
