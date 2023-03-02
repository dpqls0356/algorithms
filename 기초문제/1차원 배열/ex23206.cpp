#include <iostream>
using namespace std;
class Subjectinfo{
public:
    string subjectname;
    double score;
    string grade;
    void setsubjectinfo(string isubjectname,double iscore,string igrade){
        subjectname = isubjectname;
        score = iscore;
        grade = igrade;
    }
};
int main(){
    int size=20;
    Subjectinfo subjectinfo[20];
    for(int i=0;i<size;i++){
        string subjectname;
        double score;
        string grade;
        cin>>subjectname>>score>>grade;
        subjectinfo[i].setsubjectinfo(subjectname,score,grade);
    }
    double sum =0;
    double sumscore=0;
    for(int i=0;i<size;i++){
        if(subjectinfo[i].grade=="P")continue;
        else sumscore+=subjectinfo[i].score;

        if(subjectinfo[i].grade=="A+")sum+=(4.5*subjectinfo[i].score);
        else if(subjectinfo[i].grade=="A0")sum+=(4*subjectinfo[i].score);
        else if(subjectinfo[i].grade=="B+")sum+=(3.5*subjectinfo[i].score);
        else if(subjectinfo[i].grade=="B0")sum+=(3*subjectinfo[i].score);
        else if(subjectinfo[i].grade=="C+")sum+=(2.5*subjectinfo[i].score);
        else if(subjectinfo[i].grade=="C0")sum+=(2*subjectinfo[i].score);
        else if(subjectinfo[i].grade=="D+")sum+=(1.5*subjectinfo[i].score);
        else if(subjectinfo[i].grade=="D0")sum+=(1*subjectinfo[i].score);
        else sum+=(0*subjectinfo[i].score);
    }
    cout<<sum/sumscore;
}