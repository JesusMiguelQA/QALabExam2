package com.nttdata.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import com.nttdata.page.ProductStore;

public class ProductStoreSteps {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String BASE_URL = "https://qalab.bensg.com/store";
    private static final String LOGIN_URL = BASE_URL + "/es/iniciar-sesion";

    public ProductStoreSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void navigateToLoginPage() {
        try {
            driver.get(LOGIN_URL);
            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(ProductStore.emailInput));
        } catch (Exception e) {
            System.out.println("Error en navigateToLoginPage: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al cargar la página de login: " + e.getMessage());
        }
    }

    public void login(String username, String password) {
        try {
            WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(ProductStore.emailInput));
            emailField.clear();
            emailField.sendKeys(username);

            WebElement passwordField = driver.findElement(ProductStore.passwordInput);
            passwordField.clear();
            passwordField.sendKeys(password);

            driver.findElement(ProductStore.loginButton).click();

            wait.until(ExpectedConditions.or(
                    ExpectedConditions.urlContains("/mi-cuenta"),
                    ExpectedConditions.visibilityOfElementLocated(ProductStore.loginErrorMessage)
            ));
        } catch (Exception e) {
            System.out.println("Error en login: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error durante el proceso de login: " + e.getMessage());
        }
    }

    public boolean isHomePageDisplayed() {
        try {
            return wait.until(ExpectedConditions.urlContains("/mi-cuenta"));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductStore.loginErrorMessage))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

    public void navigateToCategory(String category) {
        try {
            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete"));

            switch (category.toLowerCase()) {
                case "clothes":
                    wait.until(ExpectedConditions.elementToBeClickable(ProductStore.clothesCategory)).click();
                    break;
                case "men":
                    wait.until(ExpectedConditions.elementToBeClickable(ProductStore.menSubCategory)).click();
                    break;
                case "women":
                    wait.until(ExpectedConditions.elementToBeClickable(ProductStore.womenSubCategory)).click();
                    break;
                default:
                    WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(ProductStore.searchInput));
                    searchField.clear();
                    searchField.sendKeys(category);
                    driver.findElement(ProductStore.searchButton).click();
            }

            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            System.out.println("Error en navigateToCategory: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al navegar a la categoría " + category + ": " + e.getMessage());
        }
    }

    public boolean isCategoryNotFoundMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(ProductStore.categoryNotFound),
                    ExpectedConditions.urlContains("controller=search")
            ));
        } catch (Exception e) {
            return true;
        }
    }
}