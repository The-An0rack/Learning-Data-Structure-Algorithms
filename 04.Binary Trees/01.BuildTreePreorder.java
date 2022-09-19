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
}

class Main {
    public static void main(String[] args) {
        int[] list = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTreeOperations tree = new BinaryTreeOperations();
        Node root = tree.buildTreePreorder(list);
        System.out.println(root.data);
    }
}