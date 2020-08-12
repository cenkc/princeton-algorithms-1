package com.cenkc.courses.princetonalgorithms1.binarysearchtrees.alt;

/**
 * created by cenkc on 7/28/2020
 */
public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value == this.data) {
            // duplicates not allowed
            return;
        }

        if (value < this.data) {
            if (leftChild == null) {
                leftChild = new TreeNode(value);
            } else {
                leftChild.insert(value);
            }
        } else {
            if (rightChild == null) {
                rightChild = new TreeNode(value);
            } else {
                rightChild.insert(value);
            }
        }
    }

    public TreeNode get(int value) {
        if (value == data) {
            return this;
        }

        if (value < data) {
            if (leftChild != null) {
                return leftChild.get(value);
            }
        } else {
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }
        return null;
    }

    public int min() {
        if (leftChild == null) {
            return data;
        } else {
            return leftChild.min();
        }
    }

    public int max() {
        if (rightChild == null) {
            return data;
        } else {
            return rightChild.max();
        }
    }

    /**
     * In-Order     ->  L-N-R (L='L'eft, N=Root 'N'ode, R='R'ight)
     *                  It's also DFS, Depth-First Search
     *                  visit left child, then root, then right child
     *                  ( If we traverse a BST, we get the tree data sorted !!!!!!
     *                      -> visit the left child
     *                      -> visit the root
     *                      -> visit the right child )
     */
    public void traverseInOrder() {
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }
        System.out.print(this.data + " ");
        if (rightChild != null) {
            rightChild.traverseInOrder();
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
        System.out.print(this.data + " ");  // 'N' Access the data part of the current node
        if (leftChild != null) {
            leftChild.traversePreOrder();   // 'L' Traverse the left subtree
        }
        if (rightChild != null) {
            rightChild.traversePreOrder();  // Traverse the right subtree
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
        if (leftChild != null) {
            leftChild.traversePostOrder();
        }
        if (rightChild != null) {
            rightChild.traversePostOrder();
        }
        System.out.print(this.data + " "); // Access the data part of the current node
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
