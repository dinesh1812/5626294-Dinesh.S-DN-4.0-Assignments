public class DNode {
    Task data;
    DNode prev , next;

    public DNode(Task data){
        this.data = data;
        this.prev = this.next = null;
    }
}

