package com.myproject.integrante.main;

import java.util.Scanner;

import org.hibernate.Session;

import com.myproject.integrante.entity.Integrante;
import com.myproject.integrante.util.HibernateUtil;
import com.myproject.integrante.utilities.IntegranteUtilities;

public class MainApp {

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		int opcao;

		do {

			opcao = menuPrincipal();
			switch (opcao) {

			case 1:
				IntegranteUtilities.criar();
				break;
			case 2:
				IntegranteUtilities.consultar();
				break;
			case 3:
				System.out.println("Alterar um integrante.");
				//IntegranteUtilities.buscarPorCpf(null);
				break;
			case 4:
				IntegranteUtilities.excluir();
				break;
			case 5:
				System.out.println("\nFim de programa\n");
				break;

			default:
				System.out.println("\nOpção inválida\n");
			}

		} while (opcao != 9);

	}

	public static int menuPrincipal() {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n\nEscolha a opcao:");
		System.out.println("1. Criar um integrante");
		System.out.println("2. Consultar um integrante");
		System.out.println("3. Alterar um integrante");
		System.out.println("4. Excluir um integrante");
		System.out.println("5. Sair");
		
		
		System.out.print("Opcao: ");
		
		int opt = scanner.nextInt();

		return opt;

	}

}
