package com.secondaryemotion.data.entity.mapper;

import com.secondaryemotion.data.entity.Hand;
import com.secondaryemotion.data.entity.parser.HandJsonParser;
import com.secondaryemotion.data.exception.InvalidHandException;
import org.junit.jupiter.api.*;



class HandJsonParserTest {

    public String validHandJsonResponse;
    public String invalidHandJsonResponse;

    @BeforeEach
    void setUp() {
        this.validHandJsonResponse = "{\"hand\":\"1678m9p58s111455z\"}";
        this.invalidHandJsonResponse = "{\"hand\":\"1678m9p58s115z\"}";
    }

    @Test
    @DisplayName("Check if parse function works correctly with valid hand")
    void parse_valid_test() {
        // arrange
        Hand expected = new Hand(new int[]{1,6,7,8},new int[]{9},new int[]{5,8},new int[]{1,1,1,4,5,5});
        // act
        Hand actual = HandJsonParser.parse(validHandJsonResponse);
        // assert
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Check if parse function works correctly with invalid hand")
    void parse_invalid_test() {
        try {
            HandJsonParser.parse(invalidHandJsonResponse);
        } catch (InvalidHandException e){
            Assertions.assertEquals("Wrong hand size", e.getMessage());
        }
    }
}