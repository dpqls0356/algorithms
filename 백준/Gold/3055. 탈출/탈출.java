import java.io.*;
import java.util.*;

public class Main {
	 static char map[][]; // 숲 지도
	    static int R, C; // 숲 크기
	    static boolean visited[][]; // 이동한 지역 or 물이 찬 지역 or 가지 못하는 곳
	    static int destinationX, destinationY; // 도착지점 위치
	    static Queue<int[]> sQue = new LinkedList<>(); //고슴도치 위치
	    static Queue<int[]> waterQue = new LinkedList<>(); //물의 위치
	    static int dx[] = {0,1,0,-1};
	    static int dy[] = {1,0,-1,0};
	    
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        R = Integer.parseInt(st.nextToken());
	        C = Integer.parseInt(st.nextToken());
	        map = new char[R][C];
	        visited = new boolean[R][C];
	        for (int i = 0; i < R; i++) {
	            String row = br.readLine();
	            for (int k = 0; k < C; k++) {
	                map[i][k] = row.charAt(k);
	                //물일때 -> visited true = 어차피 못가는 곳이니까 방문했다고 가정
	                if (map[i][k] == '*') {
	                	visited[i][k] = true;
	                	waterQue.add(new int[] {i,k});
	                }
	                //돌일때 -> visited true = 어차피 못가는 곳이니까 방문했다고 가정
	                if(map[i][k] == 'X')
	                	visited[i][k]=true;
	                //도착지
	                if (map[i][k] == 'D') {
	                    destinationX = i;
	                    destinationY = k;
	                }
	                //고슴도치 위치
	                if (map[i][k] == 'S') {
	                	sQue.add(new int[] {i,k,0});
	                    visited[i][k]=true;
	                }
	            }
	        }
	        
	        BFS();
	        
	    }
	    public static void BFS() {
	    	flowWater();
	    	int size = sQue.size();
	    	
	    	while(!sQue.isEmpty()) {
	    		int cur[] = sQue.poll();
	    		int curX = cur[0];
	    		int curY = cur[1];
	    		int time = cur[2];
	    		//고슴도치 이동시킬 위치 찾기
	    		for(int i=0;i<4;i++) {
	    			int x = curX+dx[i];
	    			int y = curY+dy[i];
	    			if((x<R&&x>=0&&y<C&&y>=0)&&!visited[x][y]&&(map[x][y]=='.'||map[x][y]=='D')) {
	    				sQue.add(new int[] {x,y,time+1});
	    				visited[x][y] = true;
	    				if(x==destinationX&&y==destinationY) {
	    					System.out.println(time+1);
	    					return ;
	    				}
	    			}
	    		}
	    		if(sQue.peek()!=null&&time!=sQue.peek()[2]) {
	    			flowWater();
	    		}
	    		
	    	}
	    	System.out.println("KAKTUS");
	    	
	    }
	    
	    public static void flowWater() {
	    	int size= waterQue.size();
	    	for(int i=0;i<size;i++) {
	    		int water[]  = waterQue.poll();//0이 x 1이 y
	    		for(int k=0;k<4;k++) {
    				int x = water[0]+dx[k];
    				int y = water[1]+dy[k];
    				if((x<R&&x>=0&&y<C&&y>=0)&&(map[x][y]=='.')) {
    					map[x][y]='*';
    					visited[x][y]=true;
    					waterQue.add(new int[] {x,y});
    				}
	    		}
	    	}
	    }

}