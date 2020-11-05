#include<iostream>
#include<cmath>
#include<cstdio> 
#include<algorithm>
using namespace std;
// https://www.luogu.com.cn/problem/P1257

// 坐标
struct Point{
    int x;
    int y;
};


// 快速排序
int findMid(Point point[], int begin, int end){
    Point temp = point[begin];
    end--;
    while(begin < end) {
        while(begin < end) {
            if (point[end].x >= temp.x) {
                end--;
            } else {
                point[begin] = point[end];
                begin++;
                break;
            }
        }
        while(begin < end) {
            if (point[begin].x <= temp.x) {
                begin++;
            } else {
                point[end] = point[begin];
                end--;
                break;
            }
        }
    }
    point[begin] = temp;
    return begin;
}
void quickSort(Point point[], int begin, int end) {
    if (end - begin < 2) {
        return;
    }
    int mid = findMid(point, begin, end);
    quickSort(point, begin, mid);
    quickSort(point, mid + 1, end);
}

// 两点距离
double distance(Point p1, Point p2) {
    return sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
}

// 最短距离
double minDistance(Point point[], int begin, int end){
    if (end - begin <= 3) {
        double min = -1;
        for(int i = begin; i < end - 1; i++){
            for(int j = i+1; j < end; j++){
                double d = distance(point[i], point[j]);
                if(min > d || min == -1) {
                    min = d;
                }
            }
        }
        return min;
    }
    int mid = (begin + end - 1) >> 1;
    double left = minDistance(point, begin, mid + 1);
    double right = minDistance(point, mid, end);
    double min = left - right < 0 ? left : right;
    for(int i = mid + 1; (point[i].x - point[mid].x) < min && (point[i].y - point[mid].y) < min; i++){
        if (min > distance(point[mid], point[i])) {
            min = distance(point[mid], point[i]);
        }
    }
    return min;
}

bool sortRule(Point p1, Point p2) {
	if(p1.x != p2.x) {
		return p1.x < p2.x;
	}
	return p1.y < p2.y;
}

int main(){
    // n表示点的个数
    int n;
    cin >> n;
    Point *point = new Point[n];
    for(int i = 0; i < n; i++) {
        cin >> point[i].x >> point[i].y;
    }
//    quickSort(point, 0, n);
	sort(point, point+n, sortRule);
    printf("%.4lf", minDistance(point, 0, n));
    return 0;
}
