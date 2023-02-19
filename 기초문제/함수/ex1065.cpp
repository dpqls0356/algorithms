#include <iostream>
#include <cstdlib>
using namespace std;
int main(){
    //수 개수
    int size;
    cin>>size;
    //한수 개수
    int count =0;
    for(int i=1;i<=size;i++){
        //한수인지 아닌지 판단될 수
        int num=i;
        //한수라면 true 아니라면 false
        bool han = true;
        //가장 끝자리와 그 앞자리의 차
        int cha=num%100/10-num%10;
        //99까지는 무조건 한수
        if(num<100)han=true;
        else{
            cout<<num<<" ";
            // num이 0이 아닐 때까지 돌리면 111의 경우 num이 111일때(차 0) 11일때(차 0) 1일때를(차 -1) 비교해 문제 발생
            while(num>9){
                cout <<"change num: " << num<<" ";
                cout<<"cha:" <<cha<<" "<<num%100/10-num%10<<" |";
                if(num%100/10-num%10!=cha){
                    han=false;
                    break;
                }
                num/=10;
            }
            cout<<"\n";
        }
        if(han==true){
            count++;
            cout<<count<<": "<<i<<"\n";
            }

    }
    cout<<count;
}
