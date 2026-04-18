package Module2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/*
 * ✅⚠️❌
 * ✅1. Создать класс Student, обязательное поле класса Student - List<Book>
 * (минимум по 5 книг у каждого)
 * 
 * ✅2. Создать текстовый файл со студентами и книгами
 * 
 * ⚠️3. При помощи внутренних фреймворков и библиотек для ввода-вывода информации
 * в Java считать
 * содержимое файла и заполнить List<Student> этими данными
 * (Должен быть реализован механизм заполнения коллекции студентов из текстового
 * файла)
 * 
 * ❌4. При помощи одного (не допускается объявления никаких промежуточных
 * переменных, совсем никаких) стрима:
 * 
 * ⚠️- Вывести в консоль каждого студента (переопределите toString)
 * ✅- Получить для каждого студента список книг
 * ✅- Получить книги
 * ✅- Отсортировать книги по количеству страниц (Не забывайте про условия для
 * сравнения объектов)
 * ✅- Оставить только уникальные книги
 * ✅- Отфильтровать книги, оставив только те, которые были выпущены после 2000
 * года
 * ✅- Ограничить стрим на 3 элементах
 * ✅- Получить из книг годы выпуска
 * ❌- При помощи методов короткого замыкания (почитайте самостоятельно что это
 * такое) вернуть Optional от года
 * ❌- При помощи методов получения значения из Optional вывести в консоль год
 * выпуска найденной книги,
 * либо запись о том, что такая книга отсутствует
 */

public class Main {
    public static void main(String[] args) {

        String filename = "students.tsv";
        //List<Student> students = Utils.generateStudents();
        //Utils.writeStudentsToFile(filename, students);
        
        // Чтение студентов и преобразование в список
        List<Student> students = Utils.readStudentsFromFile(filename);

        for (Student student : students) {
            System.out.println(student.toTSVString());
        }

        var path = Path.of(filename);

        if (!Files.exists(path))
            System.out.println("File not found.");

        try (Stream<String> stream2 = Files.lines(Paths.get(filename))) {

            // Нужен stream от списка студентов, а не стрим из файла:
            Stream<Student> stream = stream2.map(Student::fromTSVString);      //

            //stream.forEach(System.out::println);    // ⚠️- Вывести в консоль каждого студента (переопределите toString)

            
            stream.map(st -> st.books)    // - Получить для каждого студента список книг
            .flatMap(List::stream)                  // - Получить книги
            .sorted(Comparator
                .comparingInt(Book::getPagesCount)) // - Отсортировать книги по количеству страниц
            .distinct()                             // - Оставить только уникальные книги
            .filter(b -> b.getYear() > 2000)        // - Отфильтровать книги, оставив только выпущеные после 2000 года
            .limit(3)                       // - Ограничить стрим на 3 элементах
            .map(b -> b.getYear())                  // - Получить из книг годы выпуска
            
            //.forEach(System.out::println);        
            ;
                                                    // - При помощи методов короткого замыкания вернуть Optional от года
                                                    // - При помощи методов получения значения из Optional
                                                    // вывести в консоль год выпуска найденной книги,
                                                    // либо запись о том, что такая книга отсутствует

        } catch (IOException e) {
            System.out.println("Can't open Students file.");
            e.printStackTrace();
        }


        // String[] strs = new String[10];
        // for (int i = 0; i < students.size(); i++) {
        // strs[i] = students.get(i).toTSVString();
        // }

        // for (int i = 0; i < students.size(); i++) {
        // try {

        // System.out.println(students.get(i)
        // .studentEquals(Student.fromTSVString(strs[i])));

        // } catch (IOException e) {
        // System.err.println("Неудалось распарсить студента. " + e.getMessage());
        // e.printStackTrace();
        // return;
        // }
        // }

        // try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new
        // FileOutputStream("students.txt"))) {

        // objectOutputStream.writeObject(students);

        // } catch (FileNotFoundException e) {
        // System.err.println("Students file not found. Application is close.");
        // e.printStackTrace();
        // return;
        // } catch (IOException e) {
        // System.err.println("Can't open Students file. Application is close.");
        // e.printStackTrace();
        // return;
        // }

    }

}
