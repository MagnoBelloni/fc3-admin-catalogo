package com.magno.admin.catalogo.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UseCaseTest {

    @Test
    public void useCaseExecuteTest() {
        final var expectedName = "Filmes";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        final var useCaseResult = new UseCase().execute(expectedName, expectedDescription, expectedIsActive);

        Assertions.assertNotNull(useCaseResult);
    }
}
