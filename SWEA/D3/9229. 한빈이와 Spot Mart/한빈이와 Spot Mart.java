
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static int arr[];
    public static  int N;
    public static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
             N = Integer.parseInt(st.nextToken());
             M = Integer.parseInt(st.nextToken());
           
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                arr[k] = Integer.parseInt(st.nextToken());
            }
//            System.out.println("-------------");
            int maxSum = Integer.MIN_VALUE;
            for(int k=0;k<N;k++) {
            	int sum =0;
            	sum+=arr[k];
            	for(int j=k+1;j<N ;j++) {
            		sum+=arr[j];
//            		System.out.println("-"+k+" "+j+" "+sum);
            		if(maxSum<sum&&sum<=M) {
//            			System.out.println("--"+k+" "+j+" "+sum);
            			maxSum=sum;
            		}
            		sum-=arr[j];
            	}
            }
            if(maxSum <= 0)System.out.println("#"+(i+1)+" -1");
            else System.out.println("#"+(i+1)+" "+maxSum);
        }
    }


}

