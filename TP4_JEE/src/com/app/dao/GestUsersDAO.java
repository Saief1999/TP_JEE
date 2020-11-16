package com.app.dao;

import java.sql.*;
import java.util.Vector;
import com.app.metier.Utilisateur;;
public class GestUsersDAO {

	public Utilisateur loadUser(String login, String pass) {
		Connection conn = Utilitaire.getConnection();
		Utilisateur u = null;
		try {

			PreparedStatement ps = conn.prepareStatement("select * from utilisateurs where LOGIN=? and PASS=? ");
			ps.setString(1,login);
			ps.setString(2,pass);
			ResultSet rsUser = ps.executeQuery();
			if (rsUser.next()) {
				u = new Utilisateur();
				u.setIdUser(new Integer(rsUser.getInt("ID_USER")));
				u.setLogin(rsUser.getString("LOGIN"));
				u.setPass(rsUser.getString("PASS"));
				u.setEmail(rsUser.getString("EMAIL"));
				u.setVille(rsUser.getString("VILLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public Utilisateur getUser(String id) {
		Connection conn = Utilitaire.getConnection();
		Utilisateur u = null;
		try {

			PreparedStatement ps = conn.prepareStatement("select * from utilisateurs where ID_USER=?");
			ps.setString(1,id);
			ResultSet rsUser = ps.executeQuery();
			if (rsUser.next()) {
				u = new Utilisateur();
				u.setIdUser(new Integer(rsUser.getInt("ID_USER")));
				u.setLogin(rsUser.getString("LOGIN"));
				u.setPass(rsUser.getString("PASS"));
				u.setEmail(rsUser.getString("EMAIL"));
				u.setVille(rsUser.getString("VILLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	public void addUser(String l, String p, String e, String v) {
		Connection conn = Utilitaire.getConnection();
		Utilisateur u = null;
		try {
			PreparedStatement ps = conn
					.prepareStatement("insert into Utilisateurs(LOGIN,PASS,EMAIL,VILLE) values(?,?,?,?)");
			ps.setString(1, l);
			ps.setString(2, p);
			ps.setString(3, e);
			ps.setString(4, v);
			ps.executeUpdate();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	public Vector selectAll() {
		Connection conn = Utilitaire.getConnection();
		Vector users = new Vector();
		Utilisateur u = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from Utilisateurs");
			ResultSet rsUser = ps.executeQuery();
			while (rsUser.next()) {
				u = new Utilisateur();
				u.setIdUser(new Integer(rsUser.getInt("ID_USER")));
				u.setLogin(rsUser.getString("LOGIN"));

				u.setPass(rsUser.getString("PASS"));
				u.setEmail(rsUser.getString("EMAIL"));
				u.setVille(rsUser.getString("VILLE"));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public void deleteUser(String id )
	{
		
		Connection conn = Utilitaire.getConnection() ; 		

		try {
			PreparedStatement ps = conn.prepareStatement("delete from utilisateurs where (id_user=?) ") ;
			ps.setString(1, id);
			
			ps.execute() ;
		} catch (SQLException e) {	
			e.printStackTrace();
		} 

	}
	
	
	public void updateUser (String l, String e, String v,String id)
	{
		Connection conn = Utilitaire.getConnection();  
		
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE utilisateurs SET LOGIN=?, EMAIL=? , VILLE=?  WHERE ID_USER=?;") ;
			ps.setString(1, l);
			ps.setString(2, e);
			ps.setString(3, v);
			ps.setString(4, id);
			ps.execute() ; 
		
		} catch (SQLException exc) {	
			exc.printStackTrace();
		} 

		
		
	}
	
}
