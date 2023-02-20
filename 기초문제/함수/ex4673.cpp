#include <iostream>
using namespace std;
void selfnum(){
    int checkarray[10002]={0};
    int num=1;
    while(num<=10000){
        
        //version1
        // int newnum;
        // if(num<10){
        //     newnum = num*2;
        // }
        // else if(num<100){
        //     newnum = num+num/10+num%10;
        // }
        // else if(num<1000){
        //     newnum = num+num/100+num%100/10+num%100%10;
        // }
        // else if(num<=10000){
        //     newnum = num+num/1000+num%1000/100+num%1000%100/10+num%1000%100%10;
        // }
        // if(newnum<=10000)checkarray[newnum]++;


        //version2
        int testnum=num;
        int sum = num;
        while(testnum!=0){
            sum = sum+testnum%10;
            testnum/=10;
        }
        if(sum<=10000)checkarray[sum]++;
        num++;
    }
    for(int i=1;i<10001;i++){
        if(checkarray[i]==0)cout<<i<<"\n";
    }
}
int main(){
    selfnum();
}