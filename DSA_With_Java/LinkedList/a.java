
//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class a {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
                ListNode c1 = l1;
                ListNode c2 = l2;
    
                ListNode n = new ListNode(-1);  // val = -1 & next = null  //-1 ---> 3 ---> 
                ListNode ans = n;
                int carray = 0;
                while(c1!=null || c2!= null){
                    int sum = 0;
                    if(c1!=null && c2!=null){
                        sum = c1.val+c2.val+carray;
                        c1 = c1.next;
                        c2 = c2.next;
                    }
                    else if(c1!=null && c2 == null){
                        sum = c1.val + carray;
                        c1 = c1.next;
                    }
                    else if(c1==null && c2!=null){
                        sum = c2.val+carray;
                        c2 = c2.next;
                    }
                   if(sum > 9){  //23
                       carray = sum/10;  //2
                       ans.val = sum%10;
                       //.next = new ListNode(sum%10);  //3
                   }
                   else{
                       carray = 0;
                       ans.val = sum;
                   }
                  ans.next = new ListNode();
                  ans = ans.next;
    
                }
    
            return n;
    
        }
    }