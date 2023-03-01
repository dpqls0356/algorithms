#include <iostream>
using namespace std;

int main()
{
    int array[101];
    int size,findnum;
    int count=0;
    cin >>size;
    for(int i= 0; i<size;i++)cin>>array[i];
    cin >>findnum;
    for(int k=0;k<size;k++){
        if(findnum==array[k])count++;
    }
    cout <<count;
}