package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class ParolaDAO {

	public String getCorrette(List<String> anagrammi) {
		
		final String sql = "SELECT nome FROM parola WHERE nome=?";
		String corrette="";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			for(String s:anagrammi) {
				st.setString(1, s);
				ResultSet rs = st.executeQuery();
				
				if(rs.next()) {
					corrette+=s+"\n";
				}
				rs.close();
			}
			conn.close();
			
			return corrette;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public String getErrate(List<String> anagrammi) {
		final String sql = "SELECT nome FROM parola WHERE nome=?";
		String errate="";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			for(String s:anagrammi) {
				st.setString(1, s);
				ResultSet rs = st.executeQuery();
				
				if(!rs.next()) {
					errate+=s+"\n";
				}
				rs.close();
			}
			conn.close();
			
			return errate;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
