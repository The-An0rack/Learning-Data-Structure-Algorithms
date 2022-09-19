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

    static void postOrderTraversal(Node node) {
        if(node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }
    
} 

class Main {
    public static void main(String[] args) {
        int[] list = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = BinaryTreeOperations.buildTreePreorder(list);

        //Post Order Traversal
        System.out.print("Post-order traversal: ");
        BinaryTreeOperations.postOrderTraversal(root);
        System.out.println();
    }
}