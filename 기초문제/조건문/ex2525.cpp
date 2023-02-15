#include <iostream>
using namespace std;

int main(){
    int h,m,t;
    cin >>h>>m>>t;
    int th = t/60;
    int tm = t%60;
    //24시가 넘어가는 경우
    if(h+th>23)h = h+th-24;
    else h = h+th;

    if(tm+m>=60){
        if(h+1>23)h=0;
        else h+=1;
        m = tm+m-60;
    }
    else m+=tm;
    if(m==60)m=0;
    cout <<h<<" "<<m;
}