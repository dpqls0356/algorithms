#include <iostream>
using namespace std;

int main(){
    int basic[6] = {1,1,2,2,2,8};
    int current[6]={0};
    for(int i=0 ;i<6;i++){
        cin >> current[i];
    }
     for(int k = 0 ; k<6;k++){
        cout << basic[k] - current[k]<< " ";
    }
}