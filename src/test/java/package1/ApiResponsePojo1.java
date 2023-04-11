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
@JsonPropertyOrder({ "symbol", "baseAsset", "quoteAsset", "openPrice", "lowPrice", "highPrice", "lastPrice", "volume",
		"bidPrice", "askPrice", "at" })

public class ApiResponsePojo1 {

	@JsonProperty("symbol")
	private String symbol;
	@JsonProperty("baseAsset")
	private String baseAsset;
	@JsonProperty("quoteAsset")
	private String quoteAsset;
	@JsonProperty("openPrice")
	private String openPrice;
	@JsonProperty("lowPrice")
	private String lowPrice;
	@JsonProperty("highPrice")
	private String highPrice;
	@JsonProperty("lastPrice")
	private String lastPrice;
	@JsonProperty("volume")
	private String volume;
	@JsonProperty("bidPrice")
	private String bidPrice;
	@JsonProperty("askPrice")
	private String askPrice;
	@JsonProperty("at")
	private Long at;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("symbol")
	public String getSymbol() {
		return symbol;
	}

	@JsonProperty("symbol")
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@JsonProperty("baseAsset")
	public String getBaseAsset() {
		return baseAsset;
	}

	@JsonProperty("baseAsset")
	public void setBaseAsset(String baseAsset) {
		this.baseAsset = baseAsset;
	}

	@JsonProperty("quoteAsset")
	public String getQuoteAsset() {
		return quoteAsset;
	}

	@JsonProperty("quoteAsset")
	public void setQuoteAsset(String quoteAsset) {
		this.quoteAsset = quoteAsset;
	}

	@JsonProperty("openPrice")
	public String getOpenPrice() {
		return openPrice;
	}

	@JsonProperty("openPrice")
	public void setOpenPrice(String openPrice) {
		this.openPrice = openPrice;
	}

	@JsonProperty("lowPrice")
	public String getLowPrice() {
		return lowPrice;
	}

	@JsonProperty("lowPrice")
	public void setLowPrice(String lowPrice) {
		this.lowPrice = lowPrice;
	}

	@JsonProperty("highPrice")
	public String getHighPrice() {
		return highPrice;
	}

	@JsonProperty("highPrice")
	public void setHighPrice(String highPrice) {
		this.highPrice = highPrice;
	}

	@JsonProperty("lastPrice")
	public String getLastPrice() {
		return lastPrice;
	}

	@JsonProperty("lastPrice")
	public void setLastPrice(String lastPrice) {
		this.lastPrice = lastPrice;
	}

	@JsonProperty("volume")
	public String getVolume() {
		return volume;
	}

	@JsonProperty("volume")
	public void setVolume(String volume) {
		this.volume = volume;
	}

	@JsonProperty("bidPrice")
	public String getBidPrice() {
		return bidPrice;
	}

	@JsonProperty("bidPrice")
	public void setBidPrice(String bidPrice) {
		this.bidPrice = bidPrice;
	}

	@JsonProperty("askPrice")
	public String getAskPrice() {
		return askPrice;
	}

	@JsonProperty("askPrice")
	public void setAskPrice(String askPrice) {
		this.askPrice = askPrice;
	}

	@JsonProperty("at")
	public Long getAt() {
		return at;
	}

	@JsonProperty("at")
	public void setAt(Long at) {
		this.at = at;
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
