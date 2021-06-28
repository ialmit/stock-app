package com.timlai.stockapp.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@JsonIgnoreProperties
@Getter
@Setter
@ToString
@Component
public class CompanyNewsDTO {
    @JsonProperty("category")
    private String category;

    @JsonProperty("datetime")
    private Long datetime;

    @JsonProperty("headline")
    private String headline;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("image")
    private String image;

    @JsonProperty("related")
    private String related;

    @JsonProperty("source")
    private String source;

    @JsonProperty("summary")
    private String summary;

    @JsonProperty("url")
    private String url;

}
