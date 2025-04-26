#include <stdio.h>

int max(int a, int b) {
    return a > b ? a : b;
}

int main() {
    int N;
    scanf("%d", &N);
    
    int T[16]; // 상담에 걸리는 시간
    int P[16]; // 상담 수익
    int dp[17] = {0}; // dp[i]: i일부터 시작했을 때 얻을 수 있는 최대 수익
    
    // 입력 받기
    for (int i = 1; i <= N; i++) {
        scanf("%d %d", &T[i], &P[i]);
    }
    
    // 뒤에서부터 DP 계산
    for (int i = N; i >= 1; i--) {
        // 상담이 끝나는 날이 퇴사일을 넘어가는 경우
        if (i + T[i] > N + 1) {
            dp[i] = dp[i + 1];
        } 
        // 상담이 가능한 경우
        else {
            dp[i] = max(dp[i + 1], P[i] + dp[i + T[i]]);
        }
    }
    
    printf("%d\n", dp[1]);
    
    return 0;
}