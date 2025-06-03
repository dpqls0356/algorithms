import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String word = sc.nextLine();
       System.out.println(new StringBuilder(word).reverse().toString());
       sc.close();
   }
}