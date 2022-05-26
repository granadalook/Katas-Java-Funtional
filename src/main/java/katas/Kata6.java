package katas;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream().flatMap(videos -> videos.getBoxarts().stream())
                .reduce((itemA, itemB) -> itemA.getWidth() * itemA.getHeight() > itemB.getWidth() * itemB.getHeight() ? itemA : itemB)
                .map(BoxArt::getUrl)
                .toString();
    }
}
