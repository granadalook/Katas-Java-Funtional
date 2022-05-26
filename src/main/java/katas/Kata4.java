package katas;

import com.google.common.collect.ImmutableMap;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        return movieLists.stream()
                .flatMap(videos -> videos.getVideos().stream())
                .map(item -> ImmutableMap.of("id", item.getId(), "title", item.getTitle(), "boxart", item.getBoxarts()))
                .collect(Collectors.toList());
    }
}
