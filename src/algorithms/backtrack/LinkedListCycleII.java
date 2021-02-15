package algorithms.backtrack;

public class LinkedListCycleII {
	
	public static void main(String[] args) {
		// ---- Generate our linked list ----
		MNReversals sol = new MNReversals();
		int[] arr = new int[] {5, 4, 3, 2, 1};
		ListNode linkedList = sol.generateList(arr);
		
		sol.printList(linkedList);
		//System.out.println("\nafter reverse");
		//sol.printList(sol.reverseBetween(linkedList, 2, 4));
		
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
}
