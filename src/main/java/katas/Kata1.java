package katas;

import com.google.common.collect.ImmutableMap;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Kata1 {
    public static List<Map> execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies
                .stream()
                .map(peliculas -> ImmutableMap.of("id", peliculas.getId(), "title", peliculas.getTitle()))
                .collect(Collectors.toList());
    }
}
