import java.io.*;
import java.util.*;
public class Main {
    private static int inputSize;
    private static int combinationSize;
    private static int[] combinationArr;
    private static int[] inputNumbers;
    private static HashSet<String> history = new HashSet<String>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        inputSize = Integer.parseInt(st.nextToken());
        combinationSize = Integer.parseInt(st.nextToken());

        combinationArr = new int[combinationSize];
        inputNumbers = new int[inputSize];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<inputSize;i++){
            inputNumbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputNumbers);

        recrusive(0,0);

        System.out.println(sb.toString());
    }
    public static void recrusive(int depth,int beforeIndex){
        if(combinationSize==depth){
            StringBuilder combination = new StringBuilder();
            for(int i=0;i<combinationSize;i++){
                combination.append(combinationArr[i]+" ");
            }
            combination.append("\n");
            if(!history.contains(combination.toString())){
                history.add(combination.toString());
                sb.append(combination.toString());
            }
        }
        else{
            for(int i=beforeIndex;i<inputSize;i++){
                combinationArr[depth] = inputNumbers[i];
                recrusive(depth+1,i);
            }
        }
    }
}