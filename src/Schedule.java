import java.util.ArrayList;

public class Schedule {
    private ArrayList<Movie> movies;

    @Override
    public String toString() {
        return "Schedule{" +
                "movies=" + movies +
                '}';
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
}
