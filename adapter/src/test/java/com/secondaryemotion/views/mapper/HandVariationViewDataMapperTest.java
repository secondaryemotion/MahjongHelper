package com.secondaryemotion.views.mapper;

import com.secondaryemotion.data.entity.HandVariation;
import com.secondaryemotion.views.view.HandVariationView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class HandVariationViewDataMapperTest {

    public HandVariation handVariation;


    @BeforeEach
    void setUp() {
        int[][] man = {{1,2},{3}};
        int[][] pin = {{1,2},{3}};
        int[][] sou = {{1,2},{3}};
        int[][] honor = {{1,2},{3}};

        this.handVariation = new HandVariation(man,pin,sou,honor,new int[34]);
    }

    @Test
    @DisplayName("Check if transform function works correctly")
    void transform_test() {
        // arrange
        int[][] man = {{1,2},{3}};
        int[][] pin = {{9,10},{11}};
        int[][] sou = {{18,19},{20}};
        int[][] honor = {{27,28},{29}};
        HandVariationView expected = new HandVariationView(man,pin,sou,honor);
        // act
        HandVariationView actual = HandVariationViewDataMapper.transform(handVariation);
        // assert
        Assertions.assertEquals(expected,actual);
    }
}