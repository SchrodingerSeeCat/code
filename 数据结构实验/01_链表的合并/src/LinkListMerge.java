public class LinkListMerge {
	public static void main(String[] args) {
		LinkList la = new LinkList();
		la.add(1);
		la.add(2);
		la.add(3);
		la.add(4);
		la.add(5);

		LinkList lb = new LinkList();
		lb.add(2);
		lb.add(4);
		lb.add(6);
		lb.add(8);
		lb.add(10);
		System.out.println("la: " + la);
		System.out.println("lb: " + lb);
		LinkList lc = LinkList.MergeOrderLinkList(la, lb);
		System.out.println("lc: " + lc);
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
		Node node = root;
		while(node.next != null) {
			sb.append(node.element).append("->");
			node = node.next;
		}
		sb.append(node.element);
		return sb.toString();
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
	}
}
