package com.nttdata.stepsdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import com.nttdata.steps.ProductStoreSteps;
import com.nttdata.core.DriverManager;

public class ProductStoreDef {
    private final ProductStoreSteps productStoreSteps;

    public ProductStoreDef() {
        this.productStoreSteps = new ProductStoreSteps(DriverManager.getDriver());
    }

    @Given("que estoy en la página de inicio de sesión")
    public void queEstoyEnLaPáginaDeInicioDeSesión() {
        try {
            productStoreSteps.navigateToLoginPage();
        } catch (Exception e) {
            throw new RuntimeException("Error al navegar a la página de inicio de sesión: " + e.getMessage());
        }
    }

    @When("ingreso el usuario {string} y la contraseña {string}")
    public void ingresoElUsuarioYLaContraseña(String usuario, String contraseña) {
        try {
            productStoreSteps.login(usuario, contraseña);
        } catch (Exception e) {
            throw new RuntimeException("Error al intentar iniciar sesión: " + e.getMessage());
        }
    }

    @Then("debería ver la página principal de la tienda")
    public void deberíaVerLaPáginaPrincipalDeLaTienda() {
        try {
            boolean isDisplayed = productStoreSteps.isHomePageDisplayed();
            Assertions.assertTrue(isDisplayed, "No se pudo acceder a la página principal");
        } catch (Exception e) {
            throw new RuntimeException("Error al verificar la página principal: " + e.getMessage());
        }
    }

    @Given("que estoy en la página de inicio de sesiónDos")
    public void queEstoyEnLaPáginaDeInicioDeSesiónDos() {
        try {
            productStoreSteps.navigateToLoginPage();
        } catch (Exception e) {
            throw new RuntimeException("Error al navegar a la página de inicio de sesión: " + e.getMessage());
        }
    }

    @When("ingreso el usuario {string} y la contraseñaDos {string}")
    public void ingresoElUsuarioYLaContraseñaDos(String usuario, String contraseña) {
        try {
            productStoreSteps.login(usuario, contraseña);
        } catch (Exception e) {
            throw new RuntimeException("Error al intentar iniciar sesión: " + e.getMessage());
        }
    }

    @Then("debería ver un mensaje de error indicando fallo en la autenticación")
    public void deberíaVerUnMensajeDeErrorIndicandoFalloEnLaAutenticación() {
        try {
            boolean isErrorDisplayed = productStoreSteps.isErrorMessageDisplayed();
            Assertions.assertTrue(isErrorDisplayed, "No se mostró el mensaje de error esperado");
        } catch (Exception e) {
            throw new RuntimeException("Error al verificar mensaje de error: " + e.getMessage());
        }
    }

    @Given("que estoy en la página de inicio de sesiónTres")
    public void queEstoyEnLaPáginaDeInicioDeSesiónTres() {
        try {
            productStoreSteps.navigateToLoginPage();
        } catch (Exception e) {
            throw new RuntimeException("Error al navegar a la página de inicio de sesión: " + e.getMessage());
        }
    }

    @When("ingreso el usuario {string} y la contraseñaTres {string}")
    public void ingresoElUsuarioYLaContraseñaTres(String usuario, String contraseña) {
        try {
            productStoreSteps.login(usuario, contraseña);
        } catch (Exception e) {
            throw new RuntimeException("Error al intentar iniciar sesión: " + e.getMessage());
        }
    }

    @And("navego a la categoría {string}")
    public void navegoALaCategoría(String categoria) {
        try {
            productStoreSteps.navigateToCategory(categoria);
        } catch (Exception e) {
            throw new RuntimeException("Error al navegar a la categoría: " + e.getMessage());
        }
    }

    @Then("debería ver un mensaje indicando que la categoría no existe")
    public void deberíaVerUnMensajeIndicandoQueLaCategoríaNoExiste() {
        try {
            boolean isCategoryNotFound = productStoreSteps.isCategoryNotFoundMessageDisplayed();
            Assertions.assertTrue(isCategoryNotFound, "No se mostró el mensaje de categoría no encontrada");
        } catch (Exception e) {
            throw new RuntimeException("Error al verificar mensaje de categoría no encontrada: " + e.getMessage());
        }
    }
}