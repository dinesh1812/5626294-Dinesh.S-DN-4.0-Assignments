public class DoublyLinkedList{
    private DNode head;

    public void addTask(Task task){
        DNode newNode = new DNode(task);
        if(head == null){
            head = newNode;
        }else{
            DNode current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public Task searchTask(int id){
        DNode current = head;
        while(current != null){
            if(current.data.getTaskId() == id){
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public void deleteTask(int id){
        DNode current = head;
        while (current != null && current.data.getTaskId() != id){
            current = current.next;
        }
        
        if (current == null) return;

        if (current.prev != null) current.prev.next = current.next;
        else head = current.next;

        if (current.next != null) current.next.prev = current.prev;
    }

    public void traverseForward() {
        DNode current = head;
        while (current != null) {
            current.data.display();
            current = current.next;
        }
    }

    public void traverseBackward(){
        DNode current = head;
        while(current != null && current.next != null){
            current = current.next;
        }
        while(current != null){
            current.data.display();
            current = current.prev;
        }
    }
}
