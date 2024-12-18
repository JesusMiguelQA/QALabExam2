package com.nttdata.page;

import org.openqa.selenium.By;

public class ProductStore {

    // Localizadores para inicio de sesión
    public static By emailInput = By.id("field-email");
    public static By passwordInput = By.id("field-password");
    public static By loginButton = By.id("submit-login");
    public static By loginErrorMessage = By.cssSelector(".alert.alert-danger");
    public static By forgotPasswordLink = By.linkText("¿Olvidó su contraseña?");


    // Localizadores de la barra de navegación
    public static By clothesCategory = By.xpath("//a[contains(text(),'Clothes')]");
    public static By menSubCategory = By.xpath("//a[contains(text(),'Men')]");
    public static By womenSubCategory = By.xpath("//a[contains(text(),'Women')]");

    // Localizadores del buscador
    public static By searchInput = By.name("s");
    public static By searchButton = By.cssSelector("button[type='submit']");

    // Localizadores de productos destacados
    public static By firstProductImage = By.cssSelector(".product-thumbnail");
    public static By firstProductPrice = By.cssSelector(".price");
    public static By addToCartButton = By.cssSelector(".add-to-cart");

    // Localizador del carrito de compras
    public static By cartIcon = By.cssSelector(".shopping-cart");
    public static By cartQuantity = By.cssSelector(".cart-products-count");
    public static By accountHeader = By.cssSelector(".page-header h1");
    public static By categoryNotFound = By.cssSelector(".no-items");
}