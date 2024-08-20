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
        	String valor = JOptionPane.showInputDialog(null,"0. Sair\n1. Inserir\n2. Buscar Todos\n3. Remover por Id\n4. Alterar");
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
				remover();
				break;
			default:
				System.out.println("Op��o Incorreta!");
				break;
			}
        }while(opcao != 0);
	}
	
	private void remover() {
		System.out.println("Entre com o id da pessoa");
		
	}
	
	private void buscar() {
		List<AlunoModel> listaDeAlunos = alunoController.buscar();
		for(AlunoModel aluno: listaDeAlunos) {
			System.out.println(aluno.getNome_estudante() + " - " + aluno.getCampus());
		}
	}
	
	private void inserir() {
		Scanner leitura = new Scanner(System.in);
		
		String campus = JOptionPane.showInputDialog(null,"Entre com o nome do campus!");
		
		System.out.println("Entre com o polo");
		String polo = leitura.next();
		
		System.out.println("Entre com o coordenacao");
		String coordenacao = leitura.next();
		
		System.out.println("Entre com o curso");
		String curso = leitura.next();
		
		System.out.println("Entre com o nome_estudante");
		String nome_estudante = leitura.next();
		
		System.out.println("Entre com o situacao");
		String situacao = leitura.next();
		
		int idade = 0;
		try {
			System.out.println("Entre com o idade");
			idade = leitura.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Entrou com o tipo de informa��o incorreta");
		}
		
		System.out.println("Entre com o sexo");
		String sexo = leitura.next();
		
		System.out.println("Entre com o email_institucional");
		String email_institucional = leitura.next();
		
		System.out.println("Entre com o periodo_entrada");
		String periodo_entrada = leitura.next();

		System.out.println("Entre com a data conclusao");
		String data_conclusao = leitura.next();

		System.out.println("Entre com a cidade");
		String cidade = leitura.next();
		AlunoModel aluno = new AlunoModel(campus, polo, coordenacao, curso,nome_estudante, situacao,sexo,periodo_entrada, data_conclusao, cidade);
		
		alunoController.inserir(aluno);
	}
}