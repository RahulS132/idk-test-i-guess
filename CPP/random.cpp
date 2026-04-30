//
#include <iostream>
using namespace std;

int main(){
    long long n, m;       // declare n and m
    cin >> n >> m;
    long long x = 1;
    for (int i = 2; i <= n; i++) {
        x = (x*i)%m;
    }
    cout << x%m << "\n";
    return 0;
}