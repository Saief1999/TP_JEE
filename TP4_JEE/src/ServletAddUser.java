
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
 * Servlet implementation class ServletAddUser
 */
@WebServlet("/user_add")
public class ServletAddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAddUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null)
			response.sendRedirect("login");
		else if (session.getAttribute("user") == null)
			response.sendRedirect("login");
		else
			request.getRequestDispatcher("users.add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null)
			response.sendRedirect("login");
		else if (session.getAttribute("user") == null)
			response.sendRedirect("login");
		else {
			Utilisateur user = new Utilisateur();
			user.setEmail(request.getParameter("email"));
			user.setLogin(request.getParameter("login"));
			user.setPass(request.getParameter("pass"));
			user.setVille(request.getParameter("ville"));
			GestUsers gestUsers = new GestUsers();
			gestUsers.ajouter(user);
			response.sendRedirect("users");
		}
	}

}
