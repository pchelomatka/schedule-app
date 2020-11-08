package main.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"specId", "course", "week"})
@Data
public class RequestScheduleSpeciality {

    @JsonProperty("specId")
    private Integer specId;
    @JsonProperty("course")
    private Integer course;
    @JsonProperty("week")
    private Integer week;
}
