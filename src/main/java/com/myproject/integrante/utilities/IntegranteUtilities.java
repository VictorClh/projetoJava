package com.myproject.integrante.utilities;

import java.util.List;
import java.util.Scanner;

import com.myproject.integrante.dao.IntegranteDao;
import com.myproject.integrante.entity.Integrante;

public class IntegranteUtilities {
	
	public static void criar() {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("CPF: ");
		String cpf = scanner.nextLine();
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.println("Projeto: ");
		String projeto = scanner.nextLine();
		System.out.println("Data de Nascimento: ");
		String dataNasc = scanner.nextLine();
		System.out.print("Fone: ");
		String fone = scanner.nextLine();
		
		Integrante objIntegrante = new Integrante(cpf, nome, projeto, dataNasc, fone);

		IntegranteDao objIntegranteDAO = new IntegranteDao();
		objIntegranteDAO.create(objIntegrante);
		
		
	}
	public static void consultar() {
		IntegranteDao integranteDao = new IntegranteDao();
        List<Integrante> integrantes = integranteDao.getAll();

        System.out.println("Lista de Integrantes:");
        for (Integrante integrante : integrantes) {
            System.out.println("CPF: " + integrante.getCpf());
            System.out.println("Nome: " + integrante.getNome());
            System.out.println("Projeto: " + integrante.getProjeto());
            System.out.println("Data de Nascimento: " + integrante.getDataNasc());
            System.out.println("Fone: " + integrante.getFone());
            System.out.println("------------------------------------");
		
	}
	}
	
	/* METODO PARA ALTERAR O CADASTRO DE UM INTEGRANTE
	 
	 public static void criarOuAtualizar() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Escolha a opção:");
	        System.out.println("1 - Criar");
	        System.out.println("2 - Atualizar");
	        int opcao = scanner.nextInt();

	        if (opcao == 1) {
	            criar();
	        } else if (opcao == 2) {
	            consultar();
	            System.out.print("Digite o CPF do integrante que deseja atualizar: ");
	            String cpf = scanner.next();
	            Integrante integrante = buscarPorCpf(cpf);

	            if (integrante != null) {
	                // Atualize os campos conforme necessário
	                System.out.print("Novo Nome: ");
	                String novoNome = scanner.next();
	                integrante.setNome(novoNome);

	                IntegranteDao integranteDao = new IntegranteDao();
	                integranteDao.update(integrante);
	                System.out.println("Integrante atualizado com sucesso!");
	            } else {
	                System.out.println("Integrante não encontrado.");
	            }
	        }
	    }
	
	 public static Integrante buscarPorCpf(String cpf) {
	        IntegranteDao integranteDao = new IntegranteDao();
	        return integranteDao.getByCpf(cpf);
	    }*/
	
	public static void excluir() {
        Scanner scanner = new Scanner(System.in);
            consultar();
            System.out.print("Digite o CPF do integrante que deseja excluir: ");
            String cpf = scanner.next();
            Integrante integrante = buscarPorCpf(cpf);

            if (integrante != null) {
                IntegranteDao integranteDao = new IntegranteDao();
                integranteDao.delete(integrante);
                System.out.println("Integrante excluído com sucesso!");
            } else {
                System.out.println("Integrante não encontrado.");
            }
        }
	private static Integrante buscarPorCpf(String cpf) {
		IntegranteDao integranteDao = new IntegranteDao();
        return integranteDao.getByCpf(cpf);
	}
}
