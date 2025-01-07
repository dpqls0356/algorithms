import java.util.*;
import java.io.*;
public class Main {
    private static int N;
    private static int K;
    private static int cnt = 0;
    private static boolean visited[];
    private static HashSet<String> history = new HashSet<>();
    private static int inputArr[];
    private static int arr[];
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        inputArr = new int[N];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K];
        
        for(int i=0;i<N;i++){
            st =  new StringTokenizer(br.readLine());
            inputArr[i] =Integer.parseInt(st.nextToken());
        }
        recrusive(0);
        System.out.println(cnt);
    }
    public static void recrusive(int depth){
        if(depth == K){
            StringBuilder permutation = new StringBuilder();
            for(int i=0;i<K;i++){
                permutation.append(arr[i]+"");
            }
            if(!history.contains(permutation.toString())){
                cnt++;
                history.add(permutation.toString());
            }
        }
        else{
            for(int i=0;i<N;i++){
                if(!visited[i]){
                    visited[i] = true;
                    arr[depth] = inputArr[i];
                    recrusive(depth+1);
                    visited[i] = false;
                }
            }
        }
    }
}
