public class Main {
    public static void main(String[] args) {
        CinemaReservationSystem system = new CinemaReservationSystem();

        // Dodaj filmy do systemu
        Movie movie1 = new Movie("Avengers: Endgame", "Akcja", 181);
        Movie movie2 = new Movie("Joker", "Dramat", 122);
        Movie movie3 = new Movie("Pulp Fiction", "Kryminał", 154);
        system.addMovie(movie1);
        system.addMovie(movie2);
        system.addMovie(movie3);

        // Dodaj sale kinowe do systemu
        CinemaHall hall1 = new CinemaHall("Sala A", 10);
        CinemaHall hall2 = new CinemaHall("Sala B", 8);
        CinemaHall hall3 = new CinemaHall("Sala C", 6);
        system.addCinemaHall(hall1);
        system.addCinemaHall(hall2);
        system.addCinemaHall(hall3);

        system.createAndShowGUI();
    }
}
