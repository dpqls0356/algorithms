import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex1940{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long M = Long.parseLong(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int s=0;
        int e=N-1;
        int count =0;
        while(s<e){
            if(M>arr[s]+arr[e]){
                s++;
            }
            else if(M<arr[s]+arr[e]){
                e--;
            }
            else{
                count++;
                s++;
                e--;
            }
        }
        System.out.println(count);
    }
}
