#include <iostream>
using namespace std;

typedef struct LNode{
    int data;
    struct LNode *next;
}LNode, *LinkList;

// 头插法建立链表
LinkList Link_HeaderInsert(LinkList &l) {
    LNode *s;
    int x;

    l = (LinkList) malloc(sizeof(LNode)); // 创建头节点
    l->next = nullptr; // 初始为空链表
    cin >> x; //输入节点的值
    while(x < 9999) {
        s = (LNode *) malloc(sizeof(LNode)); //创建新的节点

        // 插入新节点
        s->data = x;
        s->next = l->next;
        l->next = s->next;
        cin >> x; // 读入下一个数据
    }
    return l;
}

int main() {
    LinkList list;
    LinkList l = Link_HeaderInsert(list);

    while(l->next != nullptr) {
        cout << l->data << " ";
        l = l->next;
    }
    return 0;
}



