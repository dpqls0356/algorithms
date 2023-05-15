import java.util.Scanner;

// 데이터의 길이가 1000000으로 크기가 크기에 시간 복잡도눈 O(n)이내여야함
public class ex12891 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long dis = sc.nextLong();
        long pw = sc.nextLong();
        sc.nextLine();
        String dna = sc.nextLine();
        long checkarr[] = new long[4];
        for(int i=0;i<4;i++){
            checkarr[i]=sc.nextLong();
        }
        long count =0;

       
        long arr[] = {0,0,0,0};
        for(long i = 0 ; i<=dis-pw;i++){
            long fact=0;
            if(i==0){
                for(long k=0;k<pw;k++){
                    if(dna.charAt((int)k) == 'A')arr[0]++;
                    else if(dna.charAt((int)k)=='C')arr[1]++;
                    else if(dna.charAt((int)k)=='G')arr[2]++;
                    else if(dna.charAt((int)k)=='T')arr[3]++;
                }
            }
            else{
                if(dna.charAt((int)i-1) == 'A')arr[0]--;
                else if(dna.charAt((int)i-1)=='C')arr[1]--;
                else if(dna.charAt((int)i-1)=='G')arr[2]--;
                else if(dna.charAt((int)i-1)=='T')arr[3]--;
                if(dna.charAt((int)(i+pw-1)) == 'A')arr[0]++;
                else if(dna.charAt((int)(i+pw-1))=='C')arr[1]++;
                else if(dna.charAt((int)(i+pw-1))=='G')arr[2]++;
                else if(dna.charAt((int)(i+pw-1))=='T')arr[3]++;
            }
            for(long a=0;a<4;a++){
                if(checkarr[(int)a]<=arr[(int)a])fact++;
            }
            if(fact == 4)count++;
        }
        System.out.print(count);
    }
}
//////////////////////////정석 코드////////////////////////
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.*;

// public class ex12891 {

//     static int checkArr[];
//     static int myArr[];
//     static int checkSecret;


//     public static void main(String[] args) throws NumberFormatException, IOException {

//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
// // 전체길이
//         int S = Integer.parseInt(st.nextToken());
// // 부분길이
//         int P = Integer.parseInt(st.nextToken());

//         char[] A = new char[S];
//         checkArr = new int[4];
//         myArr = new int[4];
//         checkSecret = 0;
//         int result = 0;
// //입력값
//         A = br.readLine().toCharArray();

//         st = new StringTokenizer(br.readLine());

//         for (int i = 0; i < 4; i++) {
//             checkArr[i] = Integer.parseInt(st.nextToken());
//             if (checkArr[i] == 0) checkSecret++;
//         }
// // 맨처음 0부터 p까지 비번 입력
//         for (int i = 0; i < P; i++) {
//             Add(A[i]);
//         }
//         if (checkSecret == 4) {
//             result++;
//         }

//         for (int i = P; i < S; i++){
//             int j = i - P;
//             Add(A[i]);
//             Remove(A[j]);
//             if (checkSecret == 4) {
//                 result++;
//             }
//         }

//         System.out.println(result);
//         br.close();


//     }

//     private static void Add(char c) {
//         switch (c) {
//             case 'A' :
//                 myArr[0]++;
//                 if (myArr[0] == checkArr[0])
//                     checkSecret++;
//                 break;
//             case 'C' :
//                 myArr[1]++;
//                 if (myArr[1] == checkArr[1])
//                     checkSecret++;
//                 break;

//             case 'G' :
//                 myArr[2]++;
//                 if (myArr[2] == checkArr[2])
//                     checkSecret++;
//                 break;
//             case 'T' :
//                 myArr[3]++;
//                 if (myArr[3] == checkArr[3])
//                     checkSecret++;
//                 break;
//         }
//     }

//     private static void Remove(char c) {
//         switch (c) {
//             case 'A' :
//                 if (myArr[0] == checkArr[0])
//                     checkSecret--;
//                 myArr[0]--;
//                 break;

//             case 'C' :
//                 if (myArr[1] == checkArr[1])
//                     checkSecret--;
//                 myArr[1]--;
//                 break;

//             case 'G' :
//                 if (myArr[2] == checkArr[2])
//                     checkSecret--;
//                 myArr[2]--;
//                 break;

//             case 'T' :
//                 if (myArr[3] == checkArr[3])
//                     checkSecret--;
//                 myArr[3]--;
//                 break;
//         }
//     }
// }

