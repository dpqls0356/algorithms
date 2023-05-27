import java.util.Scanner;
import java.util.Stack;
 
public class ex1874 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 스택
        Stack <Integer> st = new Stack<>();
        st.push(0);
        // 입력값
        int arr[] = new int[n];
        // 결과
        StringBuffer bf = new StringBuffer();

        // 입력값 받기
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        // 루프 돌리기
        int num=1;
        for(int i=0;i<n;i++){
            if(arr[i]<st.peek()){
                System.out.println("NO");
                return;
            }
            while(true){
                if(arr[i]!=st.peek()){
                    st.push(num);
                    bf.append("+\n");
                    num++;
                }
                else{
                    st.pop();
                    bf.append("-\n");
                    break;
                }
            }
        }
        System.out.println(bf.toString());
	}
}