package com.cenkc.courses.princetonalgorithms1.amazon;

import java.util.List;

/**
 * created by cenkc on 8/12/2020
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
