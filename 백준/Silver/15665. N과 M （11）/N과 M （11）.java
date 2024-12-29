import java.util.*;
import java.io.*;

public class Main {

    private static int size;
    private static int inputSize;
    private static int[] arr;
    private static int[] numbers;
    private static HashSet<String> history = new HashSet<String>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        inputSize = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());

        arr = new int[size];
        numbers = new int[inputSize];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<inputSize;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        recrusive(0);

        System.out.println(sb.toString());
    }
    public static void recrusive(int depth){
        if(size==depth){
            StringBuilder permutation = new StringBuilder();
            for(int i=0;i<size;i++){
                permutation.append(arr[i]+" ");
            }
            permutation.append("\n");
            if(!history.contains(permutation.toString())){
                history.add(permutation.toString());
                sb.append(permutation.toString());
            }
        }
        else{
            for(int i=0;i<inputSize;i++){
                arr[depth] = numbers[i];
                recrusive(depth+1);
            }
        }
    }
}