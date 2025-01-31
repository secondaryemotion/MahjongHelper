package test.java.com.secondaryemotion.data.entity;

import main.java.com.secondaryemotion.data.entity.HandEntity;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

class HandEntityTest {

    public static HandEntity handEntity;

    @BeforeAll
    public static void createHandEntity(){
        handEntity = new HandEntity(new int[]{},new int[]{},new int[]{},new int[]{});
    }

    @Test
    @DisplayName("Get False when the suit is invalid by count")
    void validateSuit_invalidCount_false() {
        // arrange
        int[] invalidSuit = new int[]{1, 1, 2, 2, 1, 5, 7, 1, 9, 1};
        handEntity.setMan(invalidSuit);
        // act
        boolean result = handEntity.validateSuit(invalidSuit, handEntity.maxSuitValue);
        // assert
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Get False when the honor suit is invalid by max value")
    void validateSuit_invalidMax_false() {
        // arrange
        int[] invalidHonorSuit = new int[]{1, 1, 2, 2, 1, 5, 7, 1, 9, 1};
        handEntity.setHonors(invalidHonorSuit);
        // act
        boolean result = handEntity.validateSuit(invalidHonorSuit, handEntity.maxHonorsValue);
        // assert
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Get False when the suit is invalid by min value")
    void validateSuit_invalidMin_false() {
        // arrange
        int[] invalidSuit = new int[]{1, 1, 2, 2, 1, 5, 7, 1, 9, -5};
        handEntity.setMan(invalidSuit);
        // act
        boolean result = handEntity.validateSuit(invalidSuit, handEntity.maxSuitValue);
        // assert
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Get True when the suit is valid")
    void validateSuit_valid_true() {
        // arrange
        int[] validSuit = new int[]{1, 1, 2, 2, 1, 5, 7, 3, 9, 1};
        handEntity.setMan(validSuit);
        // act
        boolean result = handEntity.validateSuit(validSuit, handEntity.maxSuitValue);
        // assert
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Get True when the suit is empty")
    void validateSuit_empty_true() {
        // arrange
        int[] emptySuit = new int[]{};
        handEntity.setMan(emptySuit);
        // act
        boolean result = handEntity.validateSuit(emptySuit, handEntity.maxSuitValue);
        // assert
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Get True when the hand is valid")
    void validate_valid_true() {
        // arrange
        int[] man = new int[]{2, 7, 3, 9, 1};
        int[] pin = new int[]{};
        int[] sou = new int[]{2, 1, 2, 2, 9, 1};
        int[] honors = new int[]{4, 6};
        handEntity.setMan(man);
        handEntity.setPin(pin);
        handEntity.setSou(sou);
        handEntity.setHonors(honors);
        // act
        boolean result = handEntity.validate();
        // assert
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Get False when the hand is invalid")
    void validate_invalid_false() {
        // arrange
        int[] man = new int[]{2, 7, 3, 9, 1};
        int[] sou = new int[]{2, 1, 2, 2, 9, 1};
        int[] pin = new int[]{};
        int[] honors = new int[]{4, 6, 7};
        handEntity.setMan(man);
        handEntity.setSou(sou);
        handEntity.setPin(pin);
        handEntity.setHonors(honors);
        // act
        boolean result = handEntity.validate();
        // assert
        Assertions.assertFalse(result);
    }



}