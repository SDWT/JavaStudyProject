package Module2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
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
        this.books = new ArrayList<Book>(5);
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

}
