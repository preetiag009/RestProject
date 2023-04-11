package package1;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "count", "entries" })

public class ApiResponsePojo2 {

	@JsonProperty("count")
	private Integer count;
	@JsonProperty("entries")
	private ApiResponsePojo2Details[] entries;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("count")
	public Integer getCount() {
		return count;
	}

	@JsonProperty("count")
	public void setCount(Integer count) {
		this.count = count;
	}

	@JsonProperty("entries")
	public ApiResponsePojo2Details[] getEntries() {
		return entries;
	}

	@JsonProperty("entries")
	public void setEntries(ApiResponsePojo2Details[] entries) {
		this.entries = entries;
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
