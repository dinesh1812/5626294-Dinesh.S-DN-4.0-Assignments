public class BookSearchTest {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        books[0] = new Book(1, "Java Basics", "Dinesh");
        books[1] = new Book(2, "Python 101", "Alice");
        books[2] = new Book(3, "Data Structures", "Bob");
        books[3] = new Book(4, "Algorithms", "Charlie");
        books[4] = new Book(5, "Machine Learning", "John");

        // Linear Search
        System.out.println("Linear Search for 'Python 101':");
        Book python = BookSearch.linearSearch(books, "Python 101");
        if (python != null) python.display();
        else System.out.println("Book not found");

        // Sort before binary search
        BookSearch.sortBooksByTitle(books);

        System.out.println("\nBinary Search for 'Java Basics':");
        Book java = BookSearch.binarySearch(books, "Java Basics");
        if (java != null) java.display();
        else System.out.println("Book Not found");
    }
}
