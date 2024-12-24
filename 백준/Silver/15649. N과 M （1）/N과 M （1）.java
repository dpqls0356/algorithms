import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {

    static private int size;
    static private int maxNumber;
    static private boolean visited[];
    public static void main(String args[]) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        maxNumber = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());
        visited = new boolean[maxNumber+1];

            re("",0 );
    }
    public static void re(String result,int cnt){
        if(cnt ==size){
            System.out.println(result);
        }
        else{
            for(int i = 1;i<=maxNumber;i++){
                if(!visited[i]){
                    String str= result+i+" ";
                    visited[i]= true;
                    re(str,cnt+1);
                    visited[i]=false;
                }
            }
        }
    }
}