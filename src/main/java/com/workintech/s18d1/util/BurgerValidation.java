package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public final class BurgerValidation {

    private BurgerValidation() {
    }

    public static void validateForSave(
            Burger burger
    ) {

        if (burger == null) {

            throw new BurgerException(
                    "Burger cannot be null",
                    HttpStatus.BAD_REQUEST
            );
        }

        if (
                burger.getName() == null ||
                burger.getName().isBlank()
        ) {

            throw new BurgerException(
                    "Burger name is required",
                    HttpStatus.BAD_REQUEST
            );
        }

        if (
                burger.getPrice() == null ||
                burger.getPrice() < 0
        ) {

            throw new BurgerException(
                    "Burger price must be zero or greater",
                    HttpStatus.BAD_REQUEST
            );
        }

        if (burger.getIsVegan() == null) {

            throw new BurgerException(
                    "Vegan information is required",
                    HttpStatus.BAD_REQUEST
            );
        }

        if (burger.getBreadType() == null) {

            throw new BurgerException(
                    "Bread type is required",
                    HttpStatus.BAD_REQUEST
            );
        }

        if (
                burger.getContents() == null ||
                burger.getContents().isBlank()
        ) {

            throw new BurgerException(
                    "Burger contents are required",
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    public static void validateForUpdate(
            Burger burger
    ) {

        if (burger == null) {

            throw new BurgerException(
                    "Burger cannot be null",
                    HttpStatus.BAD_REQUEST
            );
        }

        if (burger.getId() == null) {

            throw new BurgerException(
                    "Burger id is required",
                    HttpStatus.BAD_REQUEST
            );
        }

        if (
                burger.getName() == null ||
                burger.getName().isBlank()
        ) {

            throw new BurgerException(
                    "Burger name is required",
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}