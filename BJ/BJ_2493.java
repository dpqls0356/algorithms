package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2493 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        // 높이들을 담을 배열
        int arr[] = new int[N + 1];
        // 가장 높은 높이
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num > arr[max]) {
                max = i;
                arr[i] = num;
                sb.append(0 + " ");
            } else {
                sb.append(max + " ");
            }
        }
        System.out.println(sb.toString());
    }
}

// ㅋ 이악물고 모른 척 했는데 역시나 시간초과
// int arr[] = new int[N];
// st = new StringTokenizer(br.readLine());
// for(int i=0;i<N;i++) {
// arr[i] = Integer.parseInt(st.nextToken());
// }
//
// for(int i=0;i<N;i++) {
// if(i==0) {
// sb.append(0+" ");
// continue;
// }
// for(int k=i-1;k>=0;k--) {
// if(arr[k]>=arr[i]) {
// sb.append((k+1)+" ");
// break;
// }
// if(k-1<0) {
// sb.append(0+" ");
// }
// }
//
// }
// System.out.print(sb.toString());