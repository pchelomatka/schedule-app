package main.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"number", "name", "lecturer", "classroom"})
@Data
public class Pair {

    @JsonProperty("number")
    private Integer number;
    @JsonProperty("name")
    private String name;
    @JsonProperty("lecturer")
    private String lecturer;
    @JsonProperty("classroom")
    private String classroom;
}