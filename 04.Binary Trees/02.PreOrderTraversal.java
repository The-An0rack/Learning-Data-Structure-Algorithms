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

    static void preOrderTraversal(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
}

class Main {
    public static void main(String[] args) {
        int[] list = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = BinaryTreeOperations.buildTreePreorder(list);
        
        //Pre Order Traversal
        System.out.print("Pre order Traversal: ");
        BinaryTreeOperations.preOrderTraversal(root);
        System.out.println();

        
    }
}