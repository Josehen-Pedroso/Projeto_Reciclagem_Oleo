package entities;

import java.io.Serializable;

public class Recompensa extends PostoTroca implements Serializable{
	
	//atributos
	private String nome;
	private int valor;
	private int quantidade;
	
	//contrutor
	public Recompensa(String nome, int valor, int quantidade) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}
	
	//getters e setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void resgatar() {
		this.quantidade -= 1;
	}
	
	
}
