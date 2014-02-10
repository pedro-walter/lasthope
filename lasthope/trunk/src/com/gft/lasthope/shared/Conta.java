package com.gft.lasthope.shared;

public class Conta {
	static String usuario="vinicius";
	static String senha="270388";
	
	
	static boolean verificaAcc(String user, String pass){
		if(user.equals(usuario)&&pass.equals(senha)){
			return true;
		}else{
			return false;
		}
		
	}

}
