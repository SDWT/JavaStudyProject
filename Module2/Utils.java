package Module2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
public final class Utils {

    public static List<Book> getBooks() {
        List<Book> books = new ArrayList<Book>();

        books.add(new Book(1, "Project Ave Maria", 2021, 576));
        books.add(new Book(2, "Martianin", 2011, 480));
        books.add(new Book(3, "The Da Vinci Code", 2003, 544));
        books.add(new Book(4, "Starship Troopers", 1959, 352));
        books.add(new Book(5, "Dune", 1965, 640));
        books.add(new Book(6, "Foundation", 1951, 255));
        books.add(new Book(7, "Hyperion", 1989, 482));
        books.add(new Book(8, "The Hitchhiker’s Guide to the Galaxy", 1979, 224));
        books.add(new Book(9, "Ender's Game", 1985, 324));
        books.add(new Book(10, "Snow Crash", 1992, 480));
        books.add(new Book(11, "Do Androids Dream of Electric Sheep?", 1968, 210));
        books.add(new Book(12, "Ready Player One", 2011, 374));
        books.add(new Book(13, "Neuromancer", 1984, 271));
        books.add(new Book(14, "The Three-Body Problem", 2006, 302));
        books.add(new Book(15, "Altered Carbon", 2002, 375));
        return books;
    }

    public static List<Student> generateStudents() {
        int n = 5;

        List<Student> students = new ArrayList<>(n);
        ArrayList<Book> books = new ArrayList<Book>(getBooks());

        students.add(new Student(1, "Ivan", "Ivanov"));
        students.add(new Student(2, "Petr", "Petrov"));
        students.add(new Student(3, "Sidr", "Sidorov"));
        students.add(new Student(4, "Kot", "Kotov"));
        students.add(new Student(5, "Vin", "Diesel"));

        Random random = new Random(30);

        // Бац — и 10 случайных чисел от 1 до 100 в массиве
        //int[] numbers = random.ints(n * 5, 0, books.size() - 1).toArray();

        HashSet<Book> personBooks = new HashSet<Book>();
        for (Student student : students) {

            while (personBooks.size() < 5 + random.nextInt(3)) {
                personBooks.add(books.get(random.nextInt(books.size())));
                //System.err.println(personBooks);
            }

            student.books.addAll(personBooks);
            personBooks.clear();
        }

        return students;
    }

    public static List<Student> readStudents(String filename) {
        List<Student> students = new ArrayList<>(10);

        return students;
    }
}
