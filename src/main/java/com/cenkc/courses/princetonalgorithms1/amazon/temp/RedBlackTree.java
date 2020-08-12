package com.cenkc.courses.princetonalgorithms1.amazon.temp;

/**
 * created by cenkc on 8/1/2020
 */
/*
public class RedBlackTree<K, V> implements RedBlackI<K, V>{
    Node<K, V> root;
    int size;

    class Node<K, V> {
        K key;
        V value;
        Node<K, V> left, right, parent;
        boolean isLeftChild, black;
        public Node (K key, V value) {
            this.key = key;
            this.value = value;
            left = right = parent = null;
            black = false; // Rule # 3 : New insertions are always red
            isLeftChild = false;
        }
    }

    public void add(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        if (root == null) {
            root = node;
            root.black = true; // Rule # 2 : The root is always black
            size++;
            return;
        }
        add(root, node);
    }

    private void add(Node<K, V> parent, Node<K, V> newNode) {
        if (((Comparable<K>) newNode.key).compareTo(parent.key) > 0 ) {
            if (parent.right == null) {
                parent.right = newNode;
                newNode.parent = parent;
                newNode.isLeftChild = false;
            }
            add(parent.right, newNode);
        }
        if (((Comparable<K>) newNode.key).compareTo(parent.key) < 0 ) {
            if (parent.left == null) {
                parent.left = newNode;
                newNode.parent = parent;
                newNode.isLeftChild = true;
            }
            add(parent.left, newNode);
            checkColor(newNode);
        }
    }
}
*/