package validacartaodecredito;

import java.util.Scanner;

public class Luhn {
	
	public static int somaDigitos(int numero) {
		if(numero < 9) {
			return numero;
		}
		else {
			return numero%10 + 1;
		}
	}
	
	public static boolean checkValidade(String numeroCartao) {
		
		int somaPar = 0;
		int somaImpar = 0;
		int aux = 0;
		
		for(int j=numeroCartao.length()-2; j>=0; j=j-2) {
			aux = Integer.parseInt(numeroCartao.charAt(j)+"");
			somaPar = somaPar + somaDigitos(aux*2);
		}
		
		for (int i=numeroCartao.length()-1; i>=0;i=i -2) {
			aux = Integer.parseInt(numeroCartao.charAt(i)+"");
			somaImpar = somaImpar + aux;
		}
		
		if((somaPar + somaImpar)%10 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String checkBandeiraCartao(String numero1IdEmissor, String numero2IdEmissor) {
		if(numero2IdEmissor.equals("37")) {
			return "AMERICAN EXPRESS";
		} 
		else if(numero2IdEmissor.equals("35")) {
			return "JCB";
		} 
		else if(numero1IdEmissor.equals("4")) {
			return "VISA";
		} 
		else if(numero1IdEmissor.equals("5")) {
			return "MASTER";
		} 
		else if(numero1IdEmissor.equals("6")) {
			return "DISCOVER";
		} 
		else {
			return "desconhecido";
		}
	}
	
	public static void main(String[] args) {
		Scanner tcd = new Scanner(System.in);
		String bandeiraCrtao = "";
		
		System.out.println("Informe o numero do cartão");
		String numeroCartao = tcd.next();
		
		if(numeroCartao.length() >= 13 && numeroCartao.length() <= 16) {
			boolean flag = checkValidade(numeroCartao);
			if(flag) {
				System.out.println("Cartão Valido");
				bandeiraCrtao = checkBandeiraCartao( numeroCartao.substring(0,1),
						numeroCartao.substring(0,2));
				System.out.println("Bandeira "+ bandeiraCrtao);
			} 
			else {
				System.out.println("Cartão Invalido");
			}
		}
		else {
			System.out.println("Número de cartão invalido");
		}
	}

}
