package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ11659 {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // int N = sc.nextInt();
        // int M = sc.nextInt();
        // long []array = new long[N];
        // long []sum = new long[N];
        // for(int i = 0;i<N;i++){
        // array[i]=sc.nextLong();
        // if(i==0)sum[0]= array[0];
        // else sum[i]= sum[i-1]+array[i];
        // }
        // long []result = new long[M];
        // for(int i=0;i<M;i++){
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // if(a-1<=0)result[i]=sum[b-1];
        // else result[i] = sum[b-1]-sum[a-2];
        // }
        // for(int i =0;i<M;i++){
        // System.out.println(result[i]);
        // }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        long[] s = new long[N + 1];
        // 0인덱스 시작이 아닌 1인덱스 시작
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i < N + 1; i++) {
            s[i] = s[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(s[b] - s[a - 1]);
        }
    }
}
