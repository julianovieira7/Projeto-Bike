package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario extends DefaultEntity<Usuario> {


	private static final long serialVersionUID = 7142524988499261148L;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 100)
	private String email;

	@Column(length = 70, nullable = false)
	private String senha;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAniversario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Date getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}
	
}
