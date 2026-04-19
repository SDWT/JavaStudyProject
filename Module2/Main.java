package Module2;

import java.util.Comparator;
import java.util.List;

/*
 * ✅⚠️❌
 * ⚠️ Пересоздать проекты Java в Module1 и Module2 
 */

public class Main {
    public static void main(String[] args) {

        String filename = "students.tsv";
        // List<Student> students = Utils.generateStudents();
        // Utils.writeStudentsToFile(filename, students);

        // Чтение студентов и преобразование в список
        List<Student> students = Utils.readStudentsFromFile(filename);

        students.stream()
                .peek(System.out::println)                  // - Вывести в консоль каждого студента (переопределите toString)
                .map(Student::getBooks)                     // - Получить для каждого студента список книг
                .flatMap(List::stream)                      // - Получить книги
                .sorted(Comparator
                        .comparingInt(Book::getPagesCount)) // - Отсортировать книги по количеству страниц
                .distinct()                                 // - Оставить только уникальные книги
                .filter(book -> book.getYear() > 2000)      // - Отфильтровать книги, оставив только выпущеные после 2000 года
                .limit(3)                           // - Ограничить стрим на 3 элементах
                .map(Book::getYear)                         // - Получить из книг годы выпуска

                .findFirst()                                // - При помощи методов короткого замыкания вернуть Optional от года

                // - При помощи методов получения значения из Optional вывести в консоль год
                // выпуска найденной книги,
                .ifPresentOrElse(year  -> System.out.println(String.format("Book year is %d", year)),
                        // либо запись о том, что такая книга отсутствует
                        () -> System.out.println("Book not found;"));

    }

}
