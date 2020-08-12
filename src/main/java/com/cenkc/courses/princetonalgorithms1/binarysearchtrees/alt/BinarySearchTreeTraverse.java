package com.cenkc.courses.princetonalgorithms1.binarysearchtrees.alt;

/**
 * created by cenkc on 7/28/2020
 */
public class BinarySearchTreeTraverse {

    /**
     * For visualization :
     * https://www.cs.usfca.edu/~galles/visualization/BST.html
     * @param args
     */

    public static void main(String[] args) {
        Tree intTree = new Tree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);

        /**
         * Traversal
         *
         * Level        -> visit nodes on each level
         *                  ( isn't used very often. Visit nodes on each level in order
         *                      -> visit root
         *                      -> visit the nodes at level one going from left to right
         *                      -> visit the nodes at level one going from left to right...)
         * In-Order     -> ( L-N-R )
         *                  visit left child, then root, then right child
         *                  ( If we traverse a BST, we get the tree data sorted !!!!!!
         *                      -> visit the left child
         *                      -> visit the root
         *                      -> visit the right child )
         * Pre-Order    -> ( N-L-R )
         *                  visit the root of every subtree FIRST
         *                  (
         *                      -> visit root
         *                      -> visit root of the left subtree
         *                      -> visit root of its left subtree ...
         *                      -> down to the first leaf
         *                      -> visit the leaves of each subtree working back up the tree)
         * Post-Order   -> ( L-R-N )
         *                  visit the root of every subtree LAST
         *                  ( instead of starting at the root,
         *                  we travel all the way down to the first leaf
         *                  and that's where we start our traversal)
         *
         */

        // Level Order = 25, 20, 27, 15, 22, 26, 30, 29, 32


        // 15, 20, 22, 25, 26, 27, 29, 30, 32
        System.out.print("Traverse Mode: InOrder -> ");
        intTree.traverseInOrder();
        System.out.println();

        // 25, 20, 15, 22, 27, 26, 30, 29, 32
        System.out.print("Traverse Mode: PreOrder -> ");
        intTree.traversePreOrder();
        System.out.println();

        // 15, 22, 20, 26, 29, 32, 30, 27, 25
        System.out.print("Traverse Mode: PostOrder -> ");
        intTree.traversePostOrder();
        System.out.println();

        //System.out.println("***************************************");
        //intTree.nonRecursiveInOrder();

        System.out.println("***************************************");
        System.out.println(intTree.get(26).getData());
        System.out.println(intTree.get(30).getData());
//        System.out.println(intTree.get(444).getData());
        System.out.println("***************************************");
        System.out.println(intTree.min());
        System.out.println(intTree.max());
        System.out.println("***************************************");
    }


}
