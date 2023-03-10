package common;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogicalFunctions {

    /**
     * <h1>Verify Strings</h1>
     * @param expString
     * @param actualString
     * @return boolean
     */
    public static boolean verifyStrings(String expString, String actualString) {
        if (actualString != null){
            if (expString.equals(actualString)){
                System.out.println("Expected String: " + expString + " and Actual String: " + actualString + " are identical as expected");
                return true;
            }else{
                System.out.println("Expected String: " + expString + " and Actual String: " + actualString + " Does NOT match. please check.");
                return false;
            }

        }
        System.out.println("Actual String is null. Please check.");
        return false;
    }

    /**
     * <h1>Verify String Contains</h1>
     * @param expPageTitle
     * @param actualPageTitle
     * @return boolean
     */
    public static boolean verifyStringContains(String expPageTitle, String actualPageTitle) {
        if (actualPageTitle!=null){
            if (actualPageTitle.contains(expPageTitle)){
                System.out.println("Title contains expected text.");
                return true;
            }else{
                System.out.println("Title does NOT contain expected text. Please check");
                return false;
            }
        }
        System.out.println("Actual Page title is null. Please check.");
        return false;
    }

    public static boolean compareWithMargin(Integer temperatureFromWeb, Integer temperatureFromApi, double decimalPercentageMarginLimit) {
        if (temperatureFromWeb != temperatureFromApi && temperatureFromWeb>temperatureFromApi){
            if (temperatureFromApi!=0 && temperatureFromApi != 1){
                return (temperatureFromWeb/temperatureFromApi)-1<=decimalPercentageMarginLimit;
            }else {
                return false;
            }
        }else{
            if (temperatureFromWeb!=0){
                return (temperatureFromApi/temperatureFromWeb)-1<=decimalPercentageMarginLimit;
            }else{
                return false;
            }
        }
    }

    public static int getDigitFromString(String sTextWithDigitInIt){
        int extractedDigit = 0;
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(sTextWithDigitInIt);
        while (m.find()){
            extractedDigit = Integer.parseInt(m.group());
        }
        return extractedDigit;
    }

}
