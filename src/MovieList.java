import java.util.ArrayList;
import java.util.List;

public class MovieList {
    private List<Movie> movies;

    public MovieList() {
        movies = new ArrayList<>();
        addMovies();
    }

    private void addMovies() {
        Movie movie1 = new Movie("Avengers: Endgame", "Akcja", 181);
        Movie movie2 = new Movie("Joker", "Dramat", 122);
        Movie movie3 = new Movie("Pulp Fiction", "Kryminał", 154);

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void addMovie(Movie akcja) {
    }
}
