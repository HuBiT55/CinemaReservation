public class Reservation {
    private Movie movie;
    private CinemaHall cinemaHall;
    private String date;
    private int row;
    private int col;

    public Reservation(Movie movie, CinemaHall cinemaHall, String date) {
        this.movie = movie;
        this.cinemaHall = cinemaHall;
        this.date = date;
    }

    public Reservation(Movie movie, CinemaHall cinemaHall, String date, int row, int col) {
        this.movie = movie;
        this.cinemaHall = cinemaHall;
        this.date = date;
        this.row = row;
        this.col = col;
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

    public int getCol() {
        return col;
    }
}
