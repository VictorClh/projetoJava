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
}
