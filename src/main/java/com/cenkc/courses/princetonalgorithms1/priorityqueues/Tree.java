package com.cenkc.courses.princetonalgorithms1.priorityqueues;

/**
 * created by cenkc on 7/12/2020
 */
public class Tree {

    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }
}
