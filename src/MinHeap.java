import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Comparable> elements;
    //Constructs an empty heap.
    public MinHeap() {
        elements = new ArrayList<Comparable>();
        elements.add(null);
    }
        //Returns the index of the left child.
        private static int getLeftChildIndex(int index) {
            return 2 * index;
        }
        // Returns the index of the right child.
        private static int getRightChildIndex(int index) {
            return 2 * index + 1;
        }

        //Returns the index of the parent.
        private static int getParentIndex(int index) {
            return index / 2;
        }
        //Adds a new element to this heap
        public void add(Comparable newElement) {
            // Add a new leaf
            elements.add(null);
            int index = elements.size() - 1;

            // Demote parents that are larger than the new element
            while (index > 1 && getParent(index).compareTo(newElement) > 0) {
                elements.set(index, getParent(index));
                index = getParentIndex(index);
            }
            // Store the new element in the vacant slot
            elements.set(index, newElement);
        }
        //Gets the minimum element stored in this heap.
        public Comparable peek() {
            return elements.get(1);
        }
        // Removes the minimum element from this heap.
        public Comparable remove(){
            Comparable minimum = elements.get(1);
            // Remove last element
            int lastIndex = elements.size() - 1;
            Comparable last = elements.remove(lastIndex);
            if (lastIndex > 1) {
                elements.set(1, last);
                fixHeap();
            }
            return minimum;
        }
        //Turns the tree back into a heap, provided only the root
        private void fixHeap() {
            Comparable root = elements.get(1);
            int lastIndex = elements.size() - 1;

            // Promote children of removed root while they are smaller than last
            int index = 1;
            boolean more = true;
            while (more){
                int childIndex = getLeftChildIndex(index);
                if (childIndex <= lastIndex){
                    //get smaller child

                    //get left child first
                    Comparable child = getLeftChild(index);

                    // Use right child instead if it is smaller
                    if (getRightChildIndex(index) <= lastIndex
                            && getRightChild(index).compareTo(child) < 0) {
                        childIndex = getRightChildIndex(index);
                        child = getRightChild(index);
                    }
                    // Check if larger child is smaller than root
                    if (child.compareTo(root) < 0){
                        //promote child
                        elements.set(index, child);
                        index = childIndex;
                    }else{
                        // Root is smaller than both children
                        more = false;
                    }
                }else {
                    //no children
                    more = false;
                }
            }
            //store root element in vacant slot
        elements.set(index,root);
        }
        //returns the number of elements in this heap
        public int size(){
            return elements.size()-1;
        }
        //return the value of left child
        private Comparable getLeftChild(int index){
            return elements.get(2 * index);
        }

        //return the value of the right child
        private Comparable getRightChild (int index){
            return elements.get(2*index+1);
        }
        //return the value of the parent
        private Comparable getParent(int index){
            return elements.get(index/2);
        }
}
