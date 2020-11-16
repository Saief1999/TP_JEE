

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.metier.GestUsers;
import com.app.metier.*;
/**
 * Servlet implementation class ServletListUsers
 */
@WebServlet("/users")
public class ServletListUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		if (session==null) 
				response.sendRedirect("login");
		else if (session.getAttribute("user")==null)
				response.sendRedirect("login");
		else
		{
		GestUsers gestUsers  = new GestUsers() ; 
		
		Vector<Utilisateur> users=gestUsers.lister() ;
		
		request.setAttribute("users", users);
		request.getRequestDispatcher("users.jsp").forward(request, response);
		}
	}

}
