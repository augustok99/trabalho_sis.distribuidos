package carregabanco.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import carregabanco.model.AlunoModel;
import carregabanco.model.ServidorModel;
import carregabanco.repository.AlunoDao;
import carregabanco.repository.ServidorDao;

import static jakarta.xml.bind.DatatypeConverter.parseString;
import static java.lang.String.*;

public class CarregaBancoController{
	private static ArrayList<AlunoModel> valores = new ArrayList<AlunoModel>();
	//campus, polo, coordenacao, curso, nome_estudante, situacao, idade, sexo, email_institucional, periodo_entrada
	public ArrayList<AlunoModel> loaderAluno(String file) {
		try {
			Reader reader = new InputStreamReader(new FileInputStream("src/main/resources/" + file), "UTF-8");
			BufferedReader bf = new BufferedReader(reader);
			String linha = bf.readLine();
			linha = bf.readLine();
			while (linha != null) {
				String[] data = linha.split(",");
				AlunoModel aluno = new AlunoModel();
				aluno.setCampus(data[0]);
				aluno.setCoordenacao(data[2]);
				aluno.setCurso(data[3]);
				aluno.setNome_estudante(data[4]);
				aluno.setSituacao(data[5]);
				aluno.setSexo(!data[6].isBlank() && !data[6].isEmpty()? data[6] : "");
				aluno.setPeriodo_entrada(data[7]);
				aluno.setData_conclusao(!data[8].isBlank() && !data[8].isEmpty()? data[8] : "");
				aluno.setCidade(data[9]);

				valores.add(aluno);
				linha = bf.readLine();
			}
			bf.close();
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
		return valores;
	}

	private static ArrayList<ServidorModel> valores_servidor = new ArrayList<ServidorModel>();
	public ArrayList<ServidorModel> loaderServidor(String file) {
		try {
			Reader reader = new InputStreamReader(new FileInputStream("src/main/resources/" + file), "UTF-8");
			BufferedReader bf = new BufferedReader(reader);
            bf.readLine();
            String linha;
			linha = bf.readLine();
			while (linha != null) {
				String[] data = linha.split(",");
				ServidorModel servidor = new ServidorModel();
				servidor.setNome_servidor(data[1]);
				servidor.setEmail_contato(data[2]);
				servidor.setCargo(data[3]);
				servidor.setCampus_lotacao(data[4]);
				servidor.setSetor_lotacao(data[5]);

				valores_servidor.add(servidor);
				linha = bf.readLine();
			}
			bf.close();
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
		return valores_servidor;
	}
	
	public void inserirNoBancoAluno(ArrayList<AlunoModel> listaDeAlunos) {
		AlunoDao alunoDao = AlunoDao.getInstance();
		for(AlunoModel aluno : listaDeAlunos) {
			alunoDao.persist(aluno);
		}
	}

	public void inserirNoBancoServidor(ArrayList<ServidorModel> listaDeServidores) {
		ServidorDao servidorDao = ServidorDao.getInstance();
		for(ServidorModel servidor : listaDeServidores) {
			servidorDao.persist(servidor);
		}
	}
}
