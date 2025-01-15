import java.util.*;

public class Main {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        
        String inputNum  = sc.next();
        
        int addSize = inputNum.length();
        
        for(int i=addSize;i%3!=0;i++){
            inputNum = "0"+inputNum;
        }
        
        int size = inputNum.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<size/3;i++){
            int changeSum = 
            (int)
            (Integer.parseInt(inputNum.charAt(i*3)+"")*Math.pow(2,2)
            +Integer.parseInt(inputNum.charAt(i*3+1)+"")*Math.pow(2,1)
            +Integer.parseInt(inputNum.charAt(i*3+2)+"")*Math.pow(2,0));
            
            sb.append(changeSum);
        }
        
        System.out.print(sb.toString());
                
    }
}