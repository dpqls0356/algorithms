import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int year = 2024;
        int month = 8;
        
        for (int i = 1; i < n; i++) {
            month += 7;
            if (month > 12) {
                month -= 12;
                year++;
            }
        }
        
        System.out.println(year + " " + month);
    }
}