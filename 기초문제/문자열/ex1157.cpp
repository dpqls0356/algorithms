#include <iostream>
using namespace std;
int main(){
    string word;
    cin>>word;
    int arr[26]={0,};
    for(int i=0;i<word.length();i++){
        for(int k=0;k<26;k++){
            if((int)word[i]==k+97||(int)word[i]==k+65)arr[k]++;
        }
    }
    int bigger=arr[0];
    for(int j=0;j<26;j++)if(bigger<arr[j])bigger=arr[j];
    
    int count=0;
    int place=0;
    for(int o=0;o<26;o++){
        if(arr[o]==bigger){
            count++;
            place = o;
        }
    }
    //배열중에 bigger의 수를 가진 요소 개수 찾기까지 완성
    if(count>1)cout<<"?";
    else cout<<(char)(place+65);
    
}