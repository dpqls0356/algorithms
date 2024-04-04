import java.io.*;
import java.util.*;

public class Solution {
	static int count; // 활주로 수
	static int arr[][]; // 지도
	static int N; // 지도 크기
	static int len; // 경사로 길이

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			count = 0;

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			len = Integer.parseInt(st.nextToken());

			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					arr[i][k] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				if (checkedRow(i)) { // i행 검사
//					System.out.println("\n"+i+"행");
					count++;
				}
				if (checkedCol(i)) {// i열 검사
//					System.out.println(i+"열");
					count++;
				}
			}

			System.out.println("#" + t + " " + count);
		}
	}

	public static boolean checkedRow(int fix) {
		boolean used[][] = new boolean[N][N]; // 이미 경사로로 사용된 곳
		for (int k = 0; k < N; k++) {
//			System.out.print(arr[fix][k]+" ");
			if (k - 1 >= 0 && arr[fix][k] != arr[fix][k - 1]) { // 이전 높이와 현재 높이가 다른 경우
				if (Math.abs(arr[fix][k] - arr[fix][k - 1]) == 1) {
					if (arr[fix][k - 1] < arr[fix][k]) { // 왼쪽이 작은 경우
						for (int i = 0; i < len; i++) {
							if (k - 1 - i >= 0 && arr[fix][k - 1 - i] == arr[fix][k - 1] && !used[fix][k - 1 - i]) {
								used[fix][k - 1 - i] = true;
							} else {
//							System.out.println("왼쪽"+fix+" "+(k-1-i));
								return false;
							}
						}
					} else {// 오른쪽이 작은 경우
						for (int i = 0; i < len; i++) {
							if (k + i < N && arr[fix][k + i] == arr[fix][k] && !used[fix][k + i]) {
								used[fix][k + i] = true;
							} else {
//							System.out.println("오른쪽"+fix+" "+(k+i));
								return false;
							}
						}
					}
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean checkedCol(int fix) {
		boolean used[][] = new boolean[N][N];
		for (int k = 0; k < N; k++) {
//			System.out.print(arr[k][fix]+" ");
			if (k - 1 >= 0 && arr[k][fix] != arr[k - 1][fix]) {// 이전 높이와 현재 높이가 다른 경우
				if (Math.abs(arr[k][fix] - arr[k - 1][fix]) == 1) {
					if (arr[k - 1][fix] < arr[k][fix]) { // 위쪽이 낮은 경우
						for (int i = 0; i < len; i++) {
							if (k - 1 - i >= 0 && arr[k - 1 - i][fix] == arr[k - 1][fix] && !used[k - 1 - i][fix]) {
								used[k - 1 - i][fix] = true;
							} else {
//							System.out.println("왼쪽"+fix+" "+(k-1-i));
								return false;
							}
						}
					} else {
						for (int i = 0; i < len; i++) {
							if (k + i < N && arr[k + i][fix] == arr[k][fix] && !used[k + i][fix]) {
								used[k + i][fix] = true;
							} else {
//							System.out.println("오른쪽"+fix+" "+(k+i));
								return false;
							}
						}
					}

				}
				else {
					return false;
				}
			}
		}
		return true;
	}
}