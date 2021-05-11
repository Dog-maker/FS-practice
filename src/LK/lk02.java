package LK;

import javax.xml.soap.Node;
import java.util.Scanner;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 */
public class lk02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode beginNode = new ListNode();
        beginNode.next = node;
        int val;
        int x = 0;
        while(true){
            val = l1.val+l2.val+x;
            x = 0;
            if(val >= 10){
                val = val%10;
                x = 1;
            }
            node.val = val;
            if(l1.next == null || l2.next == null)
                break;
            l1 = l1.next;
            l2 = l2.next;
            node.next = new ListNode();
            node = node.next;
        }


        while (l1.next != null){
           l1 = l1.next;
            node.next = new ListNode();
            node = node.next;
            val = l1.val+x;
            x = 0;
            if(val == 10){
                val = val%10;
                x = 1;
            }
            node.val = val;
        }
        while (l2.next != null){
            l2 = l2.next;
            node.next = new ListNode();
            node = node.next;
            val = l2.val+x;
            x = 0;
            if(val == 10){
                val = val%10;
                x = 1;
            }
            node.val = val;
        }
        if(x == 1)
            node.next = new ListNode(1);
        return beginNode.next;
    }


}


