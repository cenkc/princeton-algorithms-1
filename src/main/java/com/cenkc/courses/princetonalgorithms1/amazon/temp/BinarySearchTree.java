package com.cenkc.courses.princetonalgorithms1.amazon.temp;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

/**
 * https://algorithmsandme.com/category/data-structures/binary-search-tree/
 * https://www.techiedelight.com/
 * https://www.geeksforgeeks.org/
 * https://www.codesdope.com/blog/article/binary-search-tree-in-java/
 *
 *
 * created by cenkc on 7/29/2020
 */
public class BinarySearchTree {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int value) {
            this.data = value;
//            this.left = null;
//            this.right = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    //

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) return new Node(value);
        if (value < node.data) {
            node.left = insert(node.left, value);
        } else if (value > node.data) {
            node.right = insert(node.right, value);
        } else {
            node.data = value;
        }
        return node;
    }

/*
    public Node recursiveInsert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = recursiveInsert(root.left, value);
        } else {
            root.right = recursiveInsert(root.right, value);
        }
        return root;
    }

    public Node iterativeInsert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        Node currentNode = root;
        Node parentNode = null;

        while (currentNode != null) {
            parentNode = currentNode;
            if (value < currentNode.data) {
                currentNode = currentNode.left;
            } else { // value >= currentNode.data
                currentNode = currentNode.right;
            }
        }

        if (value < parentNode.data) {
            parentNode.left = new Node(value);
        } else { // value >= parentNode.data
            parentNode.right = new Node(value);
        }

        return root;
    }
*/

    public Node search(int value) {
        return search(root, value);
    }

    private Node search(Node node, int value) {
//        if (node == null) return null;
//        if (node.data == value) {
//            return node;
//        }
        if (node == null || node.data == value) {
            return node;
        } else if (value < node.data) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    public Node delete(Node node, int value) {
        if (node == null) return null;

        if (value < node.data) {
            node.left = delete(node.left, value);
        } else if (value > node.data) {
            node.right = delete(node.right, value);
        } else {
            if (node.left == null && node.right == null) { // no child
                node = null; //??
                return null;
            } else if (node.left == null || node.right == null) { // one child
                Node temp;
                if (node.left == null) {
                    temp = node.right;
                } else {
                    temp = node.left;
                }
                node = null;
                return temp;
            } else { // two childe
                Node temp = min(node.right);
                node.data = temp.data;
                node.right = delete(node.right, temp.data);
            }
        }
        return node;
    }

    public int min() {
//        Node currentNode = root;
//        while (currentNode.left != null) {
//            currentNode = currentNode.left;
//        }
//        return currentNode.data;
        if (root == null) {
            throw new NoSuchElementException("BST is null");
        }
        return min(root).data;
    }
    public Node min(Node root) {
        if (root == null) {
            return root;
        } else {
            return min(root.left);
        }
    }

    public int maxValue(Node root) {
        Node currentNode = root;
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode.data;
    }

    public void recursiveTraverseInOrder(Node root) {
        if (root == null) return;

        recursiveTraverseInOrder(root.left);
        System.out.print(root.data + " ");
        recursiveTraverseInOrder(root.right);
    }
    public void recursiveTraversePreOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        recursiveTraversePreOrder(root.left);
        recursiveTraversePreOrder(root.right);
    }
    public void recursiveTraversePostOrder(Node root) {
        if (root == null) return;

        recursiveTraversePostOrder(root.left);
        recursiveTraversePostOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void iterativeTraverseInOrder(Node root) {
        if (root == null) return;

        Stack<Node> s = new Stack<>();
        Node currentNode = root;

        while ( ! s.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.left;
            } else {
                currentNode = s.pop();
                System.out.print(currentNode.data + " ");

                currentNode = currentNode.right;
            }
        }
    }
    public void iterativeTraversePreOrder(Node root) {
        if (root == null) return;

        Stack<Node> s = new Stack<>();
        s.push(root);

        while ( ! s.isEmpty()) {
            final Node currentNode = s.pop();
            System.out.print(currentNode.data + " ");

            // as opposed to the recursive implementation,
            // we're pushing the right child first
            // so that the left child processed first (FIFO)
            if (currentNode.right != null) {
                s.push(currentNode.right);
            }
            if (currentNode.left != null) {
                s.push(currentNode.left);
            }
        }
    }
    public void iterativeTraversePostOrder(Node root) {
        if (root == null) return;

        Stack<Node> s = new Stack<>();
        Stack<Node> out = new Stack<>();
        s.push(root);

        while ( ! s.isEmpty()) {
            final Node currentNode = s.pop();

            out.push(currentNode);
            if (currentNode.left != null) {
                s.push(currentNode.left);
            }
            if (currentNode.right != null) {
                s.push(currentNode.right);
            }
        }
        while ( ! out.isEmpty()) {
            final Node outNode = out.pop();
            System.out.print(outNode.data + " ");
        }
    }

    public void levelOrder(Node root) {
        //Double.MAX_VALUE
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while ( ! q.isEmpty()) {
            final Node node = q.remove();
            System.out.print(node.data + " ");
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }

    }

    public static void main(String[] args) {
        //Node root = null;
        BinarySearchTree bst = new BinarySearchTree();
        int[] numbers = {25, 20, 15, 27, 30, 29, 26, 22, 32};
        for(int num : numbers) {
            //root = bst.recursiveInsert(root, num);
            //root = bst.iterativeInsert(root, num);
            bst.insert(num);
        }

/*
                  25
                 /   \
              20       27
              / \      / \
            15   22  26   30
                          / \
                        29   32
 */


        System.out.println("insertion (recursive) done");

        // 15 20 22 25 26 27 29 30 32
        System.out.print("BST Traverse InOrder (recursive)\t-> ");
        bst.recursiveTraverseInOrder(bst.root);
        System.out.println();
        // 15 20 22 25 26 27 29 30 32
        System.out.print("BST Traverse InOrder (iterative)\t-> ");
        bst.iterativeTraverseInOrder(bst.root);
        System.out.println();

        System.out.println("************************************************************");

        // 25 20 15 22 27 26 30 29 32
        System.out.print("BST Traverse PreOrder (recursive)\t-> ");
        bst.recursiveTraversePreOrder(bst.root);
        System.out.println();
        // 25 20 15 22 27 26 30 29 32
        System.out.print("BST Traverse PreOrder (iterative)\t-> ");
        bst.iterativeTraversePreOrder(bst.root);
        System.out.println();

        System.out.println("************************************************************");

        // 15 22 20 26 29 32 30 27 25
        System.out.print("BST Traverse PostOrder (recursive)\t-> ");
        bst.recursiveTraversePostOrder(bst.root);
        System.out.println();
        // 15 22 20 26 29 32 30 27 25
        System.out.print("BST Traverse PostOrder (iterative)\t-> ");
        bst.iterativeTraversePostOrder(bst.root);
        System.out.println();

        System.out.println("************************************************************");
        System.out.print("BST Traverse LevelOrder (iterative)\t-> ");
        bst.levelOrder(bst.root);
        System.out.println();
        System.out.println("************************************************************");

        final Node node = bst.search(bst.root, 29);
        System.out.println("found node:" + (node != null ? node.data : "null")
                + "(leftChild:" + (node != null && node.left != null ? node.left.data : "null")
                + ", rightChild:" + (node != null && node.right != null ? node.right.data : "null") + ")");

        System.out.println("************************************************************");
//        final int minValue = bst.min();
//        System.out.println("found minValue:" + minValue);
//        final Node minNode = bst.min(bst.root);
//        System.out.println("found minNode:" + minNode.data);

        System.out.println("************************************************************");
        final int max = bst.maxValue(bst.root);
        System.out.println("found max:" + max);
        System.out.println("************************************************************");
    }
}
