package test.java.com.secondaryemotion.data.entity;

import main.java.com.secondaryemotion.data.entity.HandEntity;
import main.java.com.secondaryemotion.data.entity.HandVariationEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class HandVariationEntityTest {

    @Test
    @DisplayName("Check if generateHand works correctly")
    void generateHand_test() {
        // arrange
        int[] man = new int[]{2, 3, 9, 1};
        int[] pin = new int[]{};
        int[] sou = new int[]{2, 1, 2, 9, 1};
        int[] honors = new int[]{4, 6, 4, 4};
        HandEntity hand = new HandEntity(man,pin,sou,honors);
        HandVariationEntity[] handVariationEntitiesExpected = new HandVariationEntity[2];
        handVariationEntitiesExpected[0] = new HandVariationEntity("123c9c","","112c2c9c","444c6c");
        handVariationEntitiesExpected[1] = new HandVariationEntity("123c9c","","1c122c9c","444c6c");
        // act
        HandVariationEntity[] handVariationEntities = HandVariationEntity.generateHand(hand);
        // assert
        Assertions.assertArrayEquals(handVariationEntitiesExpected,handVariationEntities);
    }

    @Test
    @DisplayName("Check if findSets works correctly")
    void findSets_test() {
        // arrange
        int[] testSuit = {1,1,2,3,5,8};
        ArrayList<String> expected = new ArrayList<>();
        expected.add("112c35c8c");
        expected.add("1c123c5c8c");
        expected.add("1c1c23c5c8c");
        expected.add("1c1c2c35c8c");
        expected.add("1c1c2c3c5c8c");
        expected.add("1c1c2c3c5c8c");
        // act
        ArrayList<String> result = HandVariationEntity.findSets(testSuit);
        // assign
        Assertions.assertIterableEquals(expected,result);
    }

    @Test
    @DisplayName("Check if getOptimalSetsFrom works correctly")
    void getOptimalSetsFrom_test(){
        // arrange
        ArrayList<String> tested = new ArrayList<>();
        tested.add("112c35c8c");
        tested.add("1c123c5c8c");
        tested.add("1c1c23c5c8c");
        tested.add("1c1c2c35c8c");
        tested.add("1c1c2c3c5c8c");
        tested.add("1c1c2c3c5c8c");
        String[] expected = {"112c35c8c"};
        // act
        String[] result = HandVariationEntity.getOptimalSetsFrom(tested);
        // assign
        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    @DisplayName("Check if getHonorsSets works correctly")
    void getHonorsSets_test() {
        // arrange
        int[] testSuit = {4, 4, 4, 6};
        String[] expected = {"444c6c"};
        // act
        String[] result = HandVariationEntity.getHonorsSets(testSuit);
        // assign
        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    @DisplayName("Check if transformSetsToArrays works correctly")
    void transformSetsToArrays_test(){
        // arrange
        String testSet = "112c35c8c";
        int[][] expected = { {1,1,2},{3,5},{8}};
        // act
        int[][] result = HandVariationEntity.transformSetsToArrays(testSet);
        // assign
        Assertions.assertArrayEquals(expected,result);
    }




}