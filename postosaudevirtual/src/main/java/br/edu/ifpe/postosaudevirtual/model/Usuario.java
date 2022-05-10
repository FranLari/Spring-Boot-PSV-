package br.edu.ifpe.postosaudevirtual.model; 

public class Usuario {
	private int codigo_usuario;
	private String numeroCartaoSus;
	private String cpf;
	private String nome;
	private String dataNascimento;
	private String email;
	private String senha;
	private String telefone;
	
	public Usuario() {
		
	}

	public Usuario(int codigo_usuario, String numeroCartaoSus, String cpf, String nome, String dataNascimento,
			String email, String senha, String telefone) {
		this.codigo_usuario = codigo_usuario;
		this.numeroCartaoSus = numeroCartaoSus;
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
	}

	public int getCodigo_usuario() {
		return codigo_usuario;
	}

	public void setCodigo_usuario(int codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}

	public String getNumeroCartaoSus() {
		return numeroCartaoSus;
	}

	public void setNumeroCartaoSus(String numeroCartaoSus) {
		this.numeroCartaoSus = numeroCartaoSus;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
