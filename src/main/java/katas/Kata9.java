package katas;

import com.google.common.collect.ImmutableMap;
import model.MovieList;
import util.DataUtil;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .flatMap(videos -> videos.getVideos().stream()
                        .map(video -> ImmutableMap.of("id", video.getId(), "title", video.getTitle(), "time", video.getInterestingMoments().stream()
                                .map(tiempo -> tiempo.getTime()).collect(Collectors.toList()), "boxart", video.getBoxarts()
                                .stream().reduce((dataA, dataB) -> dataA.getWidth() * dataA.getHeight() < dataB.getWidth() * dataB.getHeight() ? dataA : dataB)
                                .map(urls -> ImmutableMap.of("boxart", urls.getUrl()))))).collect(Collectors.toList());
    }
}
