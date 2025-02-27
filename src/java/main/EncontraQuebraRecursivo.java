import java.util.Scanner;

public class EncontraQuebraRecursivo {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		System.out.println(encontraQuebra(line, 0));
	}

	public static int encontraQuebra(String[] tokens, int index){
		if (index >= tokens.length - 1)
			return -1;
		if (Integer.parseInt(tokens[index]) > Integer.parseInt(tokens[index + 1]))
			return index + 1;
		return encontraQuebra(tokens, ++index);
	}

}
