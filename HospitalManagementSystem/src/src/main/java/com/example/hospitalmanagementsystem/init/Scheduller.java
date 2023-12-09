package com.example.hospitalmanagementsystem.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Scheduller {
    private Logger LOGGER = LoggerFactory.getLogger(Scheduller.class);

    @Scheduled(cron = "0 0 6 * * *")
    public void doInBackground() {
        LOGGER.info("Everything is done!");
        System.out.println(LocalDate.now());
    }
}
