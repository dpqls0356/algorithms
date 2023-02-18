#include <iostream>
#include <string>
// 동적할당 int *name = new int [size];
// 문자 배열로 받을 때 char 배열 + cin.getline(배열명,길이,마지막문자)
// 문자열로 받을 때(공백포함) string + getline(cin,배열명)
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    int size;
    cin>>size;
    int *array = new int[size];
    for(int i=0;i<size;i++){
       string ans;
       cin>>ans;
       int count =0;
       for(int k = 0;k<ans.length();k++){
        if(ans[k]=='O'){
            count++;
            array[i]+=count;
        }
        else count=0;
       }
    }
    for(int j=0;j<size;j++)cout<<array[j]<<'\n';
}