#include <iostream>
#include <string>
#include <stdlib.h>
using namespace std;
int main(){
    int size;
    cin >> size;
    string num;
    cin >> num;
    int sum=0;
    for(int i=0;i<size;i++){
        sum+=(int)(num[i])-48;
    }
    cout<<sum<<"\n";
}