package LK;

import java.util.List;

public class lk25 {

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        ListNode be= new ListNode(1,node);
        for(int i = 2;i<6;i++){
            node.next = new ListNode(i);
            node = node.next;
        }
//        be.next.out();
         lk25 lk = new lk25();
        be.next = lk.reverseKGroup(be.next, 6);
        be.next.out();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1)
            return head;
        ListNode begin = new ListNode();
        ListNode first = new ListNode();
        ListNode node = new ListNode();
        ListNode end = new ListNode();
        ListNode beforeLast = new ListNode();


        int index = 1;
        begin.next = head;
        node.next = head;

        while(true){
            if(node.next.next == null)
                break;
            node.next = node.next.next;
            index++;
            if(index % k == 0){
                end.next = node.next;
                node.next = node.next.next;
                end.next.next = null;
//                if(beforeLast.next != null)
//                    beforeLast.next.next = null;
                index++;
                reversal(begin.next);
                if(index == k+1){
                    first.next = end.next;
                }else {
                    beforeLast.next.next = end.next;
                }
                beforeLast.next = begin.next;
                begin.next.next = node.next;
                begin.next = node.next;
            }
            if(node.next == null)
                break;
        }
        return first.next;
    }

    //链表反转
    public ListNode reversal(ListNode node){

        ListNode beforeEnd = new ListNode();
        ListNode end = new ListNode();
        end.next = node.next;
        while (true){
            node.next = beforeEnd.next;
            beforeEnd.next = node;
            node = end.next;
            if(end.next.next == null)
                break;
            end.next = end.next.next;
        }
        node.next = beforeEnd.next;

        return node;
    }

}



