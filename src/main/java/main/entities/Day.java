package main.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"weekday", "pairs"})
@Data
public class Day {

    @JsonProperty("weekday")
    private String weekday;
    @JsonProperty("pairs")
    private List<Pair> pairs = null;
}
