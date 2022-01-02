// WAP to convert temperatures
#include <iostream>
using namespace std;
int main(){
    char opt{};
    double temp{}, ans{}, c_k{273.15}, f_c{17.77778}, f_k{255.3722}, k_f{459.67};
    int c_f{32};

    cout << "Enter a operation:  \na. C-F  \nb. C-K  \nc. F-C  \nd. F-K  \ne. K-C  \nf. K-F\n= ";
    cin >> opt;

    switch(opt){
        case 'a': //c-f  -- 1c-33.8f -- 1.8 difference
            cout << "Enter the Temp: ";
            cin >> temp;
            ans = (temp * 1.8) + c_f;
            cout << temp << "C in F is = " << ans;
            break;
        case 'b': //c-k -- 1c-274.15k -- 1 diff
            cout << "Enter the Temp: ";
            cin >> temp;
            ans = temp + c_k;
            cout << "C in K is = " << ans;
            break;
        case 'c': //f-c -- 1f--17.22222c -- 0.55556 diff
            cout << "Enter the Temp: ";
            cin >> temp;
            ans = (temp * 0.55556) + (0-f_c);
            cout << temp << "F in C is = " << ans;            
            break;
        case 'd': //f-k -- 1f-255.9278k -- 0.5556 diff
            cout << "Enter the Temp: ";
            cin >> temp;
            ans = (temp * 0.55556) + f_k;
            cout << temp << "F in K is = " << ans;            
            break;
        case 'e': // k-c -- 1k--272.15c -- 1diff
            cout << "Enter the Temp: ";
            cin >> temp;
            ans = temp - c_k;
            cout << temp << "k in c is = " << ans;   
            break;
        case 'f': // k-f -- 1k--457.87f -- 1.8 diff
            cout << "Enter the Temp: ";
            cin >> temp;
            ans = (temp * 1.8) + (0 - 459.67);
            cout << temp << "k in f is = " << ans;  
            break;
        default:
            cout << "Enter a proper option";
            break;
    }
    return 0;
}