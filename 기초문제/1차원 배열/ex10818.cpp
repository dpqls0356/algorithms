#include <iostream>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    int size;
    cin >>size;
    int *array = new int[size];
    for(int i= 0; i<size;i++)cin>>array[i];
    int min =array[0],max = array[0];
    for(int k=0;k<size;k++){
        if(min >array[k])min=array[k];
        if(max<array[k])max=array[k];
    }
    cout<<min<<" "<<max;

}