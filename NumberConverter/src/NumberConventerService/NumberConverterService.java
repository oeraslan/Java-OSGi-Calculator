package NumberConventerService;

import java.util.Locale;
import java.util.Map;

public interface NumberConverterService {

	String getKey(Map<String, Integer> numbers, int number);

	int convertToNumber(String input, Locale locale); 

	String convertToString(int number, Locale locale) ;

	String convertLessThan1000(int number, Locale locale) ;

	String convertLessThan100(int number, Locale locale) ;
}
