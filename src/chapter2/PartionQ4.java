package chapter2;

import helpers.LinkedListNode;

//这题的结果我暂时真的很懵，肯定是代码哪有问题，暂时放一下 
/*
 * 题2.4：编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前。
 */
public class PartionQ4 {
	  static LinkedListNode partition(LinkedListNode node, int x) {
	        LinkedListNode beforeStart=null;
	        LinkedListNode beforeEnd=null;
	        LinkedListNode afterStart=null;
	        LinkedListNode afterEnd=null;
	        		
	        while (node != null) {
	        	LinkedListNode next=node.next;
	        	node.next=null;
	        	/*将结点插入before链表*/
	            if (node.data < x) {
	                if (beforeStart == null) {
	                    beforeStart = node;
	                    beforeEnd=beforeStart;
	                } else {
	                    beforeEnd.next = node;
	                    beforeEnd = node;
	                }
	            } else {
	            	/*将结点插入after链表*/
	                if (afterStart == null) {
	                    afterStart = node ;
	                    afterEnd=afterStart;
	                } else {
	                    afterEnd.next = node;
	                    afterEnd = node;
	                }
	            }
	            node = next;
	        }
	        if (beforeStart == null){
	        	return afterStart;
	        }
	        
	        //合并before和after链表
	        beforeEnd.next=afterStart;
	        return beforeStart;
	    }
	  
	  static LinkedListNode partition1(LinkedListNode node,int x){
		  LinkedListNode beforeStart=null;
		  LinkedListNode afterStart=null;
		  
		  /*分裂链表*/
		  while(node!=null){
			  LinkedListNode next=node.next;
			  if(node.data<x){
				  /*将结点插入before链表的前端*/
				  node.next=beforeStart;
				  beforeStart=node;
			  }else{
				  /*将结点插入before链表*/
				  node.next=afterStart;
				  afterStart=node;
			  }
			  node=next;
		  }
		  
		//合并before和after链表
	    if (beforeStart == null){
	        return afterStart;
	       }
	    
	    /*定位至before链表末尾，合并两个链表*/
	    LinkedListNode head=beforeStart;
	    while(beforeStart.next!=null){
	    	beforeStart=beforeStart.next;
	    }
	    beforeStart.next=afterStart;
	    
	    return head;
	  }
	  
	    static LinkedListNode partition2(LinkedListNode n, int x) {
	        LinkedListNode head1 = null, tail1 = null,
	                       head2 = null, tail2 = null;
	        while (n != null) {
	            if (n.data < x) {
	                if (head1 == null) {
	                    head1 = tail1 = n;
	                } else {
	                    tail1.next = n;
	                    tail1 = n;
	                }
	            } else {
	                if (head2 == null) {
	                    head2 = tail2 = n;
	                } else {
	                    tail2.next = n;
	                    tail2 = n;
	                }
	            }
	            n = n.next;
	        }
	        // Trim tails
	        if (tail1 != null) tail1.next = null;
	        if (tail2 != null) tail2.next = null;

	        // List1 is empty
	        if (head1 == null) return head2;
	        tail1.next = head2;
	        return head1;
	    }

	    //TEST----------------------------------
	    public static void main(String[] args) {
	        int[] list = {9,2,7,4,6,5,3,8,1};
	        LinkedListNode n = LinkedListNode.buildList(list);
	        LinkedListNode.printList(partition1(n, 6));
	        LinkedListNode n1 = LinkedListNode.buildList(list);
	        LinkedListNode.printList(partition(n1, 6));
	        LinkedListNode n2 = LinkedListNode.buildList(list);
	        LinkedListNode.printList(partition(n2, 6));
	    } 
}
