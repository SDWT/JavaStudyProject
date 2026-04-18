package Module2;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

public class Student {

    private final int id;
    private String name;
    private String surname;

    List<Book> books;

    public Student(int id, String name, String surname, List<Book> books) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.books = books;
    }

    public Student(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.books = new ArrayList<Book>(10);
    }

    @Override
    public String toString() {
        StringBuffer strB = new StringBuffer();

        for (Book book : books) {
            strB.append(book);
            strB.append("; ");
        }

        if (strB.length() > 0) {
            strB.setLength(strB.length() - 2);
        }

        return String.format("%d: %s %s books: [%s]",
                id, name, surname, strB.toString());
    }

    public String toTSVString() {
        StringBuffer strB = new StringBuffer();

        for (Book book : books) {
            strB.append(book.toTSVString());
            strB.append("\t");
        }

        if (strB.length() > 0) {
            strB.setLength(strB.length() - 1);
        }

        return String.format("%d\t%s\t%s\t%d\t%s",
                id, name, surname, books.size(), strB.toString());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public static Student fromTSVString(String tsvStudent) throws EOFException {
        var studentStrs = tsvStudent.split("\t");
        // id name surname countBooks bookId bookName bookYear bookPages

        int shift = 4;
        int bookSize = 4;

        int id = Integer.parseInt(studentStrs[0]);
        int bookCnt = Integer.parseInt(studentStrs[3]);
        if (studentStrs.length - shift != bookCnt * bookSize) {
            throw new EOFException("Count of student books dont equal count of parameters.");
        }

        ArrayList<Book> books = new ArrayList<Book>(bookCnt);
        for (int i = 0; i < bookCnt; i++) {
            books.add(new Book(
                    Integer.parseInt(studentStrs[shift + bookSize * i + 0]), // id
                    studentStrs[shift + bookSize * i + 1], // name
                    Integer.parseInt(studentStrs[shift + bookSize * i + 2]), // year
                    Integer.parseInt(studentStrs[shift + bookSize * i + 3]))); // pages
        }

        return new Student(id, studentStrs[1], studentStrs[2], books);
    }

    public boolean studentEquals(Student student) {
        if (this == student)
            return true;
        if (student == null)
            return false;

        if (id != student.id
                || !name.equals(student.name)
                || !surname.equals(student.surname)
                || books.size() != student.books.size()) {
            return false;
        }

        for (int i = 0; i < books.size(); i++) {
            if (!books.get(i).equals(student.books.get(i))) {
                return false;
            }
        }

        return true;
    }
}
