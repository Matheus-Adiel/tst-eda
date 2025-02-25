import java.util.Scanner;
import java.util.Arrays;

public class TrocaVizinho {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        trocaVizinho(line);
        System.out.println(Arrays.toString(line));
    }

    public static void trocaVizinho(String[] tokens){
        String aux = new String();
        for (int i = 1; i < tokens.length; i += 2){
            aux = tokens[i - 1];
            tokens[i - 1] = tokens[i];
            tokens[i] = aux;
        }

    }

}
