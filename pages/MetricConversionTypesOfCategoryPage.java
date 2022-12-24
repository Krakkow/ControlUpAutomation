package pages;

import org.openqa.selenium.WebElement;

public class MetricConversionTypesOfCategoryPage extends MetricConversionsMainPage{

    public static String categoryPageTitleXpath ="";
    public static String[] categoryConvertTypesXpath = new String[]{};

    public static WebElement categoryPageTitleElement;
    public static WebElement[] categoryConvertTypesElement;

    public MetricConversionTypesOfCategoryPage(String conversionType) {
        initPageElements();
    }

    private void initPageElements() {

    }


}
