import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String inputNum  = sc.next();
        
        String arr[] = {"000","001","010","011","100","101","110","111"};
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<inputNum.length();i++){
            String addString = arr[Integer.parseInt(inputNum.charAt(i)+"")];
            sb.append(addString);    
        }
        
        if(sb.toString().equals("000")){
            System.out.print(0);
            System.exit(0);
        }
    
        for(int i=0;i<inputNum.length();i++){
            if(sb.charAt(i)=='0'){
                sb.delete(i,i+1);
                i--;
            }
            else{
                break;
            }
        }
        
        System.out.print(sb.toString());
        
    }
}
