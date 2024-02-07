import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int myChew = Integer.parseInt(st.nextToken());
            int index = 1;
            Queue<Integer[]> que = new LinkedList<Integer[]>();
            Integer[] arr = { index, 0 };
            que.add(arr);
            while (myChew > 0) {
                Integer[] pollArr = que.poll();
                pollArr[1] = pollArr[1] + 1;
                myChew -= pollArr[1];
                if (myChew <= 0) {
                    System.out.println("#" + i + " " + (pollArr[0]));
                    break;
                }
                que.add(pollArr);
                index++;
                Integer[] newArr = { index, 0 };
                que.add(newArr);
            }
        }
    }
}
