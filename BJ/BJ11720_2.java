
import java.util.Scanner;

public class BJ11720_2 {
  // public static void main(String[] args) {
  // // 숫자가 100까지 받을 수 있기때문에 int나 long으로 값을 받을 수가 없다는 것을 알아야함
  // Scanner scan = new Scanner(System.in);
  // long testcase = scan.nextLong();
  // scan.nextLine();
  // String number = scan.nextLine();
  // long sum = 0;
  // // toCharArray로 변경하면 인덱스 접근이 쉬움
  // for(int i =0; i<testcase;i++){
  // sum+=(int)(number.charAt(i)-'0');
  // }
  // System.out.println(sum);
  // scan.close();
  // }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.nextLine();
    String sNum = sc.nextLine();
    char[] cNum = sNum.toCharArray();

    long sum = 0;
    for (int i = 0; i < cNum.length; i++)
      sum += cNum[i] - '0';
    System.out.println(sum);
  }
}
