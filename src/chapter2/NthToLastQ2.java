package chapter2;

import helpers.LinkedListNode;

/*
 * 题2.2：实现一个算法，找出单向链表中倒数第k个结点。
 */

/*
 * 解法：递归访问整个链表，当抵达链表末端时，该方法会回传一个置为0的计数器。
 * 之后的每次调用都会将这个计数器加一，当计数器等于k时，表示我们访问的是链表的倒数第k个元素。
 */

/*时间复杂度为O(N),空间复杂度为O(1)*/
public class NthToLastQ2 {
	static LinkedListNode nthToLast(LinkedListNode head, int k) {
		if(k<=0) return null;
        LinkedListNode p1= head, p2= head;
        //p2向前移动k个结点
        for (int i = 0; i < k-1; i++) {
        	if(p2==null) return null;//错误检查
            p2 = p2.next;
        }
        if(p2==null) return null;
        /*
         * 以同样的速度移动p1和p2，当p2抵达链表末尾时，p1刚好指向第k个结点
         */
        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        int[] list = {5,4,3,2,1,0};
        LinkedListNode n = LinkedListNode.buildList(list);
        System.out.println(nthToLast(n, 0));
        System.out.println(nthToLast(n, 3));
        System.out.println(nthToLast(n, 5));
        System.out.println(nthToLast(n, 6));
        System.out.println(nthToLast(n, -100));
        System.out.println(nthToLast(n, 100));
    }
}
