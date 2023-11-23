package br.italo.modelos;

public class Cliente {

	private String nome;
	private String sobrenome;
	private String CPF;
	private String RG;
	private String dataNasc;
	private String genero;
	private String numTel;
	private String email;
	private String endereco;
	private String senha;


	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCPF() {
		return CPF;
	}

	public String getRG() {
		return RG;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public String getGenero() {
		return genero;
	}

	public String getNumTel() {
		return numTel;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public void setRG(String RG) {
		this.RG = RG;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}