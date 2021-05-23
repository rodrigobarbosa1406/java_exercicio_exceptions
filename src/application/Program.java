package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("INFORME OS DADOS DA CONTA");
			System.out.println();
			
			System.out.print("Número: ");
			int numero = sc.nextInt();
			
			System.out.print("Nome: ");
			String nome = sc.next();
			sc.nextLine();
			
			System.out.print("Saldo inicial: ");
			double saldo = sc.nextDouble();
			
			System.out.print("Limite de saque: ");
			double limiteSaque = sc.nextDouble();
			
			Account account = new Account(numero, nome, saldo, limiteSaque);
			
			System.out.println();
			
			System.out.print("Informe o valor para saque: ");
			double valor = sc.nextDouble();
			
			account.saque(valor);
			System.out.println("Saldo atualizado: " + account.getSaldo());
		}
		catch (DomainException e) {
			System.out.println("Erro no saque: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado: " + e.getMessage());
		}
		finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

}
