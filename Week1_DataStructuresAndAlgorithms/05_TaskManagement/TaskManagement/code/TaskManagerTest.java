public class TaskManagerTest {
    public static void main(String[] args) {
        // Singly Linked List Test
        System.out.println("===== Singly Linked List =====");
        SinglyLinkedList sll = new SinglyLinkedList();

        sll.addTask(new Task(1, "Task A", "Pending"));
        sll.addTask(new Task(2, "Task B", "Completed"));
        sll.addTask(new Task(3, "Task C", "Failed"));

        System.out.println("Traverse:");
        sll.traverse();

        System.out.println("\nSearch Task with ID 2:");
        Task found = sll.searchTask(2);
        if (found != null) found.display();

        System.out.println("\nDelete Task with ID 1");
        sll.deleteTask(1);

        System.out.println("\nAfter Deletion:");
        sll.traverse();

        // Doubly Linked List Test
        System.out.println("\n===== Doubly Linked List =====");
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.addTask(new Task(101, "Task X", "Pending"));
        dll.addTask(new Task(102, "Task Y", "Completed"));
        dll.addTask(new Task(103, "Task Z", "Pending"));

        System.out.println("Traverse Forward:");
        dll.traverseForward();

        System.out.println("\nTraverse Backward:");
        dll.traverseBackward();

        System.out.println("\nSearch Task with ID 102:");
        Task t = dll.searchTask(102);
        if (t != null) t.display();
        
        System.out.println("\nDelete Task with ID 101:");
        dll.deleteTask(101);

        System.out.println("\nAfter Deletion (Forward):");
        dll.traverseForward();
    }
}
