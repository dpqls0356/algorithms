#include <iostream>
using namespace std;

int main(){
    int x;
    cin >> x;
    int ori = x;
    int count = 0;
    while(true){
        count ++;
        if(x<10){
            x = x*10+x;
        }
        else{
        x = (x/10+x%10)%10+x%10*10;
        }
        if(ori==x)break;
    }
    cout<<count;
}