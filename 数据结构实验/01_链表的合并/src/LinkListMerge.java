import java.util.LinkedList;
import java.util.Scanner;

public class LinkListMerge {
//	public static void main(String[] args) {
//		Scanner reader = new Scanner(System.in);
//
//		// 读入a
//		int n = reader.nextInt();
//		LinkList la = new LinkList();
//		for(int i = 0; i < n; i++) {
//			la.add(reader.nextInt());
//		}
//
//		// 读入b
//		n = reader.nextInt();
//		LinkList lb = new LinkList();
//		for(int i = 0; i < n; i++) {
//			lb.add(reader.nextInt());
//		}
//
//		LinkList lc = LinkList.MergeOrderLinkList(la, lb);
//		System.out.println(lc);
//	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		// 读入a
		int n = reader.nextInt();
		LinkList l = new LinkList();
		for(int i = 0; i < n; i++) {
			l.add(reader.nextInt());
		}
		l.reverse();
		System.out.println(l);
	}
}

class LinkList{
	private Node root;

	// 合并节点
	public static LinkList MergeOrderLinkList(LinkList first, LinkList second) {
		LinkList lc =  null;
		Node a = first.root;
		Node b = second.root;
		if(first.root.element - second.root.element < 0) {
			lc = first;
			a = a.next;
		} else {
			lc = second;
			b = b.next;
		}
		Node c = lc.root;
		while(a != null && b != null) {
			while(a != null && b != null) {
				if(a.element < b.element) {
					a = a.next;
					c = c.next;
				} else {
					c.next = b;
					break;
				}
			}
			while(a != null && b != null) {
				if(a.element >= b.element) {
					b = b.next;
					c = c.next;
				} else {
					c.next = a;
					break;
				}
			}
			if(a == null) {
				c.next = b;
			}
			if(b == null) {
				c.next = a;
			}
		}
		return lc;
	}

	// toString
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(root == null) {
			return null;
		}
		Node node = root;
		while(node != null && node.next != null) {
			sb.append(node.element).append(" ");
			node = node.next;
		}
		sb.append(node.element);
		return sb.toString();
	}

	public void reverse() {
		if(root == null) return;

		Node node = root;
		Node prev = null;
		Node next = null;
		while(node != null && node.next != null) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		node.next = prev;
		root = node;
	}

	// 添加节点
	public void add(int element) {
		add(element, null);
	}
	public void add(int element, Node node) {
		// 添加的是第一个节点
		if(root == null) {
			root = new Node(element, null);
			return;
		}


		Node temp = node(node);
		Node newNode = new Node(element, temp.next);
		temp.next = newNode;
	}

	// 查找节点的父节点
	public Node node(Node node) {
		if(node == root) {
			return null;
		}
		Node parent = root;
		while(parent.next != node) {
			parent = parent.next;
		}
		return parent;
	}

	// 链表节点
	private class Node{
		private int element;
		private Node next;
		public Node(int element, Node next) {
			this.element = element;
			this.next = next;
		}

		@Override
		public String toString() {
			return element + " ";
		}
	}
}
