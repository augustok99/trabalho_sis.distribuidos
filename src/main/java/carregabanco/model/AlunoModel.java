package carregabanco.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
@Table(name = "aluno")
public class AlunoModel extends PessoaModel implements Serializable {
	private static final long serialVersionUID = 1L;
	//campus,polo,coordenacao,curso,nome_estudante,situacao,idade,sexo,email_institucional,periodo_entrada

	@Column(name = "nome_estudante")
	private String nome_estudante;
	@Column(name = "coordenacao")
	private String coordenacao;
	@Column(name = "curso")
	private String curso;
	@Column(name = "situacao")
	private String situacao;
	@Column(name = "periodo_entrada")
	private String periodo_entrada;
	@Column(name="data_conclusao")
	private String data_conclusao;
	@Column(name="cidade")
	private String cidade;

	public AlunoModel() {}


	public AlunoModel(String nome_estudante, String coordenacao, String curso, String situacao, String periodo_entrada, String data_conclusao, String cidade) {
		this.nome_estudante = nome_estudante;
		this.coordenacao = coordenacao;
		this.curso = curso;
		this.situacao = situacao;
		this.periodo_entrada = periodo_entrada;
		this.data_conclusao = data_conclusao;
		this.cidade = cidade;
	}


	public AlunoModel(String campus, String polo, String email_institucional, int idade, String sexo, String nome_estudante, String coordenacao, String curso, String situacao, String periodo_entrada, String data_conclusao, String cidade) {
		super(campus, polo, email_institucional, idade, sexo);
		this.nome_estudante = nome_estudante;
		this.coordenacao = coordenacao;
		this.curso = curso;
		this.situacao = situacao;
		this.periodo_entrada = periodo_entrada;
		this.data_conclusao = data_conclusao;
		this.cidade = cidade;
	}

	public AlunoModel(String campus, String polo, String coordenacao, String curso, String nomeEstudante, String situacao, String sexo, String periodoEntrada, String dataConclusao, String cidade) {
	}

	public String getCoordenacao() {
		return coordenacao;
	}

	public void setCoordenacao(String coordenacao) {
		this.coordenacao = coordenacao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getNome_estudante() {
		return nome_estudante;
	}

	public void setNome_estudante(String nome_estudante) {
		this.nome_estudante = nome_estudante;
	}

	public String getPeriodo_entrada() {
		return periodo_entrada;
	}

	public void setPeriodo_entrada(String periodo_entrada) {
		this.periodo_entrada = periodo_entrada;
	}

	public String getData_conclusao() {
		return data_conclusao;
	}

	public void setData_conclusao(String data_conclusao) {
		this.data_conclusao = data_conclusao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
