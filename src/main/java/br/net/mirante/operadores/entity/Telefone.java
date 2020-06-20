package br.net.mirante.operadores.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "telefone")
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "ddd")
	private String ddd;
	
	@Column(name = "numero")
	private String numero;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "login_operador")
	private String loginOperador;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
						  CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "id_pessoa")	
	private Pessoa pessoa;
	
	public Telefone() {
		
	}
	
	public Telefone(String ddd, String numero, String tipo, String loginOperador) {
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
		this.loginOperador = loginOperador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLoginOperador() {
		return loginOperador;
	}

	public void setLoginOperador(String loginOperador) {
		this.loginOperador = loginOperador;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", loginOperador=" + loginOperador + "]";
	}

	

}
