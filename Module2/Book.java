package Module2;

import java.io.Serializable;

public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    private final int id;
    private final String name;
    private final int year;
    private final int pagesCount;

    public Book(int id, String name, int year, int pagesCount) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.pagesCount = pagesCount;
    }

    public int getYear() {
        return year;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {

        return String.format("%d: %s (%d) %d pages",
                id, name, year, pagesCount);
    }
}
