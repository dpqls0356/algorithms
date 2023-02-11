#include <iostream>
using namespace std;

int main(){
    int a,b;
    cin >> a >>b;
    //fixed 소수점 아래 값을 고정
    cout<<fixed;
    //자리수 설정
    cout.precision(9);
    cout<< (double)a/b;
}