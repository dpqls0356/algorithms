import java.io.*;
import java.util.*;

public class Main {

    static private int numberSize;
    static private int size;
    static private int[] arr;
    static private int[] numbers;
    static private StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numberSize = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());

        arr = new int[size];
        numbers = new int[numberSize];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<numberSize;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        recrusive(0);

        System.out.print(sb.toString());

    }
    public static void recrusive(int depth){

        if(depth==size){
            for(int i=0;i<size;i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
        }
        else{
            for(int i=0;i<numberSize;i++){
                arr[depth] = numbers[i];
                recrusive(depth+1);
            }
        }
    }
}