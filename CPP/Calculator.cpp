#include <iostream>
using  namespace std;

int main(){

    char oprd;
    float num1, num2;

    cout << "Choose and Operation ( *, /, +, -): ";
    cin >> oprd;

    cout << "Enter two numbers: ";
    cin >> num1 >> num2;

    switch (oprd)  
    {
        case '+':
            cout << num1+num2;
            break;

        case '-':
            cout << num1-num2;
            break;

        case '*':
            cout << num1*num2;
            break;

        case '/':
            cout << num1/num2;
            break;

        default:
            // If the operator is other than +, -, * or /, error message is shown
            cout << "Error! operator is not correct";
            break;
    }

    return 0;
}