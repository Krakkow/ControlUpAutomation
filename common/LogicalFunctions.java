package common;


public class LogicalFunctions {


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
}
