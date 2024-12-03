import java.util.LinkedList;

public class AddTwoNumbers {

    /*
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     */

    public static void main(String[] args) {
        var x1 = new ListNode(2);
        var x2 = new ListNode(4);
        var x3 = new ListNode(3);
        x1.next = x2;
        x2.next = x3;

        var y1 = new ListNode(5);
        var y2 = new ListNode(6);
        var y3 = new ListNode(4);
        y1.next = y2;
        y2.next = y3;

        System.out.println(addTwoNumbersListNode(x1, y1));

        var l1 = new LinkedList<Integer>();
        l1.add(2);
        l1.add(4);
        l1.add(3);

        var l2 = new LinkedList<Integer>();
        l2.add(5);
        l2.add(6);
        l2.add(4);

        System.out.println(addTwoNumbersLiskedList(l1, l2));
    }

    public static ListNode addTwoNumbersListNode(ListNode l1, ListNode l2) {
        int carry = 0;
        var dummyHead = new ListNode(0);
        var tail = dummyHead;

        while (l1 != null || l2 != null || carry!=0) {
            int firstDigit = l1 != null ? l1.val : 0;
            int secondDigit = l2 != null ? l2.val : 0;

            int result = firstDigit + secondDigit + carry;
            int digit = result % 10;
            carry = result / 10;

            tail.next = new ListNode(digit);
            tail = tail.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return dummyHead.next;
    }

    public static LinkedList<Integer> addTwoNumbersLiskedList(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        int carry = 0;
        var resultList = new LinkedList<Integer>();
        var l1Iterator = l1.iterator();
        var l2Iterator = l2.iterator();

        while (l1Iterator.hasNext() || l2Iterator.hasNext() || carry !=0) {
            int firstDigit = l1Iterator.next();
            int secondDigit = l2Iterator.next();

            int result = firstDigit + secondDigit + carry;
            int digit = result % 10;
            carry = result / 10;

            resultList.add(digit);
        }

        return resultList;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        var result = "";
        var node = this;
        while (node != null) {
            result = result.concat(String.valueOf(node.val));
            node = node.next;
        }
        return result;
    }

}