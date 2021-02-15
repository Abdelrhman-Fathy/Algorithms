package algorithms.backtrack;

public class MNReversals {
	
	public static void main(String[] args) {
		// ---- Generate our linked list ----
		MNReversals sol = new MNReversals();
		int[] arr = new int[] {5, 4, 3, 2, 1};
		ListNode linkedList = sol.generateList(arr);
		
		sol.printList(linkedList);
		System.out.println("\nafter reverse");
		sol.printList(sol.reverseBetween(linkedList, 2, 4));
		
	}
	
	ListNode generateList(int[] arr) {
		ListNode linkedList = new ListNode();
		ListNode cur = linkedList;
		for(int i : arr) {
			cur.next = new ListNode(i);
			cur = cur.next;
		}
		return linkedList.next;
	}

	 void printList(ListNode head){
	  if(head == null) {
	    return;
	  }
	  System.out.print(head.val +" ");
	  printList(head.next);
	}
	 
	 //------------solution-----------------
	 ListNode reverseBetween (ListNode head, int m, int n) {
		  int currentPos = 1;
		  ListNode currentNode = head;
		  ListNode start = head;
		  
		  while(currentPos < m) {
		    start = currentNode;
		    currentNode = currentNode.next;
		    currentPos++;
		  }
		  
		  ListNode newList = null, tail = currentNode;
		  
		  while(currentPos >= m && currentPos <= n) {
		    ListNode next = currentNode.next;
		    currentNode.next = newList;
		    newList = currentNode;
		    currentNode = next;
		    currentPos++;
		  }
		  
		  start.next = newList;
		  tail.next = currentNode;
		  
		  if(m > 1) return head;
		  else return newList;
		}
	

}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
