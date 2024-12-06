public class ListNode {

    private int val;
    private ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public int getVal() {
        return val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

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
