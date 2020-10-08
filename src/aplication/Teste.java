package aplication;

import java.util.Scanner;

import ABB.ABBint;

public class Teste {

	public static void main(String[] args) {
		Scanner le = new Scanner(System.in);
		
		ABBint tree = new ABBint();
		int[] valores = new int[]{ 20, 15, 10, 18, 17, 45, 47, 50, 57 };
		for (int i : valores) {
			tree.root = tree.inserirAVL(tree.root, i);		
		}
	
		/* System.out.println("Digite valor");
		int valor = le.nextInt();
		
		while (valor >=0) {
			tree.root = tree.inserir(tree.root,valor);
			System.out.println("Digite valor positivo para inserir na ABB ou negativo para sair");
			valor = le.nextInt();
		} */
		
		System.out.println("********* Apresenta��o em Ordem *********************");
		tree.inOrdem(tree.root);
		
		// System.out.println("Numero de n�s presentes na ABB: " + tree.contaNos(tree.root, 0));
		// System.out.println("Existe n�mero 1 na �rvore: " + tree.consulta(tree.root, 1));
		// System.out.println("Qtde de numeros 1: " + tree.contaNosSe(tree.root, 0, 1));
		
		tree.root = tree.removerValor(tree.root, 47);
		tree.root = tree.removerValor(tree.root, 45);
		tree.root = tree.removerValor(tree.root, 15);
		
		System.out.println("********* Apresenta��o em Ordem *********************");
		tree.inOrdem(tree.root);
		
		System.out.println("Máximo valor: ");
		System.out.println(tree.maximo(tree.root));
		System.out.println("Minimo valor: ");
		System.out.println(tree.minimo(tree.root));
		
		le.close();
		

	}

}
