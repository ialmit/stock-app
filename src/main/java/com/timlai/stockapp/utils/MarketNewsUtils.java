package com.timlai.stockapp.utils;

import com.timlai.stockapp.DTO.MarketNewsDTO;
import com.timlai.stockapp.service.MarketNewsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class MarketNewsUtils {

    private List<MarketNewsDTO> originalList;

    private Random random;

    public MarketNewsUtils() {
        this.random = new Random();
    }

    public List<MarketNewsDTO> getRandomNewsStoriesToDisplay(MarketNewsDTO[] marketNewsDTOS, int numberOfStoriesToDisplay) {
        originalList = new ArrayList<>(Arrays.asList(marketNewsDTOS));

        List<MarketNewsDTO> listToDisplay = new ArrayList<>();

        for (int i = 0; i < numberOfStoriesToDisplay; i++) {
            int randomNumber = random.nextInt(originalList.size());
            MarketNewsDTO storyToAddToList = originalList.get(randomNumber);
            originalList.remove(storyToAddToList);

            listToDisplay.add(storyToAddToList);
        }

        if(this.originalList.size() < 5){
            this.originalList = new ArrayList<>(Arrays.asList(marketNewsDTOS));
        }

        return listToDisplay;
    }
}
