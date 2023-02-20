#include <iostream>
using namespace std;
int main(){
    int casesize;
    cin>>casesize;
    int count=casesize;

    for(int i=0;i<casesize;i++){
        string word;

        int arr[26];
        fill_n(arr,26,1);

        cin>>word;

        char w=word[0];
        //이미 나온 숫자가 아니고(0) 이전 글자와 일치하는지 안하는지 판단
        for(int k=1;k<word.length();k++){
            if(arr[word[k]-'a']!=0){
                if(word[k]==w){
                arr[word[k]-'a']++;
                }
                else if(word[k]!=w){
                    arr[w-'a']=0;
                    w =word[k];
                }
            }
            else {
                count--;
                break;
            }
        }

    }
    cout<<count;
}