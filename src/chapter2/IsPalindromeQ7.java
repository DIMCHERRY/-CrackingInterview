package chapter2;

import java.util.Stack;
import helpers.LinkedListNode;

/*
 * 题2.7：编写一个函数，检查链表是否为回文。
 */
public class IsPalindromeQ7 {
	static boolean isPalindrome(LinkedListNode head) {
        if (head == null) return false;
        LinkedListNode p1 = head, p2 = head;
        Stack<Integer> s = new Stack<Integer>();
        while (p2 != null && p2.next != null) {
            s.push(p1.data);
            p1 = p1.next;
            p2 = p2.next.next;
        }
        // handle odd nodes
        if (p2 != null) p1 = p1.next;
        while (p1 != null) {
            if(p1.data != s.pop()) return false;
            p1 = p1.next;
        }
        return true;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        System.out.println(isPalindrome(null));
        System.out.println(isPalindrome(LinkedListNode.buildList(new int[] {1})));
        System.out.println(isPalindrome(LinkedListNode.buildList(new int[] {1,1})));
        System.out.println(isPalindrome(LinkedListNode.buildList(new int[] {1,2,3,4,4,3,2,1})));
        System.out.println(isPalindrome(LinkedListNode.buildList(new int[] {1,2,3,4,4,3,3,2,1})));
    }

}
