package test.java.com.secondaryemotion.data.entity;

import main.java.com.secondaryemotion.data.entity.Hand;
import org.junit.jupiter.api.BeforeAll;

class HandTest {

    public static Hand hand;

    @BeforeAll
    public static void createHand(){
        hand = new Hand(new int[]{},new int[]{},new int[]{},new int[]{});
    }

    /*@Test
    @DisplayName("Get True when the suit is valid")
    void validateSuit_valid_true() {
        // arrange
        int[] validSuit = new int[]{1, 1, 2, 2, 1, 5, 7, 3, 9, 1};
        hand.setMan(validSuit);
        // act
        boolean result = hand.validateSuit(validSuit, hand.maxSuitValue);
        // assert
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Get True when the suit is empty")
    void validateSuit_empty_true() {
        // arrange
        int[] emptySuit = new int[]{};
        hand.setMan(emptySuit);
        // act
        boolean result = hand.validateSuit(emptySuit, hand.maxSuitValue);
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
        hand.setMan(man);
        hand.setPin(pin);
        hand.setSou(sou);
        hand.setHonor(honors);
        // act
        boolean result = hand.validate();
        // assert
        Assertions.assertTrue(result);
    }*/




}