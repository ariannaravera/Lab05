package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.ParolaDAO;

public class Model {

	String parola;
	List<String> anagrammi;
	
	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public String cercaCorretti(String parola) {
		ParolaDAO dao=new ParolaDAO();
		return dao.getCorrette(anagrammi);
	}

	public String cercaErrati(String parola) {
		ParolaDAO dao=new ParolaDAO();
		return dao.getErrate(anagrammi);
	}
	
	public void start(String parola) {
		anagrammi=new ArrayList<String>();
		this.cerca(parola, "", 0);
	}
	
	public void cerca(String parola, String parziale, int L) {
		//condizione uscita
		if(L==parola.length()) {
			if(!anagrammi.contains(parziale)) {
				anagrammi.add(parziale);
				return;
			}
			else
				return;
		}
		
		
		for(int i=0;i<parola.length();i++) {
			if(conta(parziale,parola.charAt(i))<conta(parola,parola.charAt(i))) {
				parziale+=parola.charAt(i);
				
				this.cerca(parola, parziale, L+1);
				
				parziale=parziale.substring(0,parziale.length()-1);
				}
			}
	}
		public int conta(String parola, char c) {
			int n=0;
			for(int i=0; i<parola.length();i++) {
				if(parola.charAt(i)==c)
					n++;
			}
			return n;
		}

}
