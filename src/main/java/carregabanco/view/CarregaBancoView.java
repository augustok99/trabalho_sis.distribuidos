package carregabanco.view;

import java.util.ArrayList;

import carregabanco.controller.CarregaBancoController;
import carregabanco.model.AlunoModel;
import carregabanco.model.ServidorModel;

public class CarregaBancoView {
	public CarregaBancoView() {
        //JOptionPane.showMessageDialog(null,"Meu primeiro programa gráfico!\n Obrigado, Curso Java Progressivo!");
		CarregaBancoController carregaBancoController = new CarregaBancoController();
		ArrayList<AlunoModel> valoresEstudantes = carregaBancoController.loaderAluno("aluno/estudantes.csv");
		ArrayList<ServidorModel> valoresServidores = carregaBancoController.loaderServidor("servidor/servidores.csv");
		carregaBancoController.inserirNoBancoAluno(valoresEstudantes);
		carregaBancoController.inserirNoBancoServidor(valoresServidores);
		
		//A parte da visualização seria isso
		System.out.println("Estudantes:\n " + valoresEstudantes.size());
		for(AlunoModel n: valoresEstudantes)
			System.out.println(n.getCampus() + " - " + n.getNome_estudante()+ " - " + n.getIdade());

		System.out.println("Servidores:\n " + valoresServidores.size());
		for(ServidorModel n: valoresServidores)
			System.out.println(n.getCampus_lotacao() + " - " + n.getNome_servidor() + " - " + n.getCargo());
		
	}
}