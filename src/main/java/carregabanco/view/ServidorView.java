package carregabanco.view;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import carregabanco.controller.ServidorController;
import carregabanco.model.ServidorModel;

public class ServidorView {
    private ServidorController servidorController = new ServidorController();

    public ServidorView() {
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
        List<ServidorModel> listaDeServidores = servidorController.buscar();
        for(ServidorModel servidor: listaDeServidores) {
            System.out.println(servidor.getNome_servidor() + " - " + servidor.getCampus_lotacao());
        }
    }

    private void inserir() {
        Scanner leitura = new Scanner(System.in);

        String campus = JOptionPane.showInputDialog(null,"Entre com o nome do campus!");

        System.out.println("Entre com o nome servidor");
        String nome_servidor = leitura.next();


        System.out.println("Entre com o email servidor");
        String email_contato = leitura.next();

        System.out.println("Entre com o cargo");
        String cargo = leitura.next();

        System.out.println("Entre com o campus");
        String campus_lotacao = leitura.next();

        System.out.println("Entre com o setor");
        String setor_lotacao = leitura.next();

        ServidorModel servidor = new ServidorModel(nome_servidor, email_contato, cargo, campus,	setor_lotacao);

        servidorController.inserir(servidor);
    }
}