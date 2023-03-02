#include <iostream>
using namespace std;
// 하 그냥 rotate() 쓸 걸 ^^^^^^^^^^^^^^^^^^^^^
int main(){
    int size,testcase;
    int arr[101];
    cin>>size>>testcase;
    for(int i=1;i<size+1;i++)arr[i]=i;

    for(int i=0;i<testcase;i++){
        int begin,mid,end;
        cin>>begin>>end>>mid;
        int rot[101];
        int front=0;
        int behind=0;
        for(int k=0;k<101;k++)rot[k]=arr[k];
        for(int k=0;k<end-begin+1;k++){
            if(begin+k<mid){
                rot[begin+(end-mid+1)+front]=arr[begin+k];
                front++;
            }
            else{
                rot[begin+behind] = arr[begin+k];
                behind++;
            }
        }
        for(int k=begin;k<=end;k++){
            arr[k]=rot[k];
        }
    }
    for(int i=1;i<size+1;i++)cout<<arr[i]<<" ";
}




// int main(){
//     int size,testcase;
//     int arr[101];
//     cin>>size>>testcase;
//     for(int i=1;i<size+1;i++)arr[i]=i;

//     for(int i=0;i<testcase;i++){
//         int begin,mid,end;
//         cin>>begin>>end>>mid;
//         int rot[101];
//         for(int k=0;k<101;k++)rot[k]=arr[k];
//         int a=0;
//         for(int k=0;k<end-begin+1;k++){
//             // mid전까지는 end-begin자리부터 넣어야함..
//             if(begin+k<mid){
//                 rot[begin+(end-mid+1)+k]=arr[begin+k];
//             }
//             else{
//                 rot[begin+a] = arr[begin+k];
//                 a++;
//             }
//         }
//         for(int k=begin;k<=end;k++){
//             arr[k]=rot[k];
//         }

//     }

//     for(int i=1;i<size+1;i++)cout<<arr[i]<<" ";
// }