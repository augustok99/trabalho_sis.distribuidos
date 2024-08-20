package carregabanco.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

    @Entity
    @PrimaryKeyJoinColumn(name = "idPessoa")
    @Table(name = "servidor")
    public class ServidorModel extends PessoaModel implements Serializable {
        private static final long serialVersionUID = 1L;
        //#,nome,email_contato,cargo,campus_lotacao,setor_lotacao.

        private String nome_servidor;
        private String email_contato;
        private String cargo;
        private String campus_lotacao;
        private String setor_lotacao;

        public ServidorModel() {}

        public ServidorModel(String nome_servidor, String email_contato, String cargo, String campus_lotacao, String setor_lotacao) {
            super();
            this.nome_servidor = nome_servidor;
            this.email_contato = email_contato;
            this.cargo = cargo;
            this.campus_lotacao = campus_lotacao;
            this.setor_lotacao = setor_lotacao;
        }

        public String getNome_servidor() {
            return nome_servidor;
        }

        public void setNome_servidor(String nome_servidor) {
            this.nome_servidor = nome_servidor;
        }

        public String getEmail_contato() {
            return email_contato;
        }

        public void setEmail_contato(String email_contato) {
            this.email_contato = email_contato;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        public String getCampus_lotacao() {
            return campus_lotacao;
        }

        public void setCampus_lotacao(String campus_lotacao) {
            this.campus_lotacao = campus_lotacao;
        }

        public String getSetor_lotacao() {
            return setor_lotacao;
        }

        public void setSetor_lotacao(String setor_lotacao) {
            this.setor_lotacao = setor_lotacao;
        }
    }
