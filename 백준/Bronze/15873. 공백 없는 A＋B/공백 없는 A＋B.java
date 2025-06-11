import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        int result = 0;
        
        if (input.length() == 2) {
            int a = input.charAt(0) - '0';
            int b = input.charAt(1) - '0';
            result = a + b;
        } else if (input.length() == 3) {
            int a1 = Integer.parseInt(input.substring(0, 2));
            int b1 = Integer.parseInt(input.substring(2, 3));
            
            int a2 = Integer.parseInt(input.substring(0, 1));
            int b2 = Integer.parseInt(input.substring(1, 3));
            
            if (a1 <= 10 && b1 <= 10) {
                result = a1 + b1;
            } else {
                result = a2 + b2;
            }
        } else if (input.length() == 4) {
            int a = Integer.parseInt(input.substring(0, 2));
            int b = Integer.parseInt(input.substring(2, 4));
            result = a + b;
        }
        
        System.out.println(result);
        sc.close();
    }
}