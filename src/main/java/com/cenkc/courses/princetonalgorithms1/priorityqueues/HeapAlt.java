package com.cenkc.courses.princetonalgorithms1.priorityqueues;

/**
 * Heap covered in https://www.udemy.com/course/data-structures-and-algorithms-deep-dive-using-java
 *
 * created by cenkc on 6/28/2020
 */
public class HeapAlt {

    private int[] heap;
    private int size;

    public static void main(String[] args) {
//        heap.insert(3);
//        heap.insert(4);
//        heap.insert(12);
//        heap.insert(14);
//        heap.insert(15);
//        heap.insert(18);
//        heap.insert(19);
//        heap.insert(22);

        HeapAlt heap = new HeapAlt(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);
        heap.printHeap(); // 80, 75, 60, 68, 55, 40, 52, 67

/*
        heap.delete(3); // delete 68
        heap.printHeap();

        heap.delete(0); // delete root (80)
        heap.printHeap();    // new root will be 75

        System.out.println(heap.peek()); // 75
*/
        heap.sort();
        heap.printHeap(); // 40, 52, 55, 60, 67, 68, 75, 80
    }

    public HeapAlt(int capacity) {
        heap = new int[capacity];
    }

    // assigning the value is constant time operation (O(1)),
    // but in the worst case, we may have to swap the new item
    // all the way up to the root and that would be 'log N' swaps
    // So the time complexity is O(log N)
    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }
        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        return heap[0];
    }

    // time complexity is O(log N)
    public int delete(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        int parent = getParent(index); // parent of the deleted item
        int deletedValue = heap[index]; // save deleted value to return

        //replace heap[index] with the value that's at the right-most pos. in the array
        heap[index] = heap[size - 1];

        // if the value at heap[index] is less than its parent, fix the heap below
        // if the value at heap[index] is greater than its parent, fix the heap above
        if (index == 0 || heap[index] < heap[parent]) {
            fixHeapBelow(index, size - 1);
        } else {
            fixHeapAbove(index);
        }

        // decrement the size
        size--;
        // return the deleted value
        return deletedValue;
    }

    // we're swapping N elements (O(N))
    // and on each iteration, we have to fix the heap (O(log N))
    // so the time complexity of sort is O(N log N)
    public void sort() {
        int lastHeapIndex = size - 1;
        for (int i = 0; i < lastHeapIndex; i++) {
            // swap the root with the last item
            int tmp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            heap[lastHeapIndex - i] = tmp;

            fixHeapBelow(0, lastHeapIndex - i - 1);
        }
    }

    private void fixHeapAbove(int index) {
        int newValue = heap[index];

        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newValue;
    }

    private void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;
        // compare the node at index with its two children, swap it, if necessary
        // if the value at heap[index] is less than either of its children,
        // swap it with the child that has the greatest value
        while (index <= lastHeapIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);

            if (leftChild <= lastHeapIndex) {
                // this node has a leftChild
                if (rightChild > lastHeapIndex) {
                    // node does not have a right child
                    // so just swap the left child
                    childToSwap = leftChild;
                } else {
                    // node has both left and right child
                    // so swap the greater one
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }
                // compare heap[index] with childToSwap
                if (heap[index] < heap[childToSwap]) {
                    int tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                } else {
                    break;
                }
                index = childToSwap;
            } else {
                break;
            }
        }
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getChild(int index, boolean left) {
        return 2 * index + (left ? 1 : 2);
    }

    public int getParent(int index) {
        // since we're doing integer division,
        // we don't need to explicitly call floor() method
        return (index - 1) / 2;
    }

    private void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + ", ");
        }
        System.out.println();
    }
}
