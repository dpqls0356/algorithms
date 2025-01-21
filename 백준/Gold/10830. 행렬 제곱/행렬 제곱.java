import java.util.*;
import java.io.*;
public class Main {
    private static long[][] inputArr;
    private static int size;
    private static final int MOD = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        long exponent = Long.parseLong(st.nextToken());

        inputArr = new long[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                inputArr[i][j] = Long.parseLong(st.nextToken()) % MOD;
            }
        }

        long[][] resultArr = power(inputArr, exponent);
        printMatrix(resultArr);
    }

    public static long[][] power(long[][] matrix, long exp) {
        if (exp == 1) {
            return matrix;
        }

        long[][] halfPower = power(matrix, exp / 2);
        long[][] result = multiply(halfPower, halfPower);

        if (exp % 2 != 0) {
            result = multiply(result, inputArr);
        }
        return result;
    }

    public static long[][] multiply(long[][] matrix1, long[][] matrix2) {
        long[][] result = new long[size][size];

        // A행렬 * B행렬
        for (int i = 0; i < size; i++) { //A행렬의 행수 
            for (int j = 0; j < size; j++) { // A행렬의 열수 
                for (int k = 0; k < size; k++) { // B행렬의 열수 
                    result[i][j] += (matrix1[i][k] * matrix2[k][j]) % MOD;
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }

    public static void printMatrix(long[][] matrix) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
