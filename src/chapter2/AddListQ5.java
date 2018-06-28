package chapter2;

import helpers.LinkedListNode;

/*题2.5：
 * 给定两个用链表表示的整数，每个结点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。编写函数对这两个整数求和，并用链表形式返回结果。
 * 进阶
 * 假设这些数位是正向存放，请再做一遍。
 */
public class AddListQ5 {
	 public static LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {  
	        //定义满十进一的数  
	        int num = 0;  
	        //定义一个ListNode，作为链表头  
	        LinkedListNode proNode = new LinkedListNode(0);  
	        //定义一个ListNode，接受两数的和  
	        LinkedListNode currentNode = new LinkedListNode(0);  
	        //先连接两个Node  
	        proNode.next=currentNode;  
	          
	        do {  
	            //两数相加  
	            int sum = (l1!=null?l1.data:0) + (l2!=null?l2.data:0) + num;  
	            //是否满十  
	            num = sum/10;  
	            //得出个位数  
	            int result = sum%10;  
	            //填入结果  
	            currentNode.data = result;  
	            l1 = l1!=null?l1.next:l1;  
	            l2 = l2!=null?l2.next:l2;  
	            if(l1!=null || l2!=null || num!=0) {  
	                currentNode.next = new LinkedListNode(0);  
	                currentNode = currentNode.next;  
	            }  
	        }while(l1!=null || l2!=null || num!=0);  
	        return proNode.next;  
	    }  
    

    //TEST----------------------------------
    public static void main(String[] args) {
        LinkedListNode l1 = LinkedListNode.buildList(new int[] {2,1,8});
        LinkedListNode l2 = LinkedListNode.buildList(new int[] {8,8,1});
        LinkedListNode.printList(addTwoNumbers(l1, l2));

        l1 = LinkedListNode.buildList(new int[] {2,9,1});
        l2 = LinkedListNode.buildList(new int[] {8});
        LinkedListNode.printList(addTwoNumbers(l1, l2));
        LinkedListNode.printList(addTwoNumbers(l2, l1));
    }
}
