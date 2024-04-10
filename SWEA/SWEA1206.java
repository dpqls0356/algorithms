package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1206 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("sw/D3/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 건물의 수
            int T = Integer.parseInt(st.nextToken());
            // 조망확보
            int count = 0;
            int arr[] = new int[T];
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < T; k++) {
                arr[k] = Integer.parseInt(st.nextToken());
            }
            for (int k = 0; k < T; k++) {
                if (arr[k] == 0)
                    continue;
                else {
                    int big = 0;
                    for (int j = k - 2; j < k + 3; j++) {
                        if (j == k)
                            continue;
                        else {
                            if (big < arr[j])
                                big = arr[j];
                        }
                    }
                    if (arr[k] > big)
                        count += (arr[k] - big);
                }
            }

            System.out.println("#" + i + " " + count);
        }

    }
}
