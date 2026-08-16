/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
//find the length of linked list 
int len = 0 ; 
ListNode temp = head ; 

while(temp!=null){
    temp = temp.next ; 
    len++ ; 
}
if(len==1 && n==1){
    return null ;
}

//nth from end means length-n+1 from start 
ListNode prev = null ; 
temp = head ; 
int lencheck = len-n; 
  if (lencheck == 0) {
            return head.next;
        }
while(lencheck>0){
    prev = temp ; 
    temp = temp.next ; 
    lencheck--;
    
}

//temp will be the elemetn which needs to be removed 
prev.next = temp.next ; 
temp.next = null ; 
return head ; 
    }
}
