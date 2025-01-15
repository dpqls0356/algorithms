import java.util.*;

public class Main {
    public static void main(String[] args) {
    
        StringBuilder sb = new StringBuilder();
        
        Scanner sc = new Scanner(System.in);
        
        long inputNum = sc.nextLong();
        
        if(inputNum == 0){
            System.out.print(0);
            System.exit(0);
        }
        while(inputNum!=1){
         if(inputNum<0){
                if(inputNum%(-2)!=0){
                    sb.insert(0,"1");
                    inputNum-=1;
                }
                else{
                    sb.insert(0,"0"); 
                }
                inputNum/=(-2); 
            }
            else{
                sb.insert(0,inputNum%(-2));
                inputNum/=(-2);
            }
        }
        sb.insert(0,"1");
        
        System.out.print(sb.toString());
        
    }
}
