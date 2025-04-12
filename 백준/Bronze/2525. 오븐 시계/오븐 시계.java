import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        int cookingTime = scanner.nextInt();
        
        int totalMinutes = hour * 60 + minute + cookingTime;
        
        int endHour = (totalMinutes / 60) % 24;
        int endMinute = totalMinutes % 60;
        
        System.out.println(endHour + " " + endMinute);
        
        scanner.close();
    }
}