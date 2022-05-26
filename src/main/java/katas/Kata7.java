package katas;


import com.google.common.collect.ImmutableMap;
import model.MovieList;
import util.DataUtil;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
               return  movieLists.stream()
                .flatMap(videos-> videos.getVideos().stream()
                        .map(item-> ImmutableMap.of("id",item.getId(),"title", item.getTitle(), "boxart",item.getBoxarts()
                                .stream()
                                .reduce((itemA,itemB) -> itemA.getWidth() * itemA.getHeight() < itemB.getWidth() * itemB.getHeight() ? itemA:itemB)
                                .map(itemC-> ImmutableMap.of("boxart",itemC.getUrl())))))
                       .collect(Collectors.toList());
    }
}
