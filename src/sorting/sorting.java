package sorting;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static java.util.Comparator.comparing;

public class sorting {

	public static void main(String[] args) {
		BigDecimal fundPercent = BigDecimal.ZERO;
		BigDecimal roboPercent = BigDecimal.ZERO;
		BigDecimal stockPercent = BigDecimal.ZERO;
		BigDecimal etfPercent = BigDecimal.ZERO;
		BigDecimal bondPercent = BigDecimal.ZERO;
		BigDecimal totalNum = new BigDecimal("191");
		BigDecimal percentage = new BigDecimal("100");
		Map<String, BigDecimal> dataMap = new HashMap<String, BigDecimal>();
		dataMap.put("fund", new BigDecimal("2000"));
		dataMap.put("robo", new BigDecimal("3000"));
		dataMap.put("stock", new BigDecimal("1000"));
		dataMap.put("etf", new BigDecimal("3000"));
		dataMap.put("bond", new BigDecimal("1000"));
		Stream<Map.Entry<String, BigDecimal>> sortMap = dataMap.entrySet().stream().sorted(Map.Entry.comparingByValue());
		sortMap.forEach(System.out::println);
		System.out.println("=========================================");
		List<invest> dataList = new ArrayList<>();
		dataList.add(new invest("fund", new BigDecimal("33")));
		dataList.add(new invest("robo", new BigDecimal("22")));
		dataList.add(new invest("stock", new BigDecimal("122")));
		dataList.add(new invest("etf", new BigDecimal("11")));
		dataList.add(new invest("bond", new BigDecimal("3")));
		dataList.sort(comparing(invest::getInvestNum).thenComparing(invest::getInvestName));
		dataList.forEach(s->System.out.println(s.getInvestName() + "=" + s.getInvestNum()));
		System.out.println("=========================================");
		for(int i = dataList.size() - 1; i > 0; i --) {
			switch (dataList.get(i).getInvestName()) {
			case "fund":
				fundPercent = dataList.get(i).getInvestNum().divide(totalNum, 2, BigDecimal.ROUND_HALF_UP).multiply(percentage);
				System.out.println("fund :" + fundPercent.toString() + "%");
				break;
			case "robo":
				roboPercent = dataList.get(i).getInvestNum().divide(totalNum, 2, BigDecimal.ROUND_HALF_UP).multiply(percentage);
				System.out.println("robo :" + roboPercent.toString() + "%");
				break;
			case "stock":
				stockPercent = dataList.get(i).getInvestNum().divide(totalNum, 2, BigDecimal.ROUND_HALF_UP).multiply(percentage);
				System.out.println("stock :" + stockPercent.toString() + "%");
				break;
			case "etf":
				etfPercent = dataList.get(i).getInvestNum().divide(totalNum, 2, BigDecimal.ROUND_HALF_UP).multiply(percentage);
				System.out.println("etf :" + etfPercent.toString() + "%");
				break;
			case "bond":
				bondPercent = dataList.get(i).getInvestNum().divide(totalNum, 2, BigDecimal.ROUND_HALF_UP).multiply(percentage);
				System.out.println("bond :" + bondPercent.toString() + "%");
				break;
			default:
				break;
			}
		}
		System.out.println(dataList.get(0).getInvestName() + " :" + percentage.subtract(fundPercent).subtract(roboPercent).subtract(stockPercent).subtract(etfPercent).subtract(bondPercent).toString() + "%");
	}
	
}
