package pages;


import org.openqa.selenium.WebElement;

public class MainPage {

    private String searchFieldElementXpath = "//*[@id=search_form_input_homepage]";
    private String duckLogoElementXpath = "//*[@id=logo_homepage_link]";
    private static WebElement searchFieldElement;
    private static WebElement duckLogoElement;

    public MainPage(WebElement searchFieldElement, WebElement duckLogoElement) {
        this.searchFieldElement = searchFieldElement;
        this.duckLogoElement = duckLogoElement;
    }

    public static void sendKeysToField(String query){
        if (searchFieldElement!=null){
            searchFieldElement.sendKeys(query);
        }
    }


}
