

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.metier.GestUsers;
import com.app.metier.Utilisateur;

/**
 * Servlet implementation class ServletUpdateUser
 */
@WebServlet("/user_update")
public class ServletUpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUpdateUser() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id") ;
		
		GestUsers gestion = new GestUsers(); 
		Utilisateur user = gestion.chercherParId(id);
		request.setAttribute("muser",user);
		request.getRequestDispatcher("users.update.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur user = new Utilisateur();
		user.setLogin(request.getParameter("login"));
		user.setEmail(request.getParameter("email"));
		user.setVille(request.getParameter("ville"));
		user.setIdUser(Integer.parseInt(request.getParameter("id")));
		GestUsers gestUsers = new GestUsers();
		gestUsers.modifier(user) ; 
		response.sendRedirect("users");
	}

}
