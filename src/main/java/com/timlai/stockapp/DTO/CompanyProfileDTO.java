package com.timlai.stockapp.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

//This represents the Company Profile that is returned from finnhub. This object will not be stored in the DB.

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@Component
public class CompanyProfileDTO {

    @JsonProperty("name")
    private String companyName;

    @JsonProperty("finnhubIndustry")
    private String industry;

    @JsonProperty("exchange")
    private String exchange;

}
