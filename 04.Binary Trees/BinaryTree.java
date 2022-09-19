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

    static void preOrderTraversal(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    static void inOrderTraversal(Node node) {
        if(node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    static void postOrderTraversal(Node node) {
        if(node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
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

    static int countNodes(Node node) {
        if(node == null) {
            return 0;
        }

        int leftCount = countNodes(node.left);
        int rightCount = countNodes(node.right);

        return leftCount + rightCount + 1;
    }

    static int sumTree(Node node) {
        if(node == null) {
            return 0;
        }

        int leftSubTreeSum = sumTree(node.left);
        int rightSubTreeSum = sumTree(node.right);

        return leftSubTreeSum + rightSubTreeSum + node.data;
    }

    static int getHeight(Node node) {
        if(node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHight = getHeight(node.right);

        return Math.max(leftHeight, rightHight) + 1;
    }

    static int diameterOfATree(Node node) {
        if(node == null) {
            return 0;
        }

        int diam1 = diameterOfATree(node.left);
        int diam2 = diameterOfATree(node.right);
        int diam3 = getHeight(node.left) + getHeight(node.right) + 1;

        return Math.max(diam3, Math.max(diam1, diam2));
    }

    static class TreeInfo {
        int ht;
        int diam;

        TreeInfo(int height, int diameter) {
            this.ht = height;
            this.diam = diameter;
        }
    }

    //Diameter of a tree - Approach 2
    public static TreeInfo diameterOfATree2(Node node) {
        if(node == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameterOfATree2(node.left);
        TreeInfo right = diameterOfATree2(node.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;
        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int myDiam = Math.max(diam3, Math.max(diam1, diam2));

        return new TreeInfo(myHeight, myDiam);

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
        
        //In Order Traversal
        System.out.print("In-order traversal: ");
        BinaryTreeOperations.inOrderTraversal(root);
        System.out.println();

        //Post Order Traversal
        System.out.print("Post-order traversal: ");
        BinaryTreeOperations.postOrderTraversal(root);
        System.out.println();

         //Level Order Traversal
         System.out.print("Level-order traversal: ");
         BinaryTreeOperations.levelOrderTraversal(root);
         System.out.println();

         //Count Nodes
         //Time Complexity: O(n), where n is the number of nodes
         System.out.println("Total Nodes: " + BinaryTreeOperations.countNodes(root));

         //Sum Nodes
         //Time Complexity: O(n), where n is the number of nodes
         System.out.println("Sum of tree: " + BinaryTreeOperations.sumTree(root));

         //Height of a Binary tree
         System.out.println("Height of tree: " + BinaryTreeOperations.getHeight(root));

         //Diameter of a Tree - Approach 1
         // TimeComplexity: O(n^2)
         System.out.println("Diameter of tree: " + BinaryTreeOperations.diameterOfATree(root));

         //Diameter of a Tree - Approach 2
         // TimeComplexity: O(n^2)
         System.out.println("Diameter of tree: " + (BinaryTreeOperations.diameterOfATree2(root)).diam);
    }
}