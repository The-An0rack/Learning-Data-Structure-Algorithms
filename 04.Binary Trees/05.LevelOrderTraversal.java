import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTreeOperations {
    static int idx = -1;

    static Node buildTreePreorder(int[] list) {
        idx++;
        if(list[idx] == -1) {
            return null;
        }

        Node newNode = new Node(list[idx]);
        newNode.left = buildTreePreorder(list);
        newNode.right = buildTreePreorder(list);

        return newNode;
    }

    static void levelOrderTraversal(Node node){

        if(node == null) {
            return;
        }

        Queue<Node> q= new LinkedList<>();

        q.add(node);
        q.add(null);

        while(!q.isEmpty()) {
            Node currNode = q.remove();

            if(currNode == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }
} 

class Main {
    public static void main(String[] args) {
        int[] list = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = BinaryTreeOperations.buildTreePreorder(list);

         //Level Order Traversal
         System.out.print("Level-order traversal: ");
         BinaryTreeOperations.levelOrderTraversal(root);
         System.out.println();
    }
}