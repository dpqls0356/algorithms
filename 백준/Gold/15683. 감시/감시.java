
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N; // 공간 크기
    static int M; // 공간 크기
    static int space[][]; // 공간 정보를 담을 배열
    static int minSpace; // 최소 사각지대 수
    static ArrayList<int[]> camera = new ArrayList<int[]>(); // 카메라 위치넣기

public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    // 공간의 크기 입력 받기
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    space = new int[N][M];
	    minSpace = N * M; // 모든 공간이 사각지대라고 가정
	    for (int i = 0; i < N; i++) {
	        st = new StringTokenizer(br.readLine());
	        for (int k = 0; k < M; k++) {
	            space[i][k] = Integer.parseInt(st.nextToken());
	            // 카메라 위치
	            if (space[i][k] != 6&&space[i][k]!=0)
	                camera.add(new int[] { i, k });
	        }
	    }
//	    System.out.println("-------preview-------");
// 	   for (int i = 0; i < N; i++) {
//	        for (int k = 0; k < M; k++) {
//	            System.out.print(space[i][k] + " ");
//	        }
//	        System.out.println();
//	    }
//	    System.out.println("-------start-------");
	    find(0);
	    System.out.println(minSpace);
	}

	public static void find(int cnt) {
	    // 모든 카메라의 녹화공간을 파악한 경우
	    if (camera.size() == cnt) {
//	    	   for (int i = 0; i < N; i++) {
//	    	        for (int k = 0; k < M; k++) {
//	    	            System.out.print(space[i][k] + " ");
//	    	        }
//	    	        System.out.println();
//	    	    }
//	    	    System.out.println("------------");
	    	//사각지대 개수 세기
	    	int chspace =0;
	    	for(int i=0;i<N;i++) {
	    		for(int k=0;k<M;k++) {
	    			if(space[i][k]==0)chspace++;
	    		}
	    	}
	    	//현재 상태의 사각지대와 최소 사각지대 비교하기
	        if (minSpace > chspace)
	            minSpace = chspace;
	    } else {
	        int cur[] = camera.get(cnt);
	        int row = cur[0];
	        int col = cur[1];
	        int curSpace[][] = new int [N][M];
	        for(int i=0;i<N;i++) {
	        	System.arraycopy(space[i], 0, curSpace[i], 0, space[i].length);
	        }
	        //1번 카메라일 때
	        if(space[row][col]==1) {
	        	//위로 진행 후 find
	        	up(row, col);
				find(cnt+1);
	        	re(curSpace);
	        	//아래로 진행 후 find
	        	down(row,col);
	        		find(cnt+1);
	        	re(curSpace);
	        	//왼쪽으로 진행 후 find
	        	left(row,col);
	        		find(cnt+1);
	        	re(curSpace);
	        	//오른쪽으로 진행 후 find
	        	right(row,col);
	        	find(cnt+1);
	        	re(curSpace);
	        }
	        //2번 카메라일 때
	        else if(space[row][col]==2) {
	        	//상하
	        	up(row,col);
	        	down(row,col);
	        	find(cnt+1);
	        	re(curSpace);
	        	//좌우
	        	left(row,col);
	        	right(row,col);
	        	find(cnt+1);
	        	re(curSpace);
	        }
	        else if(space[row][col]==3) {
	        	//상우
	        	up(row,col);
	        	right(row,col);
	        	find(cnt+1);
	        	re(curSpace);
	        	//우하
	        	right(row, col);
	        	down(row, col);
	        	find(cnt+1);
	        	re(curSpace);
	        	//하좌
	        	down(row,col);
	        	left(row,col);
	        	find(cnt+1);
	        	re(curSpace);
	        	//좌상
	        	left(row, col);
	        	up(row, col);
	        	find(cnt+1);
	        	re(curSpace);

	        }
	        else if(space[row][col]==4) {
	        	//좌상우
	        	left(row, col);
	        	up(row, col);
	        	right(row, col);
	        	find(cnt+1);
	        	re(curSpace);
	        	//상우하
	        	up(row, col);
	        	right(row, col);
	        	down(row,col);
	        	find(cnt+1);
	        	re(curSpace);
	        	//우하좌
	        	right(row, col);
	        	down(row,col);
	        	left(row, col);
	        	find(cnt+1);
	        	re(curSpace);
	        	//하좌상	        	
	        	down(row,col);
	        	left(row, col);
	        	up(row, col);
	        	find(cnt+1);
	        	re(curSpace);
	        }
	        else if(space[row][col]==5) {
	        	up(row,col);
	        	down(row, col);
	        	left(row, col);
	        	right(row, col);
	        	find(cnt+1);
	        	re(curSpace);
	        }

	    } 
	}
	static void re(int curSpace[][]) {
        for(int i=0;i<N;i++) {
        	System.arraycopy(curSpace[i], 0, space[i], 0, space[i].length);
        }
	}
	static void up(int row,int col) {
		for(int i = row-1;i>=0;i--) {
			if(space[i][col]==6)break;
			if(space[i][col]==0)space[i][col] = 7;
		}
	}
	static void down(int row,int col) {
		for(int i=row+1;i<N;i++) {
			if(space[i][col]==6)break;
			if(space[i][col]==0)space[i][col] = 7;
		}
	}
	static void right(int row,int col) {
		for(int i=col+1;i<M;i++) {
			if(space[row][i]==6)break;
			if(space[row][i]==0)space[row][i] = 7;
		}
	}
	static void left(int row,int col) {
		for(int i=col-1;i>=0;i--) {
			if(space[row][i]==6)break;
			if(space[row][i]==0)space[row][i] = 7;
		}
	}
}