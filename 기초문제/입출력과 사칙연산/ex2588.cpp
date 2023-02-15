#include <iostream>
using namespace std;

int main(){
    int a,b;
    cin>> a>>b;
    cout <<b%10*a<<endl<<(b%100)/10*a<<endl<<b/100*a<<endl<<a*b;
}