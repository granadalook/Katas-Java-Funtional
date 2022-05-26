package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;


public class Kata2 {
    public static List<Integer> execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies
                .stream()
                .filter(filtro -> filtro.getRating() == 5.0)
                .map(Movie::getId).collect(Collectors.toList());
    }
}
