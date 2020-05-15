package entities;

import java.io.Serializable;

public class Cliente extends PostoTroca implements Serializable{
	
	//atributos da classe
	private String nome;
	private String endereco;
	private String telefone;
	private String cpf;
	private int pontos;
	
	ClienteOleo clienteOleo;
	

	//metodos construtores
	public Cliente() {
		super();
	}
	
	public Cliente(String nome, String endereco, String telefone, String cpf, ClienteOleo mlsOleo) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cpf = cpf;
		this.clienteOleo = mlsOleo;
		pontos = converterPontos(mlsOleo.getMlsOleo());
	}

	//getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	//adicionar pontos do cliente
	public void addPontos(double mlsOleo) {
		pontos += converterPontos(mlsOleo);
	}
	
	//resgastar recompensa do cliente
	public void resgatarRecompensa(Recompensa recompensa) {
		if (recompensa.getValor() <= pontos) {
			if (recompensa.getQuantidade() > 0) {
				recompensa.resgatar();
				pontos -= recompensa.getValor();
			}
		}
		
	}
	
	//adicionar oleo do cliente, adiciona os pontos também
		public void addOleo(double mlsOleo) {
			addPontos(mlsOleo);
			clienteOleo.addMlsOleo(mlsOleo);
			
		}
}
