import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static private int size;
    static private int maxNumber;
    static private boolean visited[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        maxNumber = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());

        visited = new boolean[maxNumber+1];
        for(int i = 1;i<=maxNumber;i++){
            visited[i] = true;
            recrusive(1,i+"",i);
        }

    }
    static public void recrusive(int cnt,String result,int beforeNumber){
        if(cnt ==size){
            System.out.println(result);
        }
        else{
            for(int i=1;i<=maxNumber;i++){
                if(i>beforeNumber&&!visited[i]){
                    visited[i]= true;
                    recrusive(cnt+1,result+" "+i,i);
                    visited[i]= false;
                }
            }
        }
    }
}