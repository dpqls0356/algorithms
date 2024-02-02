import java.util.*;
import java.io.*;

public class SWEA1208 {
    public static void recursive(int arr[], int cnt) {
        Arrays.sort(arr);
        if (cnt - 1 < 0 || arr[arr.length - 1] - arr[0] < 1) {
            System.out.println((arr[99] - arr[0]));
        } else {
            arr[0]++;
            arr[arr.length - 1]--;
            recursive(arr, --cnt);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int arr[] = new int[100];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < 100; k++) {
                arr[k] = Integer.parseInt(st.nextToken());
            }
            System.out.print("#" + (i + 1) + " ");
            recursive(arr, cnt);
        }
    }
}
