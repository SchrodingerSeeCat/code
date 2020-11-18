#include<iostream>
using namespace std;
int main(){
	int n, x;
	int count = 0;
	cin >> n >> x;
	for (int i = 1; i <= n; i++){
		int temp = i;
		for (;temp != 0;){
			if (temp % 10 == x) {
				count += 1;
			}
			temp = temp / 10;
		}
	}
	cout << count << endl;
}
