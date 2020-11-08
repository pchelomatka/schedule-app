package main.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"group", "week"})
@Data
public class RequestScheduleGroup {

    @JsonProperty("group")
    private String group;
    @JsonProperty("week")
    private Integer week;
}
