package br.net.mirante.operadores.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "documento")
	private String documento;
	
	@Column(name = "data_nascimento")
	private String dataNascimento;
	
	@Column(name = "nome_pai")
	private String nomePai;
	
	@Column(name = "nome_mae")
	private String nomeMae;
	
	@Column(name = "login_operador")
	private String loginOperador;
	
	@Column(name = "tipo_pessoa")
	private char tipoPessoa;
	
	public Pessoa() {
		
	}

	public Pessoa(String nome, String documento, String dataNascimento, String nomePai, String nomeMae,
			String loginOperador, char tipoPessoa) {
		this.nome = nome;
		this.documento = documento;
		this.dataNascimento = dataNascimento;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.loginOperador = loginOperador;
		this.tipoPessoa = tipoPessoa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getLoginOperador() {
		return loginOperador;
	}

	public void setLoginOperador(String loginOperador) {
		this.loginOperador = loginOperador;
	}

	public char getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(char tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", documento=" + documento + ", dataNascimento=" + dataNascimento
				+ ", nomePai=" + nomePai + ", nomeMae=" + nomeMae + ", loginOperador=" + loginOperador + ", tipoPessoa="
				+ tipoPessoa + "]";
	}
	
}
