package chapter2;

import helpers.LinkedListNode;


//暂时放着
/*
 * 给定一个有环链表，实现一个算法返回环路的开头结点。
 */
public class FindingBeginningQ6 {
    static LinkedListNode findBeginning(LinkedListNode head) {
        LinkedListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        int[] list = {1,2,3,4,5,6};
        LinkedListNode n = LinkedListNode.buildList(list), head = n;
        System.out.println(findBeginning(head));

        while (n.next != null) n = n.next;
        n.next = head.next.next.next;
        System.out.println(findBeginning(head));
    }
}
