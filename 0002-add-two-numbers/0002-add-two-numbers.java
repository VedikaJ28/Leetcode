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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        int carry=0;
        int total=0;
        while(l1!=null || l2!=null || carry !=0){
            total=carry;
            if(l1 !=null){
                total+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                total+=l2.val;
                l2=l2.next;
            }
            int no=total%10;
            carry=total/10;
            current.next=new ListNode(no);
            current=current.next;

        }
        return dummy.next;
    //     if(l1.next==null && l1.val==0 || l1==null){
    //         return l2;
    //     }
    //     if(l2.next==null && l2.val==0 || l2==null){
    //         return l1;
    //     }
    //     if(l1.next==null && l1.val==0 && l2.next==null && l2.val==0 ){
    //         return l2;
    //     }
    //     if(l2==null && l1==null){
    //         return null;
    //     }
    //     String str1="";
    //     String str2="";
    //     while(l1!=null){
    //         str1+=Integer.toString(l1.val);
    //         l1=l1.next;
    //     }
    //     while(l2!=null){
    //         str2+=Integer.toString(l2.val);
    //         l2=l2.next;
    //     }
    //     int no1=Integer.parseInt(str1);
    //     int no2=Integer.parseInt(str2);
    //     int revNo1=reverse(no1);
    //     int revNo2=reverse(no2);
    //     int sum=revNo1+revNo2;
    //     ListNode head=null;
    //     ListNode current =null;
    //     while(sum>0){
    //         int digit=sum%10;
    //         sum/=10;
    //         ListNode newNode=new ListNode(digit);
    //         if(head==null){
    //             head=newNode;
    //             current=head;
    //         }
    //         else{
    //             current.next=newNode;
    //             current=current.next;
    //         }

    //     }
    //     return head;
        
    // }
    // public int reverse(int no){
    //     int reversed=0;
    //     while(no!=0){
    //         int digit =no%10;
    //         reversed=reversed*10+digit;
    //         no /= 10;
    //     }
    //     return reversed;
    }
}