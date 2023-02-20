#include <iostream>
using namespace std;
int main(){
    string word;
    cin>>word;
    int time=0;
    for(int i=0;i<word.length();i++){
         int place =(int)word[i]-65;
         if(place==24||place==18||place==21)place--;
         else if(place==25)place-=2;
        time +=(3+place/3);      
    }
    cout<<time;
}