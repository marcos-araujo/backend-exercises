import java.util.LinkedList;

public class AddTwoNumbers {

    /**
      * You are given two non-empty linked lists representing two non-negative integers.
      * The digits are stored in reverse order, and each of their nodes contains a single digit.
      * Add the two numbers and return the sum as a linked list.
      * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
      */

    public static void main(String[] args) {
        var x1 = new ListNode(2);
        var x2 = new ListNode(4);
        var x3 = new ListNode(3);
        x1.setNext(x2);
        x2.setNext(x3);

        var y1 = new ListNode(5);
        var y2 = new ListNode(6);
        var y3 = new ListNode(4);
        y1.setNext(y2);
        y2.setNext(y3);

        ListNode listNodeResult = listNodeSolution(x1, y1);
        System.out.println(listNodeResult);

        var l1 = new LinkedList<Integer>();
        l1.add(2);
        l1.add(4);
        l1.add(3);

        var l2 = new LinkedList<Integer>();
        l2.add(5);
        l2.add(6);
        l2.add(4);

        LinkedList<Integer> linkedListResult = linkedListSolution(l1, l2);
        System.out.println(linkedListResult);
    }

    /**
     * ListNode Solution
     * Time Complexity: O(n)
     */
    public static ListNode listNodeSolution(ListNode l1, ListNode l2) {
        int carry = 0;
        var dummyHead = new ListNode(0);
        var tail = dummyHead;

        while (l1 != null || l2 != null || carry != 0) {
            int firstDigit = l1 != null ? l1.getVal() : 0;
            int secondDigit = l2 != null ? l2.getVal() : 0;

            int result = firstDigit + secondDigit + carry;
            int digit = result % 10;
            carry = result / 10;

            tail.setNext(new ListNode(digit));
            tail = tail.getNext();

            l1 = l1 != null ? l1.getNext() : null;
            l2 = l2 != null ? l2.getNext() : null;
        }

        return dummyHead.getNext();
    }

    /**
     * LinkedList Solution
     * Time Complexity: O(n)
     */
    public static LinkedList<Integer> linkedListSolution(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        int carry = 0;
        var resultList = new LinkedList<Integer>();
        var l1Iterator = l1.iterator();
        var l2Iterator = l2.iterator();

        while (l1Iterator.hasNext() || l2Iterator.hasNext() || carry != 0) {
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