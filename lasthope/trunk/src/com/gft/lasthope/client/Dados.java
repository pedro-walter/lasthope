package com.gft.lasthope.client;

public class Dados {
	
	public int rolarD4(int quant){
		int soma=0;
		int i=0;
		int n=0;
		System.out.println("Quantidade: "+quant);
		for(i=0;i<quant;i++){
			n = (int)(Math.random()*4+1);
			soma=soma+n;
			System.out.println("Numero gerado no for: "+n);
			System.out.println("indice: "+i);
		}
		
		return soma;
	}
	public int rolarD6(int quant){
		int soma=0;
		int i=0;
		int n=0;
		System.out.println("Quantidade: "+quant);
		for(i=0;i<quant;i++){
			n = (int)(Math.random()*6+1);
			soma=soma+n;
			System.out.println("Numero gerado no for: "+n);
			System.out.println("indice: "+i);
		}
		
		return soma;
	}
	public int rolarD8(int quant){
		int soma=0;
		int i=0;
		int n=0;
		System.out.println("Quantidade: "+quant);
		for(i=0;i<quant;i++){
			n = (int)(Math.random()*8+1);
			soma=soma+n;
			System.out.println("Numero gerado no for: "+n);
			System.out.println("indice: "+i);
		}
		
		return soma;
	}
	public int rolarD10(int quant){
		int soma=0;
		int i=0;
		int n=0;
		System.out.println("Quantidade: "+quant);
		for(i=0;i<quant;i++){
			n = (int)(Math.random()*10+1);
			soma=soma+n;
			System.out.println("Numero gerado no for: "+n);
			System.out.println("indice: "+i);
		}
		
		return soma;
	}
	public int rolarD12(int quant){
		int soma=0;
		int i=0;
		int n=0;
		System.out.println("Quantidade: "+quant);
		for(i=0;i<quant;i++){
			n = (int)(Math.random()*12+1);
			soma=soma+n;
			System.out.println("Numero gerado no for: "+n);
			System.out.println("indice: "+i);
		}
		
		return soma;
	}
	public int rolarD20(int quant){
		int soma=0;
		int i=0;
		int n=0;
		System.out.println("Quantidade: "+quant);
		for(i=0;i<quant;i++){
			n = (int)(Math.random()*20+1);
			soma=soma+n;
			System.out.println("Numero gerado no for: "+n);
			System.out.println("indice: "+i);
		}
		
		return soma;
	}
	public int rolarD100(int quant){
		int soma=0;
		int i=0;
		int n=0;
		System.out.println("Quantidade: "+quant);
		for(i=0;i<quant;i++){
			n = (int)(Math.random()*100+1);
			soma=soma+n;
			System.out.println("Numero gerado no for: "+n);
			System.out.println("indice: "+i);
		}
		
		return soma;
	}

}
