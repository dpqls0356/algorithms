package BJ;

import java.util.*;

public class BJ_1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;
        if (str.charAt(0) != ' ')
            count++;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        System.out.print(count);

    }
}