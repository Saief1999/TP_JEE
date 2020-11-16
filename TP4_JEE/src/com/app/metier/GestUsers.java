package com.app.metier;

import com.app.dao.GestUsersDAO;
import java.util.Vector;

/**
 *
 * @author USER
 */
public class GestUsers {
	GestUsersDAO dao;

	public GestUsers() {
		dao = new GestUsersDAO();
	}

	public Utilisateur Chercher(String login, String pass) {
		return dao.loadUser(login, pass);
	}

	public Utilisateur chercherParId(String id )
	{
		return dao.getUser(id) ;
	}
	
	
	public void ajouter(Utilisateur u) {
		dao.addUser(u.getLogin(), u.getPass(), u.getEmail(), u.getVille());
	}

	public Vector lister() {
		return dao.selectAll();
	}
	
	public void supprimer(String id) {
		dao.deleteUser(id);
	}
	
	
	public void modifier(Utilisateur u)
	{		
		dao.updateUser(u.getLogin(), u.getEmail(),u.getVille(),u.getIdUser()+"");
	}
}