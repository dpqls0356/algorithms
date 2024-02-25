
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int top = N - 1;
        while (top > 0 && arr[top - 1] > arr[top]) {
            top--;
        }
        if (top == 0) {
            System.out.println(-1);
            System.exit(0);
        }
        int swapIndex = arr.length - 1;
        // for (int i = arr.length - 1; i > top; i--) {
        // if (arr[i] < arr[top - 1])
        // swapIndex = i;
        // }
        while (arr[top - 1] > arr[swapIndex]) {
            swapIndex--;
        }
        int tmp = arr[top - 1];
        arr[top - 1] = arr[swapIndex];
        arr[swapIndex] = tmp;
        Arrays.sort(arr, top, arr.length);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}