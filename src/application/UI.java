package application;

import java.util.Scanner;

import entities.PostoTroca;

public class UI {
	
	public static void imprimirMenuPrincipal(PostoTroca pt) {
		System.out.println("----------------------------------------");
		System.out.println("            Reciclagem de oleo          ");
		System.out.println("----------------------------------------");
		
		if (pt.checarCapacidade()) {
			System.out.println("Capacidade maxima atingida.");
			System.out.println("Chamando a coleta.");
			pt.setTotalMlsOleo(0);
			System.out.println("Coleta feita, digite 0: ");
		}
		else {
			System.out.println("1 - Adicionar clientes.");
			System.out.println("2 - Adicionar oleo de cliente cadastrado.");
			System.out.println("3 - Resgastar recompensa.");
			System.out.println("4 - Adicionar novas recompensas.");
			System.out.println("5 - Remover recompensas.");
			System.out.println("6 - Lista de clientes.");
			System.out.println("7 - Sair.");
		}
	}
	public static void menu1() {
		
	}
}
