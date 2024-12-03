import java.util.LinkedList;
import java.util.Queue;

public class HeightBinaryTree {

    public static void main(String[] args) {
        // Representation of the input tree:
        //     1
        //    / \
        //   2   3
        //  / \
        // 4   5
        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        root.getLeft().setLeft(new Node(4));
        root.getLeft().setRight(new Node(5));
        System.out.println(recursionMaxDepth(root));
        System.out.println(queueMaxDepth(root));
    }

    private static int queueMaxDepth(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int height = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node == null) {
                height++;
                if (!queue.isEmpty())
                    queue.add(null);
            } else
                addChildren(node, queue);
        }
        return height;
    }

    private static void addChildren(Node node, Queue<Node> queue) {
        if (node.getLeft() != null)
            queue.add(node.getLeft());
        if (node.getRight() != null)
            queue.add(node.getRight());
    }

    private static int recursionMaxDepth(Node node) {
        if (node == null)
            return 0;

        return Math.max(
                recursionMaxDepth(node.getLeft()),
                recursionMaxDepth(node.getRight())
        ) + 1;
    }

}

class Node {

    private int val;
    private Node left;
    private Node right;

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Node(int val) {
        this(val, null, null);
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}