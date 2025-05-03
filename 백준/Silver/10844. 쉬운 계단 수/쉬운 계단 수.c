#include <stdio.h>

#define MOD 1000000000

int main() {
    int N;
    scanf("%d", &N);

    int dp[101][10] = {0};

    for (int i = 1; i <= 9; i++)
        dp[1][i] = 1;

    for (int i = 2; i <= N; i++) {
        for (int j = 0; j <= 9; j++) {
            if (j > 0) dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;
            if (j < 9) dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MOD;
        }
    }

    int result = 0;
    for (int i = 0; i <= 9; i++)
        result = (result + dp[N][i]) % MOD;

    printf("%d\n", result);
    return 0;
}
