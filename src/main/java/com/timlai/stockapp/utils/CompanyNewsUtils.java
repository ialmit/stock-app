package com.timlai.stockapp.utils;

import com.timlai.stockapp.DTO.CompanyNewsDTO;
import com.timlai.stockapp.service.CompanyNewsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class CompanyNewsUtils {

    private List<CompanyNewsDTO> originalList;

    private Random random;

    public CompanyNewsUtils() {
        this.random = new Random();
    }

    public List<CompanyNewsDTO> getRandomNewsStoriesToDisplay(CompanyNewsDTO[] companyNewsDTOS, int numberOfStoriesToDisplay) {
        originalList = new ArrayList<>(Arrays.asList(companyNewsDTOS));

        List<CompanyNewsDTO> listToDisplay = new ArrayList<>();

        for (int i = 0; i < numberOfStoriesToDisplay; i++) {
            int randomNumber = random.nextInt(originalList.size());
            CompanyNewsDTO storyToAddToList = originalList.get(randomNumber);
            originalList.remove(storyToAddToList);

            listToDisplay.add(storyToAddToList);
        }

        if(this.originalList.size() < 5){
            this.originalList = new ArrayList<>(Arrays.asList(companyNewsDTOS));
        }

        return listToDisplay;
    }
}
