package carregabanco.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import carregabanco.controller.ServidorController;
import carregabanco.model.AlunoModel;
import carregabanco.model.ServidorModel;

public class ServidorView {
    private ServidorController servidorController = new ServidorController();

    public ServidorView() {
        Scanner leitura = new Scanner(System.in);
        int opcao = 0;
        do {
            String valor = JOptionPane.showInputDialog(null,"0. Sair\n1. Inserir\n2. Buscar Todos\n3. Buscar por ID\n4. Buscar por Nome.\n5. Buscar por Cargo.\n6. Buscar por Setor\n7. Deletar Servidor\n8. Editar Servidor");
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
                    buscarPorCargo();
                    break;
                case 6:
                    buscarPorSetor();
                    break;
                case 7:
                    remover();
                    break;
                case 8:
                    editar();
                    break;
                default:
                    System.out.println("Opção Incorreta!");
                    break;
            }
        }while(opcao != 0);
    }

    private void remover() {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Entre com o id do servidor a ser removido:");

        try {
            long id = leitura.nextInt();
            boolean removido = servidorController.removerPorID(id);

            if (!removido) {
                System.out.println("Aluno não encontrado.");
            }

            System.out.println("Aluno removido com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("ID inválido. Por favor, insira um número.");
        }
    }

    private void buscar() {
        List<ServidorModel> listaDeServidores = servidorController.buscar();
        for(ServidorModel servidor: listaDeServidores) {
            System.out.println(servidor.getNome_servidor() + " - " + servidor.getCampus_lotacao());
        }
    }

    private void buscarPorID() {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Entre com o ID do servidor:");
        Long id = leitura.nextLong();

        ServidorModel servidor = servidorController.buscarPorId(id);
        if (servidor != null) {
            System.out.println("Servidor encontrado:");
            System.out.println("ID: " + servidor.getIdPessoa());
            System.out.println("Nome: " + servidor.getNome_servidor());
            System.out.println("Cargo: " + servidor.getCargo());
            System.out.println("Setor: " + servidor.getSetor_lotacao());
        } else {
            System.out.println("Servidor com ID " + id + " não encontrado.");
        }
    }

    private void inserir() {
        Scanner leitura = new Scanner(System.in);

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

        ServidorModel servidor = new ServidorModel(nome_servidor, email_contato, cargo, campus_lotacao,	setor_lotacao);

        servidorController.inserir(servidor);
    }

    private void editar() {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Entre com o id do servidor a ser editado:");

        try {
            int id = leitura.nextInt();
            leitura.nextLine();
            ServidorModel servidor = servidorController.buscarPorId((long) id);

            if (servidor != null) {
                System.out.println("Servidor encontrado: " + servidor.getNome_servidor());

                System.out.println("Entre com o novo nome do servidor:");
                String nomeServidor = leitura.nextLine().trim().replaceAll("\\s+", " ");
                servidor.setNome_servidor(nomeServidor);

                System.out.println("Entre com o novo email para contato:");
                servidor.setEmail_contato(leitura.nextLine());

                System.out.println("Entre com o novo cargo:");
                servidor.setCampus_lotacao(leitura.nextLine());

                System.out.println("Entre com o novo campus lotação:");
                servidor.setCampus_lotacao(leitura.nextLine());

                System.out.println("Entre com o novo setor de Lotacao:");
                servidor.setSetor_lotacao(leitura.nextLine());
            } else {
                System.out.println("Servidor não encontrado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("ID inválido. Por favor, insira um número.");
        }
    }

    private void buscarPorNome() {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Entre com o nome do servidor:");

        String nome = leitura.next();
        List<ServidorModel> servidores = servidorController.buscarPorNome(nome);

        if (servidores.isEmpty()) {
            System.out.println("Nenhum servidor encontrado com o nome: " + nome);
        } else {
            for (ServidorModel servidor : servidores) {
                System.out.println(servidor.getNome_servidor() + " - " + servidor.getCargo() + " - " + servidor.getSetor_lotacao());
            }
        }
    }

    private void buscarPorCargo() {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Entre com o cargo do servidor:");

        String cargo = leitura.next();
        List<ServidorModel> servidores = servidorController.buscarPorCargo(cargo);

        if (servidores.isEmpty()) {
            System.out.println("Nenhum servidor encontrado com esse cargo: " + cargo);
        } else {
            for (ServidorModel servidor : servidores) {
                System.out.println(servidor.getNome_servidor() + " - " + servidor.getCargo() + " - " + servidor.getSetor_lotacao());
            }
        }
    }

    private void buscarPorSetor() {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Entre com o setor do servidor:");

        String setor = leitura.next();
        List<ServidorModel> servidores = servidorController.buscarPorSetor(setor);

        if (servidores.isEmpty()) {
            System.out.println("Nenhum servidor encontrado nesse setor: " + setor);
        } else {
            for (ServidorModel servidor : servidores) {
                System.out.println(servidor.getNome_servidor() + " - " + servidor.getCargo() + " - " + servidor.getSetor_lotacao());
            }
        }
    }
}