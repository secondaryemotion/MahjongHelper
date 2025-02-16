package com.secondaryemotion.views.mapper;


import com.secondaryemotion.data.entity.HandVariationWaits;
import com.secondaryemotion.views.view.HandVariationWaitsView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class HandVariationWaitsViewDataMapperTest {
    public HandVariationWaits handVariationWaits;


    @BeforeEach
    void setUp() {
        int[][] man = {{1,2},{3}};
        int[][] pin = {{1,2},{3}};
        int[][] sou = {{1,2},{3}};
        int[][] honor = {{1,2},{3}};

        this.handVariationWaits = new HandVariationWaits(man,pin,sou,honor);
    }

    @Test
    @DisplayName("Check if transform function works correctly")
    void transform_test() {
        // arrange
        int[][] man = {{1,2},{3}};
        int[][] pin = {{9,10},{11}};
        int[][] sou = {{18,19},{20}};
        int[][] honor = {{27,28},{29}};
        HandVariationWaitsView expected = new HandVariationWaitsView(man,pin,sou,honor);
        // act
        HandVariationWaitsView actual = HandVariationWaitsViewDataMapper.transform(handVariationWaits);
        // assert
        Assertions.assertEquals(expected,actual);
    }

}