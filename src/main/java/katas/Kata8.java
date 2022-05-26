package katas;

import com.codepoetics.protonpack.StreamUtils;
import model.Bookmark;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;


public class Kata8 {
    public static List<Integer> execute() {
        List<Movie> movies = DataUtil.getMovies();
        List<Bookmark> bookMarks = DataUtil.getBookMarks();
        var data1 = movies.stream().map(pelicula -> pelicula.getId());
        var data2 = bookMarks.stream().map(bookmark -> bookmark.getId());
        var zipped = StreamUtils.zip(data1, data2, (a, b) -> a + b).collect(Collectors.toList());

        return zipped;
    }
}
