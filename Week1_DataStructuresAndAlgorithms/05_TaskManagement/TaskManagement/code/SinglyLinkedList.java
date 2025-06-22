
public class SinglyLinkedList{
    private SNode head;

    public void addTask(Task task){
        SNode newNode = new SNode(task);
        if(head == null){
            head = newNode;
        }else{
            SNode current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(int id) {
        SNode current = head;
        while (current != null) {
            if (current.data.getTaskId() == id) return current.data;
            current = current.next;
        }
        return null;
    }

    public void deleteTask(int id){

        if(head == null) return;

        if(head.data.getTaskId() == id){
            head = head.next;
            return;
        }

        SNode current = head;
        while(current.next != null && current.next.data.getTaskId() != id){
            current = current.next;
            if(current.next != null){
                current.next = current.next.next;
            }
        }
    }

    public void traverse(){
        SNode current = head;
        while(current != null){
            current.data.display();
            current = current.next;
        }
    }
}
