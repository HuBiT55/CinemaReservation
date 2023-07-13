public class CinemaHall {
    private String name;
    private int capacity;
    private int rows;
    private int seatsPerRow;

    public CinemaHall(String name, int capacity, int rows, int seatsPerRow) {
        this.name = name;
        this.capacity = capacity;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
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

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    @Override
    public String toString() {
        return name;
    }
}
