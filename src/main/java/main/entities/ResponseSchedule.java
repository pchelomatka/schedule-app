package main.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"1", "2"})
@Data
public class ResponseSchedule {

    @JsonProperty("1")
    private List<Day> firstWeek = null;
    @JsonProperty("2")
    private List<Day> secondWeek = null;
}