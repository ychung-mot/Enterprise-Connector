
package org.moti.ecp.types;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "events",
    "pagination",
    "meta"
})
@Generated("jsonschema2pojo")
public class Open511Events {

    @JsonProperty("events")
    public List<Event> events = null;
    @JsonProperty("pagination")
    public Pagination pagination;
    @JsonProperty("meta")
    public Meta meta;

}
