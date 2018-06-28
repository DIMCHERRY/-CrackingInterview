package chapter2;

import helpers.LinkedListNode;

/*
 * 题2.3：实现一个算法，删除单向链表中的某个结点，假定你只能访问该结点。
 */

/*解法：此问题中，访问不到链表的首结点，只能访问待删除结点，
 * 若待删除结点为链表的尾结点，则此问题无解。
 * 可以考虑将尾结点标记为假。
 */
public class DeleteNodeQ3 {
	   static boolean deleteNode(LinkedListNode n) {
	        //XXX: fail if the node is the last element.
	        if (n == null || n.next == null) return false;
	        LinkedListNode next=n.next;
	        n.data = next.data;
	        n.next = next.next;
	        return true;
	    }

	    //TEST----------------------------------
	    public static void main(String[] args) {
	        int[] list = {3,2,1,0};
	        LinkedListNode head = LinkedListNode.buildList(list);
	        LinkedListNode n1 = head.next;
	        System.out.println("DELETE " + n1 + ": " + deleteNode(n1));
	        LinkedListNode.printList(head);
	        LinkedListNode head1 = LinkedListNode.buildList(list);
	        LinkedListNode n2 = head1.next.next;
	        System.out.println("DELETE " + n2+ ": " + deleteNode(n2));
	        LinkedListNode.printList(head1);
	    }
}
