#include<iostream>
using namespace std;
class Equation {

    static const int LESS = 0;
    static const int GREATER = 1;
    int ar[2];
    int limit;
    int type;

    public Equation(int limit, int x1, int x2=0, int type=LESS) {
        ar[0] = x1;
        ar[1] = x2;
        this->limit = limit;
        this->type = type;
    }

    int getCoef(int i) {
        return ar[i];
    }

    void display() {
        cout<<ar[0]<<"x1 + "<<ar[1]<<"x2";
        cout<<limit<<endl;
    }
};
int main() {

    int n;
    cout<<"How many equations do you have ? :";
    cin>>n;
    Equation **eq = new Equation*[n];

    for(int i=0; i<n; i++) {
        int limit, x1, x2, type;
        cout<<"Enter limit for equation "<<i+1<<" :";
        cin>>limit;
        cout<<"Enter coefficient of x1 :";
        cin>>x1;
        cout<<"Enter coefficient of x2 :";
        cin>>x2;
        cout<<"Enter type of equation (0 for max, 1 for min) :";
        cin>>type;
        eq[i] = new Equation(limit, x1, x2, type);
    }
}