public class CinemaHall {
    private String name;
    private int capacity;
    private int rows;

    public CinemaHall(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.rows = rows;
    }

    public CinemaHall(String name, int capacity, int i) {
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return name;
    }
}
