#include <iostream>
#include <string>
using namespace std;
int main(){
    string word;
    getline(cin,word);
    int count=0;
    for(int i=0;i<word.length();i++)if((word[i]!=' '&&(word[i+1]==' '||i+1==word.length())))count++;
    cout<<count;
}