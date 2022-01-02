// WAP to calculate the volume of a sphere
#include <iostream>
#include <cmath>
using namespace std;
int main(){
    double rad{0};
    double volume{0};
    double cube{0};
    const double pie{3.14159};

    cout << "Enter the radius of the sphere: ";
    cin >> rad;
    cube = rad * rad * rad;
    volume = {4 * pie * cube / 3};

    cout << "The Volume of the sphere is: " << volume << endl;

    return 0;
}