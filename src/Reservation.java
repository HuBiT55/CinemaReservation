public class Reservation {
    private Movie movie;
    private CinemaHall cinemaHall;
    private String date;
    private int row;
    private int seat;

    public Reservation(Movie movie, CinemaHall cinemaHall, String date, int selectedRow, int selectedSeat) {
        this.movie = movie;
        this.cinemaHall = cinemaHall;
        this.date = date;
    }

    public Movie getMovie() {
        return movie;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public String getDate() {
        return date;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}
