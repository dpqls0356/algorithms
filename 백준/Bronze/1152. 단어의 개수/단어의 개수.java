import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        if (input.isEmpty()) {
            System.out.println(0);
            return;
        }
        
        input = input.trim();
        if (input.isEmpty()) {
            System.out.println(0);
            return;
        }
        
        String[] words = input.split(" ");
        System.out.println(words.length);
    }
}