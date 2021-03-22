#include <iostream>
#include <map>

#define MaxSize 50 // 定义线性表的最大长度
typedef struct {
    int data[MaxSize]; // 顺序表的元素
    int length; // 顺序表的当前长度
} SqList;
using namespace std;

// 1.删除最小的值
int deleteMin(SqList &list) {
    if(list.length == 0) {
        throw "表为空";
    }
    int* min = nullptr;
    int index = -1;
    for(int i = 0; i < list.length; i++) {
        if(min == nullptr || *min > list.data[i]) {
            if(min == nullptr) {
                min = new int;
            }
            *min = list.data[i];
            index = i;
        }
    }
    list.data[index] = list.data[list.length - 1];
    list.length--;

    int result = *min;
    delete min;
    return result;
}

// 2.反转数组
void transformation(SqList &list) {
    int temp = 0;
    for(int i = 0, j = list.length - 1; i < j ; i++, j--) {
        temp = list.data[i];
        list.data[i] = list.data[j];
        list.data[j] = temp;
    }
}

// 3.删除为x的数据元素
void deleteX(SqList &list, int x) {
    int k = 0;
    for(int i = 0; i < list.length; i++) {
        if(list.data[i] != x) {
            list.data[k++] = list.data[i];
        }
    }
    list.length = k;
}

// 4.5.删除 s -> t的所有元素
bool delete_s_t(SqList &list, int s, int t) {
    if(s >= t) return false;
    if(list.length == 0) return false;

    int k = 0;
    for(int i = 0; i < list.length; i++) {
        if(list.data[i] <= s || list.data[i] >= t) {
            list.data[k++] = list.data[i];
        }
    }
    list.length = k;
    return true;
}

// 6.去重
void unrepeated(SqList &list) {
    int k = 1;
    for(int i = 1; i < list.length; i++) {
        if(list.data[k - 1] != list.data[i]) {
            list.data[k++] = list.data[i];
        }
    }
    list.length = k;
}

// 7.合并两个有序表，假设升序
SqList merge(SqList &list1, SqList &list2) {
    SqList newList;
    newList.length = list1.length + list2.length;

    int i = 0, j = 0, k = 0;
    for(; i < list1.length && j < list2.length; k++) {
        if(list1.data[i] < list2.data[j]) {
            newList.data[k] = list1.data[i++];
        } else {
            newList.data[k] = list2.data[j++];
        }
    }

    while(i < list1.length) {
        newList.data[k++] = list1.data[i++];
    }

    while(j < list2.length) {
        newList.data[k++] = list2.data[j++];
    }
    return newList;
}

// 8.10交换线性表中的两个子序列
void inversion(SqList &list, int m, int n){
    int temp;
    for(int i = m, j = n; i < j; i++, j--) {
        temp = list.data[i];
        list.data[i] = list.data[j];
        list.data[j] = temp;
    }
}
bool exchange(SqList &list, int m, int n) {
    if(list.length == 0) return false;

    // 首先对整体进行倒置
    inversion(list, 0, list.length - 1);

    // 然后对部分进行倒置
    inversion(list, 0, n -1);
    inversion(list, n, list.length - 1);
    return true;
}

// 9. 在递增的序列中 查找x并与后继元素交换，若找不到则把x插入到序列中
int binary_search(SqList &list, int low, int height, int x) {
    if(low >= height) return -1;

    int mid = (low + height) >> 1;
    if(x < list.data[mid]) {
        return binary_search(list, low, mid, x);
    }
    if(x > list.data[mid]) {
        return binary_search(list, mid + 1, height, x);
    }

    return mid;
}
void find_x(SqList &list, int x) {
    int index = binary_search(list, 0, list.length, x);

    if(index != -1) {
        if(index != list.length - 1) {
            int temp = list.data[index];
            list.data[index] = list.data[index + 1];
            list.data[index + 1] = temp;
        }
        return;
    }

    for(int i = 0; i < list.length - 1; i++) {
        if(x > list.data[i] && x < list.data[i + 1]) {
            for(int j = list.length; j > i; j--) {
                list.data[j] = list.data[j - 1];
            }
            list.data[i + 1] = x;
            list.length++;
            return;
        }
        if(i == 0 && x < list.data[i]) {
            for(int j = list.length; j > 0; j--) {
                list.data[j] = list.data[j - 1];
            }
            list.data[0] = x;
            list.length++;
            return;
        }
    }

    list.data[list.length] = x;
    list.length++;
}

// 11. 找出两个有序序列的中位数
int findMid(SqList &list1, SqList &list2) {

    int total = list1.length + list2.length - 1; // 两个有序序列的总长度

    int index;
    if((list1.length % 2 == 0 && list2.length % 2 == 0) || (list1.length % 2 != 0 && list2.length % 2 != 0)) {
        index = total / 2; // 偶数不向上取整
    } else {
        index = (total / 2.0) + 0.5;
    }

    int i = 0, j = 0;
    while(i < list1.length && j < list2.length) {
        if(list1.data[i] < list2.data[j]) {
            i++;
            if((i + j + 1) == index) {
                return list1.data[i];
            }
        } else if(list1.data[i] >= list2.data[j]){
            j++;
            if((i + j + 1) == index) {
                return list2.data[j];
            }
        }
    }

    if((i + j + 1) < index && i < list1.length) {
        return list1.data[index - j];
    }

    return list2.data[index - i];
}

// 12. 统计每个数字出现的频率
void numCount(int nums[], int length) {
    map<int, int> m;
    for(int i = 0; i < length; i++) {
        if(m.find(nums[i]) != m.end()) {

        } else {
            m.insert(pair<int, int>(nums[i], 0));
        }
    }
}

// 13. 找出一个数组中没有出现的最小正整数
int findMid(SqList &list, int begin, int end) {
    end--;
    int temp = list.data[begin];
    while(begin < end) {
        while(begin < end && list.data[end] > temp) {
            end--;
        }
        while(begin < end && list.data[begin] < temp) {
            begin++;
        }
        if(begin < end) {
            int t = list.data[begin];
            list.data[begin] = list.data[end];
            list.data[end] = t;
        }
    }
    list.data[begin] = temp;
    return begin;
}
void quickSort(SqList &list, int begin, int end) {
    if(begin >= end) return;
    int mid = findMid(list, begin, end);
    quickSort(list, begin, mid);
    quickSort(list, mid + 1, end);
}

//int main() {
//    SqList list1;
//    list1.length = 4;
//
//    list1.data[0] = 4;
//    list1.data[1] = 2;
//    list1.data[2] = 3;
//    list1.data[3] = 1;
//
//    quickSort(list1, 0, list1.length);
//
//    for(int i = 0; i < list1.length; i++) {
//        cout << list1.data[i] << " ";
//    }
//
//    return 0;
//}
