package main.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"login", "password", "location"})
@Data
public class RequestAuth {

    @JsonProperty("login")
    private Integer login;
    @JsonProperty("password")
    private String password;
}