public class WorkOrder implements Comparable{
    private  int priority;

    //Constructs a work order with a given priority and description.
    public WorkOrder(int aPriority) {
        priority = aPriority;
    }

    @Override
    public String toString() {
        return
                "priority=" + priority;
    }
    public int compareTo(Object otherObject){
        WorkOrder other = (WorkOrder) otherObject;
        if (priority < other.priority) return -1;
        if (priority > other.priority) return 1;
        return 0;
    }
}
