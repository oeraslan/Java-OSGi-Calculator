package NumberConventerService;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class NumberConverterServiceImpl implements NumberConverterService {

	private static final Map<String, Integer> turkishNumbers = new HashMap<>();
	private static final Map<String, Integer> englishNumbers = new HashMap<>();

	public NumberConverterServiceImpl() {
		turkishNumbers.put("sıfır", 0);
		turkishNumbers.put("bir", 1);
		turkishNumbers.put("iki", 2);
		turkishNumbers.put("üç", 3);
		turkishNumbers.put("dört", 4);
		turkishNumbers.put("beş", 5);
		turkishNumbers.put("altı", 6);
		turkishNumbers.put("yedi", 7);
		turkishNumbers.put("sekiz", 8);
		turkishNumbers.put("dokuz", 9);
		turkishNumbers.put("on", 10);
		turkishNumbers.put("yirmi", 20);
		turkishNumbers.put("otuz", 30);
		turkishNumbers.put("kırk", 40);
		turkishNumbers.put("elli", 50);
		turkishNumbers.put("altmış", 60);
		turkishNumbers.put("yetmiş", 70);
		turkishNumbers.put("seksen", 80);
		turkishNumbers.put("doksan", 90);
		turkishNumbers.put("yüz", 100);
		turkishNumbers.put("bin", 1000);

		englishNumbers.put("zero", 0);
		englishNumbers.put("one", 1);
		englishNumbers.put("a", 1);
		englishNumbers.put("two", 2);
		englishNumbers.put("three", 3);
		englishNumbers.put("four", 4);
		englishNumbers.put("five", 5);
		englishNumbers.put("six", 6);
		englishNumbers.put("seven", 7);
		englishNumbers.put("eight", 8);
		englishNumbers.put("nine", 9);
		englishNumbers.put("ten", 10);
		englishNumbers.put("eleven", 11);
		englishNumbers.put("twelve", 12);
		englishNumbers.put("thirteen", 13);
		englishNumbers.put("fourteen", 14);
		englishNumbers.put("fifteen", 15);
		englishNumbers.put("sixteen", 16);
		englishNumbers.put("seventeen", 17);
		englishNumbers.put("eighteen", 18);
		englishNumbers.put("nineteen", 19);
		englishNumbers.put("twenty", 20);
		englishNumbers.put("thirty", 30);
		englishNumbers.put("forty", 40);
		englishNumbers.put("fifty", 50);
		englishNumbers.put("sixty", 60);
		englishNumbers.put("seventy", 70);
		englishNumbers.put("eighty", 80);
		englishNumbers.put("ninety", 90);
		englishNumbers.put("hundred", 100);
		englishNumbers.put("thousand", 1000);

	}

	
	public  String getKey(Map<String, Integer> numbers, int number) {
		for (String word : numbers.keySet()) {
			if (numbers.get(word).equals(number)) {
				return word;
			}
		}
		return "Does not have a such number";
	}

	public  int convertToNumber(String input, Locale locale) {
		Locale en = new Locale("en", "EN");
		input = input.toLowerCase();
		Map<String, Integer> numberMap = turkishNumbers;
		if (locale.equals(en)) {
			numberMap = englishNumbers;
		}
		int result = 1;
		int current = 0;
		int last = 0;
		for (String s : input.split(" ")) {
			current = numberMap.getOrDefault(s, 0);
			if (current == 0) {
				return 0;
			}
			if (current > last) {
				result *= current;
			} else {
				result += current;
			}
			last = current;
		}
		return result;
	}

	public  String convertToString(int number, Locale locale) {
		Locale en = new Locale("en", "EN");
		Map<String, Integer> numberMap = turkishNumbers;
		if (locale.equals(en)) {
			numberMap = englishNumbers;
		}

		String word = "";
		if (number <= 0) {
			return getKey(numberMap, 0);
		}
		if (number < 11) {
			return getKey(numberMap, number);
		} else if (number < 21 && locale.equals(en)) {
			return getKey(numberMap, number);
		} else if (number > 10 && number < 100) {
			return convertLessThan100(number, locale);
		} else if (number > 99 && number < 1000) {
			return convertLessThan1000(number, locale);
		}
		int temp = number / 1000;
		int remain = number % 1000;

		if (temp > 100) {
			word += convertLessThan1000(temp, locale) + " " + getKey(numberMap, 1000) + " "
					+ convertLessThan1000(remain, locale);
		} else if (temp > 10) {
			word += convertLessThan100(temp, locale) + " " + getKey(numberMap, 1000) + " "
					+ convertLessThan1000(remain, locale);
		} else if (temp > 0) {
			word += convertToString(temp, locale) + " " + getKey(numberMap, 1000) + " "
					+ convertLessThan1000(remain, locale);
		}
		return word;
	}

	public  String convertLessThan1000(int number, Locale locale) {
		Locale en = new Locale("en", "EN");
		Map<String, Integer> numberMap = turkishNumbers;

		if (locale.equals(en)) {
			numberMap = englishNumbers;
		}

		if (number <= 0) {
			return "";
		}
		String word = "";

		int temp = number / 100;
		int remain = number % 100;

		if (temp > 1) {
			word += getKey(numberMap, temp) + " " + getKey(numberMap, 100);
			if (remain > 0) {
				word += " ";
			}
		} else {
			word += getKey(numberMap, 100);
		}
		word += convertLessThan100(remain, locale);

		return word;
	}

	public  String convertLessThan100(int number, Locale locale) {
		Locale en = new Locale("en", "EN");
		Map<String, Integer> numberMap = turkishNumbers;

		if (locale.equals(en)) {
			numberMap = englishNumbers;
		}

		if (number <= 0) {
			return "";
		}

		String word = "";

		int temp = number / 10;
		int remain = number % 10;

		if (temp > 0) {
			word += getKey(numberMap, temp * 10);
			if (remain > 0) {
				word += " ";
			}
		}

		if (remain > 0) {
			word += getKey(numberMap, remain);
		}

		return word;
	}
}
