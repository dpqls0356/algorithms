import java.util.*;
import java.io.*;

public class Main {
    
    private static int N; // 순열 사이즈
    private static int type; // 문제 타입
    private static List<Integer> quesetionPermutation = new ArrayList<>(); // 순서를 찾아야하는 순열
    private static long questionNumber; // 순서
    private static List<Integer> arr = new ArrayList<>(); // 1,2,3,...,N 를 담아놓을 공간
    private static StringBuilder sb = new StringBuilder(); 
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        for(int i=1;i<=N;i++){
            arr.add(i);
        }
        
        st = new StringTokenizer(br.readLine());
        type = Integer.parseInt(st.nextToken());
        
        if(type==1){
            questionNumber = Long.parseLong(st.nextToken());
            findPermutation();
        }
        else {
            for(int i=1;i<=N;i++){
                quesetionPermutation.add(Integer.parseInt(st.nextToken()));
            }
            findNumber();
        }
    }
    
public static void findPermutation(){
    long k = questionNumber - 1; // k를 0-based로 변경
    int size = N;
    while(size>0){
        if(size==1){
            sb.append(arr.get(0));
        }
        else{
            long cal = permutation(size-1);
            int index = (int)(k / cal);
            k = k % cal;
            sb.append(arr.get(index)+" ");
            arr.remove(index);
        }
        size--;
    }
    System.out.print(sb.toString());
}
    
    public static void findNumber(){
        long answer = 1L;
        //1234
        for(int i=1;i<=N;i++){
            long cal = permutation(N-i);
            int index = arr.indexOf(quesetionPermutation.get(i-1));
            arr.remove(index);
            answer += (cal*index);
        }
        System.out.print(answer);
    }
    
    public static long permutation(int n){
        if(n==1||n==0)return 1L;
        else{
            return n*permutation(n-1);
        }
    }
}