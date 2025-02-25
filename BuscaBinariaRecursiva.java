import java.util.Scanner;

public class BuscaBinariaRecursiva {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		int key = sc.nextInt();
		buscaBinaria(line, 0, line.length - 1, key);
	}

	public static int buscaBinaria(String[] tokens, int ini, int fim, int key){
		if (ini <= fim) {
			int meio = (ini + fim)/2;
			System.out.println(meio);
			if (Integer.parseInt(tokens[meio]) == key)
				return meio;
			if (Integer.parseInt(tokens[meio]) > key)
				return buscaBinaria(tokens, ini, meio - 1, key);
			return buscaBinaria(tokens, meio + 1, fim, key);
		}
		System.out.println("-1");
		return -1;
	}

}
