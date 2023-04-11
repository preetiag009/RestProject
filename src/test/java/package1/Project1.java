package package1;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Project1 {

	Response response;

	@BeforeMethod
	public void baseUri() {
		response = RestAssured.given().when().get("https://api.wazirx.com/sapi/v1/tickers/24hr");
	}

	@Test
	public void testStatusCode() {
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test
	public void testResponseTime() {
		Assert.assertTrue(response.getTime() < 5000);
	}

	@Test
	public void testResponseFormat() {
		Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
	}

	@Test
	public void testSymbolData() {
		List<String> symbols = response.jsonPath().getList("symbol");
		Assert.assertTrue(symbols.containsAll(Arrays.asList("btcusdt", "ethusdt", "dogeusdt", "adausdt", "xrpusdt")));
	}

	@Test
	public void testBaseAssetData() {
		List<String> baseAssets = response.jsonPath().getList("baseAsset");
		Assert.assertTrue(baseAssets.containsAll(Arrays.asList("btc", "eth", "doge", "ada", "xrp")));
	}

	@Test
	public void testSymbolsWithOpenPriceLessThanLowPrice() {
		List<String> symbols = response.jsonPath().getList("findAll { it.openPrice < it.lowPrice }.symbol");
		Iterator<String> it = symbols.iterator();
		System.out.println("All symbols whose open price is less than low price:");
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(symbols.containsAll(Arrays.asList("btcinr", "bchinr", "stxinr", "xmrusdt", "compusdt",
				"ksmusdt", "injusdt", "ethwrx", "yfiwrx", "ltcwrx", "yfiiwrx")));
		//Data is changing frequently
		softAssert.assertAll();
	}

	@Test
	public void symbolsAndBaseAssetsWithVolumeMoreThanAvgVolume1() {

		Double totalVolume = 0.0, averageVolume = 0.0;
		ApiResponsePojo1[] responsePojo = response.as(ApiResponsePojo1[].class);
		for (ApiResponsePojo1 i : responsePojo) {
			totalVolume = totalVolume + Double.parseDouble(i.getVolume());
		}
		averageVolume = totalVolume / responsePojo.length;
		for (ApiResponsePojo1 i : responsePojo) {
			if (Double.parseDouble(i.getVolume()) > averageVolume) {
				System.out.println(i.getBaseAsset() + "  " + i.getSymbol());
			}
		}
	}

	@Test
	public void findFiveAssetsWithLeastDifferenceBetweenBidAndAskPrice() {

		ApiResponsePojo1[] responsePojo = response.as(ApiResponsePojo1[].class);

		TreeSet<String> diff = new TreeSet<String>();
		for (ApiResponsePojo1 i : responsePojo) {
			Double ele = (Double.parseDouble(i.getAskPrice()) - Double.parseDouble(i.getBidPrice()));
			DecimalFormat df = new DecimalFormat("#.##");
			diff.add(df.format(ele));
		}
		int n = 0;
		Iterator<String> it = diff.iterator();
		while (it.hasNext() && n < 5) {
			System.out.println("Diff between Bid price and Ask Price: " + it.next());
			n++;
		}
	}
	

}
