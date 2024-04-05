import java.io.*;
import java.util.*;

public class Solution {

	static int N, topHeight;
	static int heights[];
	static int min;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			topHeight = Integer.parseInt(st.nextToken());

			heights = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;
			Cal(0, 0);

			System.out.println("#" + t + " " + min);

		}
	}

	public static void Cal(int len, int cur) {
		if (len == N) {
//			System.out.println(Math.abs(cur - topHeight));
			if (Math.abs(cur - topHeight) < min&&cur>=topHeight)
				min = Math.abs(cur - topHeight);
		} else {
			Cal(len + 1, cur + heights[len]);
			Cal(len + 1, cur);
		}
	}
}