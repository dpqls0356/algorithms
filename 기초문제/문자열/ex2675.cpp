#include <iostream>
using namespace std;
int main(){
    int casesize;
    cin>>casesize;
    string *strbox = new string[casesize];
    for(int i=0;i<casesize;i++){
        int repeatsize;
        cin>>repeatsize;
        string word;
        cin>>word;
        string makingword="";
        for(int k= 0; k<word.length();k++){
            for(int j=0;j<repeatsize ;j++){
                makingword +=word[k];
            }
        }
        strbox[i]=makingword;
    }
    for(int l=0;l<casesize;l++){
        cout<<strbox[l]<<"\n";
    }
}