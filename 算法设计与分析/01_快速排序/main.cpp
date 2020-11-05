#include<iostream>
using namespace std;
int findMid(int array[], int begin, int end){
    int temp = array[begin];
    end--;
    while(begin < end) {
        while(begin < end) {
            if (array[end] >= temp) {
                end--;
            } else {
                array[begin] = array[end];
                begin++;
                break;
            }
        }
        while(begin < end) {
            if (array[begin] <= temp) {
                begin++;
            } else {
                array[end] = array[begin];
                end--;
                break;
            }
        }
    }
    array[begin] = temp;
    return begin;
}
void quickSort(int array[], int begin, int end) {
    if (end - begin < 2) {
        return;
    }
    int mid = findMid(array, begin, end);
    quickSort(array, begin, mid);
    quickSort(array, mid + 1, end);
}

int main(){
    int array[] = {1, 5, 9, 3, 7, 4, 8, 6, 0, 2};
    quickSort(array, 0, 10);
    for(int i = 0; i < 10; i++){
        cout << array[i] << " ";
    }
    return 0;
}