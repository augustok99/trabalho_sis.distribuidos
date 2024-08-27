package carregabanco.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import carregabanco.controller.AlunoController;
import carregabanco.model.AlunoModel;

public class AlunoView {
	private AlunoController alunoController = new AlunoController();
	
	public AlunoView() {
		Scanner leitura = new Scanner(System.in);
		int opcao = 0;
        do {
        	String valor = JOptionPane.showInputDialog(null,"0. Sair\n1. Inserir\n2. Buscar Todos\n3. Buscar por id\n4. Buscar por Nome.\n5. Buscar por Cidade.\n6. Buscar por Curso\n7. Remover por ID\n8. Alterar");
            opcao = Integer.parseInt(valor);
        	switch (opcao) {
				case 0:
					System.out.println("Bye!!!");
					break;
				case 1:
					inserir();
					break;
				case 2:
					buscar();
					break;
				case 3:
					buscarPorID();
					break;
				case 4:
					buscarPorNome();
					break;
				case 5:
					buscarPorCidade();
					break;
				case 6:
					buscarPorCurso();
					break;
				case 7:
					remover();
					break;
				case 8:
					editar();
					break;
			default:
				System.out.println("Opcao Incorreta!");
				break;
			}
        }while(opcao != 0);
	}

	private void remover() {
		Scanner leitura = new Scanner(System.in);
		System.out.println("Entre com o id do aluno a ser removido:");

		try {
			long id = leitura.nextInt();
			boolean removido = alunoController.removerPorID(id);

			if (!removido) {
				System.out.println("Aluno não encontrado.");
			}

			System.out.println("Aluno removido com sucesso!");

		} catch (InputMismatchException e) {
			System.out.println("ID inválido. Por favor, insira um número.");
		}
	}

	
	private void buscar() {
		List<AlunoModel> listaDeAlunos = alunoController.buscar();
		for(AlunoModel aluno: listaDeAlunos) {
			System.out.println(aluno.getNome_estudante() + " - " + aluno.getCampus());
		}
	}

	private void buscarPorID() {
		Scanner leitura = new Scanner(System.in);
		System.out.println("Entre com o ID do aluno:");
		Long id = leitura.nextLong();

		AlunoModel aluno = alunoController.buscarPorId(id);
		if (aluno != null) {
			System.out.println("Aluno encontrado:");
			System.out.println("ID: " + aluno.getIdPessoa());
			System.out.println("Nome: " + aluno.getNome_estudante());
			System.out.println("Curso: " + aluno.getCurso());
			System.out.println("Cidade: " + aluno.getCidade());
		} else {
			System.out.println("Aluno com ID " + id + " não encontrado.");
		}
	}
	
	private void inserir() {
		Scanner leitura = new Scanner(System.in);

		System.out.println("Entre com o campus");
		String campus = leitura.nextLine();
		
		System.out.println("Entre com o polo");
		String polo = leitura.nextLine();
		
		System.out.println("Entre com o coordenacao");
		String coordenacao = leitura.nextLine();
		
		System.out.println("Entre com o curso");
		String curso = leitura.nextLine();
		
		System.out.println("Entre com o nome_estudante");
		String nome_estudante = leitura.nextLine();
		
		System.out.println("Entre com o situacao");
		String situacao = leitura.nextLine();

		System.out.println("Entre com o sexo");
		String sexo = leitura.nextLine();
		
		System.out.println("Entre com o periodo_entrada");
		String periodo_entrada = leitura.nextLine();

		System.out.println("Entre com a data conclusao");
		String data_conclusao = leitura.nextLine();

		System.out.println("Entre com a cidade");
		String cidade = leitura.nextLine();
		AlunoModel aluno = new AlunoModel(campus, polo, coordenacao, curso,nome_estudante, situacao,sexo,periodo_entrada, data_conclusao, cidade);
		
		alunoController.inserir(aluno);
	}

	private void editar() {
		Scanner leitura = new Scanner(System.in);
		System.out.println("Entre com o id do aluno a ser editado:");

		try {
			int id = leitura.nextInt();
			leitura.nextLine();
			AlunoModel aluno = alunoController.buscarPorId((long) id);

			if (aluno != null) {
				System.out.println("Aluno encontrado: " + aluno.getNome_estudante());

				System.out.println("Entre com o novo nome do estudante:");
				String nomeEstudante = leitura.nextLine().trim().replaceAll("\\s+", " ");
				aluno.setNome_estudante(nomeEstudante);

				System.out.println("Entre com o novo coordenacao:");
				aluno.setCoordenacao(leitura.nextLine());

				System.out.println("Entre com o novo curso:");
				aluno.setCurso(leitura.nextLine());

				System.out.println("Entre com a nova situacao:");
				aluno.setSituacao(leitura.nextLine());

				System.out.println("Entre com o novo periodo de entrada:");
				aluno.setPeriodo_entrada(leitura.nextLine());

				System.out.println("Entre com a nova data de conclusao:");
				aluno.setData_conclusao(leitura.nextLine());

				System.out.println("Entre com a nova cidade:");
				aluno.setCidade(leitura.nextLine());

				alunoController.editar(aluno);
				System.out.println("Aluno editado com sucesso!");
			} else {
				System.out.println("Aluno não encontrado.");
			}
		} catch (InputMismatchException e) {
			System.out.println("ID inválido. Por favor, insira um número.");
		}
	}

	private void buscarPorNome() {
		Scanner leitura = new Scanner(System.in);
		System.out.println("Entre com o nome do estudante:");

		String nome = leitura.next();
		List<AlunoModel> alunos = alunoController.buscarPorNome(nome);

		if (alunos.isEmpty()) {
			System.out.println("Nenhum aluno encontrado com o nome: " + nome);
		} else {
			for (AlunoModel aluno : alunos) {
				System.out.println(aluno.getNome_estudante() + " - " + aluno.getCurso() + " - " + aluno.getCidade());
			}
		}
	}

	private void buscarPorCurso() {
		Scanner leitura = new Scanner(System.in);
		System.out.println("Entre com o curso do estudante:");

		String curso = leitura.next();
		List<AlunoModel> alunos = alunoController.buscarPorCurso(curso);

		if (alunos.isEmpty()) {
			System.out.println("Nenhum aluno encontrado no curso: " + curso);
		} else {
			for (AlunoModel aluno : alunos) {
				System.out.println(aluno.getNome_estudante() + " - " + aluno.getCurso() + " - " + aluno.getCidade());
			}
		}
	}

	private void buscarPorCidade() {
		Scanner leitura = new Scanner(System.in);
		System.out.println("Entre com a cidade do estudante:");

		String cidade = leitura.next();
		List<AlunoModel> alunos = alunoController.buscarPorCidade(cidade);

		if (alunos.isEmpty()) {
			System.out.println("Nenhum aluno encontrado na cidade: " + cidade);
		} else {
			for (AlunoModel aluno : alunos) {
				System.out.println(aluno.getNome_estudante() + " - " + aluno.getCurso() + " - " + aluno.getCidade());
			}
		}
	}


}