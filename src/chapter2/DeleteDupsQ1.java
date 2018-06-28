package chapter2;

import java.util.*;
import helpers.*;
/*题2.1：
 *编写代码，移除未排序链表中的重复结点。
 *进阶
 *如果不得使用临时缓冲区，该怎么解决 
 */

//duplication为副本的意思
public class DeleteDupsQ1 {
	//解法：迭代访问整个链表，将每个结点加入散列表。若发现有重复元素，则将该结点从链表中移除，然后继续迭代。
	//这个题目使用了链表，因此只需扫描一次就能搞定。
	//时间复杂度为O(N)，N为链表结点数目
	public static void removeDuplicates(LinkedListNode n){
		Hashtable table=new Hashtable();
		LinkedListNode previous=null;
		while(n!=null){
			if(table.containsKey(n.data)){
				previous.next=n.next;
			}else{
				table.put(n.data, true);
				previous=n;
			}
			n=n.next;
		}
	}
	
	//不借助额外缓冲区，可以用两个指针来迭代：n迭代访问整个链表,runner由于检查后续的结点是否重复。
	//空间复杂度为O(N)，时间复杂度为O(N)
	 static void removeDuplicates2(LinkedListNode n) {
	        while (n != null) {
	            LinkedListNode runner = n;
	            while (runner.next != null) {
	                if (runner.next.data == n.data) {
	                    runner.next = runner.next.next;
	                } else {
	                    runner = runner.next;
	                }
	            }
	            n = n.next;
	        }
	    }

	public static void main(String[] args) {
		 int[] list = {1,1,2,3,3,4,2,5,5};
	        LinkedListNode n = LinkedListNode.buildList(list);
	        removeDuplicates(n);
	        LinkedListNode.printList(n);
	        n = LinkedListNode.buildList(list);
	        removeDuplicates2(n);
	        LinkedListNode.printList(n);
	}

}
