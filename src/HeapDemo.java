public class HeapDemo {
    public static void main(String[] args) {
        MinHeap q = new MinHeap();
        q.add(new WorkOrder(23));
        q.add(new WorkOrder(43));
        q.add(new WorkOrder(12));
        q.add(new WorkOrder(50));
        q.add(new WorkOrder(5));
        q.add(new WorkOrder(17));
        q.add(new WorkOrder(8));
        q.add(new WorkOrder(60));
        q.add(new WorkOrder(11));
        q.add(new WorkOrder(3));
        while (q.size()>0)
            System.out.println(q.remove());
    }
}
