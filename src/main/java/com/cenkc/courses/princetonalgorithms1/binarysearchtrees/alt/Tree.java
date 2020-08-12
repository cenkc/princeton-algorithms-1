package com.cenkc.courses.princetonalgorithms1.binarysearchtrees.alt;

import java.util.Stack;

/**
 * created by cenkc on 7/28/2020
 */
public class Tree {

    // if we have the root node, we can get everything else
    // by traversing its left and right child
    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }
        return null;
    }

    public int min() {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return root.min();
        }
    }

    public int max() {
        if (root == null) {
            return Integer.MAX_VALUE;
        } else {
            return root.max();
        }
    }

    /**
     * In-Order     -> ( L-N-R )
     *                  visit left child, then root, then right child
     *                  ( If we traverse a BST, we get the tree data sorted !!!!!!
     *                      -> visit the left child
     *                      -> visit the root
     *                      -> visit the right child )
     */
    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    /**
     * Pre-Order    ->  N-L-R  (N=Root 'N'ode, L='L'eft, R='R'ight)
     *                  visit the root of every subtree FIRST
     *                  (
     *                      -> visit root
     *                      -> visit root of the left subtree
     *                      -> visit root of its left subtree ...
     *                      -> down to the first leaf
     *                      -> visit the leaves of each subtree working back up the tree)
     */
    public void traversePreOrder() {
        if (root != null) {
            root.traversePreOrder();
        }
    }

    /**
     * Post-Order   ->  L-R-N (L='L'eft, R='R'ight, N=Root 'N'ode)
     *                  visit the root of every subtree LAST
     *                  ( instead of starting at the root,
     *                  we travel all the way down to the first leaf
     *                  and that's where we start our traversal)
     */
    public void traversePostOrder() {
        if (root != null) {
            root.traversePostOrder();
        }
    }

    public void nonRecursiveInOrder() {
        if (root != null) {
            Stack<TreeNode> s = new Stack<>();
            addLeftToStack(s, root); // first one would be the root
            while (!s.isEmpty()) {
                System.out.print(s.pop().getData() + " ");
                TreeNode curr = s.pop();
                System.out.println(curr.getData());
                if (curr.getRightChild() != null) {
                    addLeftToStack(s, curr.getRightChild());
                }
            }
        }
    }

    private void addLeftToStack(Stack<TreeNode> s, TreeNode node) {
        while (node != null) {
            s.push(node);
            node = node.getLeftChild();
        }
    }
}

