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
            int changeSum = 0;
            for(int k=0;k<3;k++){
                int n = Integer.parseInt(inputNum.charAt(size-1-i*3-k)+"");
                int change = (int)Math.pow(2,k)*n;
                changeSum+=change;
            }
            sb.insert(0,changeSum);
        }
        
        System.out.print(sb.toString());
                
    }
}
