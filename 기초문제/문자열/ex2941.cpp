#include <iostream>
using namespace std;
int main(){
    string word;
    cin>>word;
    int count=0;
    for(int i=0;i<word.length();i++){
        if(word[i]=='c'){
            if(word[i+1]=='='||word[i+1]=='-'){
                count++;
                i++;
                continue;
            }
        }
        else if(word[i]=='d'){
            if(word[i+1]=='z'&&word[i+2]=='='){
                count++;
                i+=2;
                continue;
            }
            else if(word[i+1]=='-'){
                count++;
                i++;
                continue;
            }
        }
        else if(word[i]=='l'||word[i]=='n'){
            if(word[i+1]=='j'){
                count++;
                i++;
                continue;
            }
        }
        else if(word[i]=='s'||word[i]=='z'){
            if(word[i+1]=='='){
                count++;
                i++;
                continue;
            }
        }
       count++;
    }
    cout<<count;
}