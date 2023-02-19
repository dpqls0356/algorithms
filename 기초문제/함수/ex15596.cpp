#include <iostream>
//<vector>추가해주기
#include <vector>
using namespace std;
long long sum(vector<int> &a);
int main(){
    long long size;
    cin >>size;
    // 사이즈 지정
    vector<int> array(size);
    for(long long i=0;i<size;i++)cin>>array[i];
    long long numsum = sum(array);
    cout<<numsum;
    // push,pop,size,at등의 관련 함수가 존재
}
long long sum(vector<int> &a){
    long long ans = 0;
    for(long long i=0;i<a.size();i++)ans+=a.at(i);
    return ans;
}