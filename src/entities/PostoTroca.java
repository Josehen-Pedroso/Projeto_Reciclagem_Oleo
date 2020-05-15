package entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PostoTroca {
	
	//atributos da classe
	private String endereco;
	private List<Cliente> clientes = new ArrayList<>();
	private List<Recompensa> recompensas = new ArrayList<>();
	private double totalMlsOleo;
	
	//constante
	private double CAPACIDADE_MAXIMA = 250000;
	
	//metodo construtor
	public PostoTroca() {
		this.endereco = endereco;
		this.clientes = clientes;
		this.recompensas = recompensas;
		this.totalMlsOleo = totalMlsOleo;
	}

	//getters e setters
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Recompensa> getRecompensas() {
		return recompensas;
	}

	public void setRecompensas(List<Recompensa> recompensas) {
		this.recompensas = recompensas;
	}

	public double getTotalMlsOleo() {
		return totalMlsOleo;
	}

	public void setTotalMlsOleo(double totalMlsOleo) {
		this.totalMlsOleo = totalMlsOleo;
	}
	
	public double getCAPACIDADE_MAXIMA() {
		return CAPACIDADE_MAXIMA;
	}
	
	
	//coleta do oleo caso atinja a capacidade maxima 
	public boolean checarCapacidade() {
		if (totalMlsOleo >= CAPACIDADE_MAXIMA) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//adicionar clientes para o posto
	public void addCliente(String nome, String endereco, String telefone, String cpf, double mlsOleo) {
		clientes.add(new Cliente(nome, endereco, telefone, cpf, new ClienteOleo(mlsOleo)));
		System.out.println("Cliente " + nome +" adicionado.");
	}
	
	//adicionar recompensas do posto
	public void addRecompensa(String nome, int valor, int quantidade) {
		recompensas.add(new Recompensa(nome, valor, quantidade));
	}
	
	//remover recompensa pelo posto, caso ela esteja invalida estragada, etc... 
	public void removeRecompensa(Recompensa recompensa) {
		recompensas.remove(recompensa);
	}
	
	//converter mls de oleo em pontos
	public int converterPontos(double mlsOleo) {
		return (int) Math.ceil(mlsOleo / 10);
	}
	
	//adicionar Mls total suportado pelo posto
	public void addTotalMlsPosto(double mlsOleo) {
		this.totalMlsOleo += mlsOleo;
	}
	
	//validar cpf para evitar cpfs iguais no sistema
	public boolean validarCpf(String cpf) {
		boolean test = false;
		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpf)) {
				test = true;
			}
		}
		return test;
	}
	
	//resgatar os dados
	public void resgatarListaClientes() {
		try {
			File file = new File("clie.txt");
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			clientes = (List<Cliente>) in.readObject();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public void resgatarListaRecompensas() {
		try {
			File file = new File("recom.txt");
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			recompensas = (List<Recompensa>) in.readObject();
		}
		catch (ClassNotFoundException e) {
				
			e.printStackTrace();
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//recebe dados
	public void salvaListaClientes() {
		try {
			File file = new File("clie.txt");
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
					file));
			out.writeObject(clientes);
			out.flush();
			out.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void salvaListaRecompensas() {
		try {
			File file = new File("recom.txt");
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
					file));
			out.writeObject(recompensas);
			out.flush();
			out.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
