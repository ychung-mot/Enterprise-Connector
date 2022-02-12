package org.moti.ecp;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;

//private List<Double> coordinates = new ArrayList<Double>();

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"type",
"coordinates"
})
@Generated("jsonschema2pojo")
public class Geography {

@JsonProperty("type")
public String type;
@JsonProperty("coordinates")
public List<Object> coordinates = null;

}




