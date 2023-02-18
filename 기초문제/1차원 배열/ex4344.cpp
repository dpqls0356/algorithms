#include <iostream>
using namespace std;

int main(){
    int size;
    cin >> size;
    double *avg = new double[size];
    for(int i=0;i<size;i++){
        int studentsize;
        cin>>studentsize;
        double *studentscore = new double [studentsize];
        double sumscore=0;
        for(int k=0;k<studentsize;k++){
            cin>>studentscore[k];
            sumscore+=studentscore[k];
        }
        double avgscore = sumscore/studentsize;
        int avgstudent=0;
        for(int j=0;j<studentsize;j++){
            if(studentscore[j]>avgscore)avgstudent++;
        }
        avg[i] = avgstudent/(double)studentsize*100;
    }
    cout<<fixed;
    cout.precision(3);
    for(int n=0;n<size;n++){
        cout<<avg[n]<<"%\n";
    }
}