import java.util.*;
import java.io.*;

    // 1개 이상의 모음과 두자의 자음
    // 증가하는 순서로 배열
    // strLen, inputSize;
    
    /*
        inputSize의 정렬된 알파벳 중 strLen개 를 골라 출력하면 됨
        함수에 depth , 모음 수 , 자음 수  이렇게 전달하면 될 듯 ?
        
    */
    
public class Main {
    
    private static int strLen;
    private static int inputSize;
    private static char[] letters;
    private static char[] code;
    private static String gathers = "aeoui";
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        strLen = Integer.parseInt(st.nextToken());
        inputSize= Integer.parseInt(st.nextToken());
        letters = new char[inputSize];
        code = new char[strLen];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<inputSize;i++){
            letters[i] = st.nextToken().charAt(0);
        }
        
        Arrays.sort(letters);
        
        recrusive(0,0,0,0);
        
        System.out.println(sb.toString());
    
    }
    
    public static void recrusive(int depth,int consonant,int gather,int beforeIndex){
        if(depth==strLen){
            if(consonant>=2&&gather>=1){
                for(int i=0;i<strLen;i++){
                    sb.append(code[i]);
                }
                sb.append("\n");
            }
        }
        else{
            for(int i=beforeIndex;i<inputSize;i++){
                code[depth] = letters[i];
                if(!gathers.contains(letters[i]+"")){
                    recrusive(depth+1,consonant+1,gather,i+1);
                }
                else{
                    recrusive(depth+1,consonant,gather+1,i+1);
                }
                
            }
        }
    }
}
