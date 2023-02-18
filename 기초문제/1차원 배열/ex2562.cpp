#include <iostream>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    int size=9;
    int num =0;
    int *array = new int[size];
    for(int i= 0; i<size;i++)cin>>array[i];
    int max = array[0];
    for(int k=0;k<size;k++){
        if(max<array[k]){
            max=array[k];
            num = k;}
    }
    cout<<max<<"\n"<<num+1;

}