import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BinaryTree bt = new BinaryTree();
        bt.root = new Node('A');

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            Node searchNode = bt.search(bt.root, ch);

            char leftCh = st.nextToken().charAt(0);
            char rightCh = st.nextToken().charAt(0);
            if(leftCh != '.') {
                searchNode.left = new Node(leftCh);
            }
            if(rightCh != '.') {
                searchNode.right = new Node(rightCh);
            }

        }
        bt.preorderTraversal(bt.root);
        System.out.println();
        bt.inorderTraversal(bt.root);
        System.out.println();
        bt.postorderTraversal(bt.root);

    }
}

class Node {
    char data;
    Node left, right;

    public Node(char data) {
        this.data = data;
        left = right = null;
    }

}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data);
            inorderTraversal(node.right);
        }
    }

    public void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data);
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data);
        }
    }

    public Node search(Node node, char data) {
        if (node == null) {
            return null;
        }
        if (node.data == data) {
            return node;
        }

        Node foundNode = search(node.left, data);
        if (foundNode != null) {
            return foundNode;
        }

        return search(node.right, data);
    }
}
