import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int sour[];
    static int bitter[];
    static int minSub = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sour = new int[N + 1];
        bitter = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N + 1; i++) {
            int sumSour = 1;
            int sumBitter = 0;
            int sub = Math.abs(sour[i] * sumSour - bitter[i] + sumBitter);
            if (sub < minSub)
                minSub = sub;
            // System.out.print("start : " + i + " ");
            re(i + 1, sour[i] * sumSour, bitter[i] + sumBitter);
        }
        System.out.println(minSub);
    }

    public static void re(int cnt, int sumSour, int sumBitter) {
        // 모든 원소를 고려한 경우
        if (cnt > N) {
            int sub = Math.abs(sumBitter - sumSour);
            if (minSub > sub)
                minSub = sub;
        } else {
            //System.out.print(cnt + " ");
            re(cnt + 1, sumSour, sumBitter);// 자기를 포함하지않을때
            //System.out.println();
            re(cnt + 1, sumSour * sour[cnt], sumBitter + bitter[cnt]);// 자기를 포함할때
        }
    }
}
