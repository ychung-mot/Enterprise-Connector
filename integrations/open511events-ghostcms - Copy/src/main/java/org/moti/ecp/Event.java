
package org.moti.ecp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "jurisdiction_url",
    "url",
    "id",
    "headline",
    "status",
    "created",
    "updated",
    "description",
    "+ivr_message",
    "+linear_reference_km",
    "schedule",
    "event_type",
    "event_subtypes",
    "severity",
    "geography",
    "roads",
    "areas"
})
@Generated("jsonschema2pojo")
public class Event {

    @JsonProperty("jurisdiction_url")
    private String jurisdictionUrl;
    @JsonProperty("url")
    private String url;
    @JsonProperty("id")
    private String id;
    @JsonProperty("headline")
    private String headline;
    @JsonProperty("status")
    private String status;
    @JsonProperty("created")
    private String created;
    @JsonProperty("updated")
    private String updated;
    @JsonProperty("description")
    private String description;
    @JsonProperty("+ivr_message")
    private String ivrMessage;
    @JsonProperty("+linear_reference_km")
    private Double linearReferenceKm;
    @JsonProperty("schedule")
    private Schedule schedule;
    @JsonProperty("event_type")
    private String eventType;
    @JsonProperty("event_subtypes")
    private List<String> eventSubtypes = null;
    @JsonProperty("severity")
    private String severity;
    @JsonProperty("geography")
    private Geography geography;
    @JsonProperty("roads")
    private List<Road> roads = null;
    @JsonProperty("areas")
    private List<Area> areas = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("jurisdiction_url")
    public String getJurisdictionUrl() {
        return jurisdictionUrl;
    }

    @JsonProperty("jurisdiction_url")
    public void setJurisdictionUrl(String jurisdictionUrl) {
        this.jurisdictionUrl = jurisdictionUrl;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("headline")
    public String getHeadline() {
        return headline;
    }

    @JsonProperty("headline")
    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("updated")
    public String getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("+ivr_message")
    public String getIvrMessage() {
        return ivrMessage;
    }

    @JsonProperty("+ivr_message")
    public void setIvrMessage(String ivrMessage) {
        this.ivrMessage = ivrMessage;
    }

    @JsonProperty("+linear_reference_km")
    public Double getLinearReferenceKm() {
        return linearReferenceKm;
    }

    @JsonProperty("+linear_reference_km")
    public void setLinearReferenceKm(Double linearReferenceKm) {
        this.linearReferenceKm = linearReferenceKm;
    }

    @JsonProperty("schedule")
    public Schedule getSchedule() {
        return schedule;
    }

    @JsonProperty("schedule")
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @JsonProperty("event_type")
    public String getEventType() {
        return eventType;
    }

    @JsonProperty("event_type")
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @JsonProperty("event_subtypes")
    public List<String> getEventSubtypes() {
        return eventSubtypes;
    }

    @JsonProperty("event_subtypes")
    public void setEventSubtypes(List<String> eventSubtypes) {
        this.eventSubtypes = eventSubtypes;
    }

    @JsonProperty("severity")
    public String getSeverity() {
        return severity;
    }

    @JsonProperty("severity")
    public void setSeverity(String severity) {
        this.severity = severity;
    }

    @JsonProperty("geography")
    public Geography getGeography() {
        return geography;
    }

    @JsonProperty("geography")
    public void setGeography(Geography geography) {
        this.geography = geography;
    }

    @JsonProperty("roads")
    public List<Road> getRoads() {
        return roads;
    }

    @JsonProperty("roads")
    public void setRoads(List<Road> roads) {
        this.roads = roads;
    }

    @JsonProperty("areas")
    public List<Area> getAreas() {
        return areas;
    }

    @JsonProperty("areas")
    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
