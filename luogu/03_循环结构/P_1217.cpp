#include<iostream> 
#include<algorithm>
#include<cmath>
using namespace std;
int main(){
	int a, b;
	cin >> a >> b;
	for( ; a <= b; a++){
		int i;
		int temp = a;
		int reverse = 0;
		while(temp > 0){
			reverse = reverse * 10 + temp % 10;
			temp = temp / 10;
		} 
		if (a != reverse){
			continue;
		}
		int sqrt_a = sqrt(double(a));
		for (i = 2; i <= sqrt_a; i++){
			if (a % i == 0){
				break;
			}
		}
		if (i > sqrt_a){
			cout << a <<endl;
		}
	}
}
