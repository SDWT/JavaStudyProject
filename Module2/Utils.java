package Module2;

import java.io.EOFException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public final class Utils {

    public static List<Book> getBooks() {
        return List.of(
                new Book(1, "Project Ave Maria", 2021, 576),
                new Book(2, "Martianin", 2011, 480),
                new Book(3, "The Da Vinci Code", 2003, 544),
                new Book(4, "Starship Troopers", 1959, 352),
                new Book(5, "Dune", 1965, 640),
                new Book(6, "Foundation", 1951, 255),
                new Book(7, "Hyperion", 1989, 482),
                new Book(8, "The Hitchhiker’s Guide to the Galaxy", 1979, 224),
                new Book(9, "Ender's Game", 1985, 324),
                new Book(10, "Snow Crash", 1992, 480),
                new Book(11, "Do Androids Dream of Electric Sheep?", 1968, 210),
                new Book(12, "Ready Player One", 2011, 374),
                new Book(13, "Neuromancer", 1984, 271),
                new Book(14, "The Three-Body Problem", 2006, 302),
                new Book(15, "Altered Carbon", 2002, 375));
    }

    private static Student createStudent(int id, String name, String surname,
            List<Book> books, Random random) {

        HashSet<Book> selected = new HashSet<>();
        int targetSize = 5 + random.nextInt(3);

        while (selected.size() < targetSize) {
            selected.add(books.get(random.nextInt(books.size())));
        }

        return new Student(id, name, surname, new ArrayList<>(selected));
    }

    public static List<Student> generateStudents() {
        List<Book> books = getBooks();
        // Random random = new Random();
        Random random = new Random(30);

        return List.of(
                createStudent(1, "Ivan", "Ivanov", books, random),
                createStudent(2, "Petr", "Petrov", books, random),
                createStudent(3, "Sidr", "Sidorov", books, random),
                createStudent(4, "Kot", "Kotov", books, random),
                createStudent(5, "Vin", "Diesel", books, random));
    }

    public static boolean writeStudentsToFile(String filename, List<Student> students) {
        Path path = Path.of(filename);

        try {
            Files.write(
                    path,
                    students.stream()
                            .map(Student::toTSVString)
                            .collect(Collectors.toUnmodifiableList()));
        } catch (IOException e) {
            System.err.println("IOException: Can't work with students.tsv file.");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static List<Student> readStudentsFromFile(String filename) {
        Path path = Path.of(filename);

        if (!Files.exists(path))
            return List.of();

        try {
            return Files.lines(path)
                    .map(line -> {
                        try {
                            return Student.fromTSVString(line);
                        } catch (EOFException e) {
                            throw new RuntimeException("Invalid line: " + line, e);
                        }
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read students file", e);
        }
    }
}
