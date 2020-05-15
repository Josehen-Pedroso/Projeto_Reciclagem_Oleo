package application;

import java.util.Scanner;

import entities.Cliente;
import entities.PostoTroca;
import entities.Recompensa;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PostoTroca pt = new PostoTroca();
		pt.resgatarListaRecompensas();
		pt.resgatarListaClientes();
	
		int escolha = 0;
		while (escolha != 7) {
			UI.imprimirMenuPrincipal(pt);
			escolha = sc.nextInt();
			sc.nextLine();
			switch (escolha) {
				case 1:
					System.out.print("Nome:  ");
					String nome = sc.nextLine();
					System.out.print("Endereço: ");
					String endereco = sc.nextLine();
					System.out.print("Telefone: ");
					String telefone = sc.nextLine();
					System.out.print("CPF: ");
					String cpf = sc.nextLine();
					while (pt.validarCpf(cpf) && !cpf.equals("0")) {
						System.out.println("CPF "+ cpf + "já cadastrado");
						System.out.println("Digite outro CPF ou 0 para cancelar: ");
						cpf = sc.nextLine();
					}
					if (cpf.equals("0")) {
						break;
					}
					System.out.print("Quantidade em mls de oleo inicial: ");
					double mlsOleo = sc.nextDouble();
					pt.addCliente(nome, endereco, telefone, cpf, mlsOleo);
					pt.addTotalMlsPosto(mlsOleo);
					break;
				case 2:
					System.out.print("Digite o CPF do cliente: ");
					cpf = sc.nextLine();
					for (Cliente cliente : pt.getClientes()) {
						if (cliente.getCpf().equals(cpf)) {
							System.out.println("Cliente " + cliente.getNome() + " encontrado.");
							System.out.print("Quantos mls de oleo: ");
							mlsOleo = sc.nextDouble();
							cliente.addOleo(mlsOleo);
							System.out.println("Oleo adicionado e convertido em pontos.");
							System.out.println("Total de pontos: " + cliente.getPontos());
							break;
						}
					}
					break;
				case 3:
					System.out.print("Digite o CPF do cliente: ");
					cpf = sc.nextLine();
					for (Cliente cliente : pt.getClientes()) {
						if (cliente.getCpf().equals(cpf)) {
							System.out.println("Cliente " + cliente.getNome() + " encontrado. Pontos para resgatar: " 
									+ cliente.getPontos());
							System.out.println("Lista de recompensas disponiveis: ");
							int i = 0;
							for (Recompensa recompensa : pt.getRecompensas()) {
								if (recompensa.getQuantidade() > 0) {
									if (recompensa.getValor() <= cliente.getPontos()) {
										i++;
										System.out.println(i + " - " + recompensa.getNome() + " , valor: " 
												+ recompensa.getValor() 
										+ ".");
									}
								}
							}
							if (i == 0) {
								System.out.println("Sem recompensas para resgatar");
								break;
							}
							else {
								System.out.println("Escolher o número da recompensa: ");
								i = sc.nextInt();
								cliente.resgatarRecompensa(pt.getRecompensas().get(i-1));
								System.out.println("Recompensa " + pt.getRecompensas().get(i-1).getNome() + " resgatada.");
								System.out.println("Quantidades: " + pt.getRecompensas().get(i-1).getQuantidade());
							}
							break;
						}
					}
					break;
				case 4:
					System.out.print("Nome do produto: ");
					nome = sc.nextLine();
					System.out.print("Valor: ");
					int valor = sc.nextInt();
					System.out.print("Quantidade: ");
					int quantidade = sc.nextInt();
					pt.addRecompensa(nome, valor, quantidade);
					System.out.println("Recompensa adicionada!");
					break;
				case 5:
					
					System.out.print("Nome do produto para remover: ");
					nome = sc.nextLine();
					boolean teste = false;
					for (Recompensa recompensa : pt.getRecompensas()) {
						if (recompensa.getNome().equals(nome)) {
							teste = true;
							pt.removeRecompensa(recompensa);
							System.out.println("Recompensa removida.");
							break;
						}
					}
					if (teste == false) {
						System.out.println("Recompensa não encontrada");
					}
					break;
				case 6:
					System.out.println("Lista de clientes: ");
					for (Cliente cliente : pt.getClientes()) {
						System.out.println("Nome: " + cliente.getNome() +", CPF: " + cliente.getCpf() + ", pontos: " 
								+ cliente.getPontos());
						}
					break;
				case 7:
					System.out.println("Programa finalizado");
					break;
			}
		}
		pt.salvaListaClientes();
		pt.salvaListaRecompensas();;
		sc.close();
	}
}

