package katas;


import model.Movie;
import util.DataUtil;
import java.util.List;



public class Kata5 {
    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();
        return movies.stream()
                .map(Movie::getRating)
                .reduce(Double.MIN_VALUE, Double::max);
    }
}
