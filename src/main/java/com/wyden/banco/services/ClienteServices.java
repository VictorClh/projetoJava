package com.wyden.banco.services;

import java.util.Scanner;

import com.wyden.banco.dao.ClienteDao;
import com.wyden.banco.entity.Cliente;

public class ClienteServices {
	
	public static void criar() {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("CPF: ");
		String cpf = scanner.nextLine();
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Fone: ");
		String fone = scanner.nextLine();
		
		Cliente objCliente = new Cliente(cpf, nome, fone);

		ClienteDao objClienteDAO = new ClienteDao();
		objClienteDAO.create(objCliente);

	}

}
