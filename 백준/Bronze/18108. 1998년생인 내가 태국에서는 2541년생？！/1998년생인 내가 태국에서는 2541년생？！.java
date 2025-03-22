import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int buddhistYear = scanner.nextInt();
        
        int commonEraYear = buddhistYear - 543;
        
        System.out.println(commonEraYear);
        
        scanner.close();
    }
}