# 二叉树(Binary Tree)

## 定义

二叉树：每个节点的度最大为2(最多拥有两棵子树)

## 二叉树的性质

- 在非空二叉树的第`i`层，最多有`2^(i-1)`个节点`i >= 1`
- 在高度为`h`的二叉树上最多有`2^(h-1)`个节点`h >= 1`
- 对于任何一棵非空二叉树，如果叶子节点个数为`n_0`,度为`2`的节点个数为`n_2`,则有`n_0 = n_2 + 1`
- 二叉树的边数`n - 1`

## 真二叉树(Proper Binary Tree)

所有的节点的度都要么为0要么为2

## 满二叉树

- 所有节点的度都要么为0，要么为2。且所有的叶子节点都在最后一层
- 在同样高度的二叉树中，满二叉树的叶子节点数量是最多的，总结点数量最多
- 满二叉树一定是真二叉树，真二叉树不一定是满二叉树
- 总结点个数为`n` 高度为`log_2(n+1)`

## 完全二叉树(Complete Binary Tree)

叶子节点只会出现最后两层，且最后一层的叶子节点都靠左对齐

满二叉树一定是完全二叉树，完全二叉树不一定是满二叉树

度为1的节点要么是一个，要么是零个

同样节点数量的二叉树，完全二叉树的高度最小

假设完全二叉树的高度为`h(h>=1)`,那么至少有`2^(h-1)`个节点

总节点数量为n `2^(h-1) <= n < 2^h`  `h-1 <= log2n < h` `h = floor(log2n) + 1`

一棵有n个节点的完全二叉树`(n>0)`,从上到下，从左到右对节点从1开始进行编号，对任意第i个节点

- 如果`i=1`，它是根节点

- 如果`i>1`它的父节点编号为`floor(i/2)`

- 如果`2*i <= n`，它的左子节点编号为`2*i`

- 如果`2*i > n`，它无左子节点

- 如果`2*i+1 <= n`，它的右子节点编号为`2*i+1`

- 叶子节点个数
  $$
  n_0=floor((n+1)/2)=ceiling((n-1)/2)
  $$
  

## 二叉搜索树(BST)

二叉搜索树是二叉树的一种，是应用非常广泛的一种二叉树，

- 其特点为任意一个节点的值都大于其左子树所有节点的值，
- 任意一个节点的值都小于其右子树所有节点的值
- 它的左右子树也是一颗二叉搜索树
- 对于二叉搜索树搜索数据在最坏的情况下也能做到`O(log_n)`
- 二叉树搜索树所存储的元素必须具有可比性

## 二叉树的遍历

### 前序遍历

优先访问根节点、左子树、右子树

```java
// 根 -> 左 -> 右
public void preorderTraversal(Node<E> node){
    if(node == null) {
    	return;
    }
    System.out.println(node.element);
    preorderTraversal(node.left);
    preorderTraversal(node.right);
}
```

### 中序遍历

优先访问左子树、根节点、右子树或者(右子树、根节点、左子树)

中序遍历二叉搜索树的结果是一个递增有序的序列或者(是一个递减有序的序列)

```java
// 左 -> 根 -> 右
private void inorderTraversal(Node<E> node){
    if(node == null) {
    return;
    }
    inorderTraversal(node.left);
    System.out.println(node.element);
    inorderTraversal(node.right);
}
```

### 后续遍历

优先访问左子树、右子树、根节点

```java
// 左 -> 右 -> 根
private void postorderTraversal(Node<E> node){
    if(node == null) {
    	return;
    }
    postorderTraversal(node.left);
    postorderTraversal(node.right);
    System.out.println(node.element);
}
```

### 层序遍历

按照树的层次来遍历

```java
public void levelOrderTraversal(){
	if(root == null) return;
    Queue<Node<E>> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
        Node<E> node = queue.poll();
        System.out.println(node.element);
        if(node.left != null) {
        	queue.offer(node.left);
        }
        if(node.right != null){
        	queue.offer(node.right);
        }
    }
}
```

