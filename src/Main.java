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
        CinemaHall hall1 = new CinemaHall("Sala 1", 100,10,10);
        CinemaHall hall2 = new CinemaHall("Sala 2", 96,8,12);
        CinemaHall hall3 = new CinemaHall("Sala 3", 180,12,15);
        system.addCinemaHall(hall1);
        system.addCinemaHall(hall2);
        system.addCinemaHall(hall3);

        system.createAndShowGUI();
    }
}
