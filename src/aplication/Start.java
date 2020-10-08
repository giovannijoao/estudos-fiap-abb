package aplication;

import java.util.Scanner;

import ABB.ABBint;

public class Start {
	private static ABBint tree = new ABBint();
	private static Scanner le = new Scanner(System.in);
	
	public static void showOption(int id, String option) {		
		System.out.print(id + ". " + option + "\n");
	}
	
	public static void main(String[] args) {
		boolean running = true;
		int opt = -1;
		do {
			System.out.println();
			showOption(1, "Inserir valor");
			showOption(2, "Apresentar em ordem");
			showOption(3, "Consultar valor");
			showOption(4, "Apresenta FB");
			opt = le.nextInt();
			System.out.println();
			if (opt == 1) {
				insert();			
			} else if (opt == 2) {
				System.out.println("Em ordem:");
				tree.inOrdem(tree.root);				
			} else if (opt == 3) { 
				consult();
			} else if (opt == 4) {
				tree.mostraFB(tree.root);
			} else {
				running = false;
			}
		} while (running != false); 
	}
	
	public static void insert() {
		System.out.print("Qual valor deseja inserir?\n: ");
		int dado = le.nextInt();
		tree.root = tree.inserirAVL(tree.root, dado);
		tree.atualizaAlturas(tree.root);
		System.out.println("Inserido " + dado + ".\n");
	}
	
	public static void consult() {
		System.out.print("Qual valor deseja consultar?\n: ");
		int dado = le.nextInt();
		if (tree.consulta(tree.root, dado)) {
			System.out.println("Número existe na base.");
		} else {
			System.out.println("Número não existe na base.");
		}		
	}

}
