package Module2;


public class Book {

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

    public String toTSVString() {
        return String.format("%d\t%s\t%d\t%d",
                id, name, year, pagesCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id
            && name.equals(book.name)
            && year == book.year
            && pagesCount == book.pagesCount;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, name, year, pagesCount);
    }
}
