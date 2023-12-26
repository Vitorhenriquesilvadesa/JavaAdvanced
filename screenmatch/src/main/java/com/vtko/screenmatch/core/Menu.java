package com.vtko.screenmatch.core;

import com.vtko.screenmatch.model.Season;
import com.vtko.screenmatch.model.Series;
import com.vtko.screenmatch.service.APIConsumer;
import com.vtko.screenmatch.service.DataConverter;
import com.vtko.screenmatch.service.DataConverterI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    private final String API_ADDRESS = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "6585022c";

    APIConsumer apiConsumer = new APIConsumer();
    DataConverterI dataConverter = new DataConverter();

    public void showMenu() {
        System.out.print("Insert the series name\n>>> ");
        String seriesName = scanner.nextLine().replaceAll(" ", "+");
        String address = API_ADDRESS + seriesName + "&apikey=" + API_KEY;
        getSeriesData(address);
    }

    public void getSeriesData(String uri) {
        String json = apiConsumer.getData(uri);
        Series series = dataConverter.fromJSON(json, Series.class);
        List<Season> seasons = getSeriesSeasons(series);
        seasons.forEach(System.out::println);
    }

    public List<Season> getSeriesSeasons(Series series) {
        String json;
        String uri;
        List<Season> seasons = new ArrayList<>();

        for (int i = 1; i <= series.totalSeasons(); i++) {
            uri = API_ADDRESS + series.title().replaceAll(" ", "+") + "&season=" + i + "&apikey=" + API_KEY;
            json = apiConsumer.getData(uri);
            Season season = dataConverter.fromJSON(json, Season.class);
            seasons.add(season);
        }

        return seasons;
    }
}
