import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static private int size;
    static private int maxNum;
    static private int[] arr;
    static private StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        maxNum = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());
        arr = new int[size+1];

        recrusive(0);
        System.out.println(sb.toString());
    }
    public static void recrusive(int depth){
        if(size==depth){
            for(int i=1;i<=size;i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
        }
        else{
            for(int i=1;i<=maxNum;i++){
                arr[depth+1] = i;
                recrusive(depth+1);
            }
        }
    }
}