#include <iostream>
using namespace std;

int main(){
    int a,b;
    cin>> a>>b;
    cout <<a*((b%100)%10)<<endl<<a*((b%100)/10)<<endl<<a*(b/100)<<a*b;
}