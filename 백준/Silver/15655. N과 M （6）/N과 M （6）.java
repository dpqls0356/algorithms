import java.util.*;
import java.io.*;
public class Main {

    static private int size;
    static private int numberSize;
    static private int[] numbers;
    static private int[] arr;
    static private StringBuilder sb = new StringBuilder();

    public  static void main(String args[]) throws IOException{

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

    recrusive(0,0);

    System.out.println(sb.toString());

    }
    public static void recrusive(int depth,int beforeNumber){
        if(depth==size){
            for(int i = 0;i<size;i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
        }
        else{
            for(int i = beforeNumber;i<numberSize;i++){
                arr[depth] =  numbers[i];
                recrusive(depth+1,i+1);
            }
        }
    }

}