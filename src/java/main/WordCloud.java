import java.util.HashMap;
import java.util.Scanner;

public class WordCloud {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] token = sc.nextLine().split(" ");
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 0; i < token.length; i++) {
            if (hashMap.get(token[i]) != null)
                hashMap.put(token[i], hashMap.get(token[i]) + 1);
            else
                hashMap.put(token[i], 1);
        }
        String in = sc.nextLine();
        while (!in.equals("fim")){
            System.out.println(hashMap.get(in));
            in = sc.nextLine();
        }
    }

}
