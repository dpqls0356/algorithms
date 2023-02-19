#include <iostream>
using namespace std;
int main(){
    string word;
    cin>>word;
    int arr[26];
    fill_n(arr,26,-1);
    for(int i=0;i<word.length();i++){
        for(int k =0;k<26;k++){
            if(k+97==int(word[i])&&arr[k]==-1){
                arr[k]=i;
                break;
            }
        }
    }
    for(int j=0;j<26;j++)cout<<arr[j]<<" ";
}
