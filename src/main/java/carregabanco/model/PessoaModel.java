package carregabanco.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public class PessoaModel implements Serializable{
	private static final long serialVersionUID = 1L;
	//campus,polo,coordenacao,curso,nome_estudante,situacao,idade,sexo,email_institucional,periodo_entrada
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPessoa;

	private String campus;
	private String polo;
	private String email_institucional;
	private int idade;
	private String sexo;
	
	public PessoaModel() {}
	
	public PessoaModel(String campus, String polo, String email_institucional, int idade, String sexo) {
		super();
		this.campus = campus;
		this.polo = polo;
		this.email_institucional = email_institucional;
		this.idade = idade;
		this.sexo = sexo;
	}
	
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	public String getEmail_institucional() {
		return email_institucional;
	}
	public void setEmail_institucional(String email_institucional) {
		this.email_institucional = email_institucional;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getPolo() {
		return polo;
	}
	public void setPolo(String polo) {
		this.polo = polo;
	}
		
}

