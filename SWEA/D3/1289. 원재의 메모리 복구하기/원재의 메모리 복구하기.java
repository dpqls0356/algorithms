import java.util.*;
class Solution{
    

    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            String str = sc.next();
            char before = '0';
            int count=0;
            for(int k=0;k<str.length();k++) {
            	if(before!=str.charAt(k)) {
            		before = str.charAt(k);
            		count++;
            	}
            }
                                                                                   
            System.out.println("#"+(i+1)+" "+count);
        }
    }
}