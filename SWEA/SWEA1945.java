
import java.io.*;
import java.util.*;

public class SWEA1945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            long num = Long.parseLong(st.nextToken());
            int countarr[] = { 0, 0, 0, 0, 0 };
            int arr[] = { 2, 3, 5, 7, 11 };
            System.out.print("#" + (i + 1) + " ");
            for (int k = 0; k < 5; k++) {
                while (num % arr[k] == 0) {
                    countarr[k]++;
                    num /= arr[k];
                }
                System.out.print(countarr[k] + " ");
            }
            System.out.println();
        }
    }
}
