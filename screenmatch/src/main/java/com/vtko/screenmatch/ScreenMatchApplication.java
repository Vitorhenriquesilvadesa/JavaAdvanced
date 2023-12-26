package com.vtko.screenmatch;

import com.vtko.screenmatch.core.Menu;
import com.vtko.screenmatch.model.Episode;
import com.vtko.screenmatch.model.Season;
import com.vtko.screenmatch.model.Series;
import com.vtko.screenmatch.service.APIConsumer;
import com.vtko.screenmatch.service.DataConverter;
import com.vtko.screenmatch.service.DataConverterI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenMatchApplication.class, args);
    }

    @Override
    public void run(String... args) {
        new Menu().showMenu();
    }
}
