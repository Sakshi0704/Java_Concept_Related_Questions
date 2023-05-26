
//  Definition for singly-linked list.
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
public class AddingTwoLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        int carry = 0;

        while (c1 != null || c2 != null) {
            int sum = carry;

            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }

            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }

            carry = sum / 10;
            sum %= 10;

            ans.next = new ListNode(sum);
            ans = ans.next;
        }

        if (carry > 0) {
            ans.next = new ListNode(carry);
        }

        return dummy.next;
    }
}