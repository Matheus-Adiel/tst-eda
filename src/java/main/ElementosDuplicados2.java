import java.util.Scanner;
import java.util.HashSet;

class ElementosDuplicados1 {
	public static void main(String[] args){

		boolean duplicado = false;
		HashSet<String> dados = new HashSet<String>();

		//leitura dos dados
		Scanner sc = new Scanner(System.in);
		String[] elementos = sc.nextLine().split(" ");

		//verificando elementos duplicados
		for (int i = 0; i < elementos.length; i++){
			if (dados.contains(elementos[i])) {
				duplicado = true;
				break;
			} else {
				dados.add(elementos[i]);
			}

		}

		//resultado
		System.out.println(duplicado ? "true" : "false");

	}
}
