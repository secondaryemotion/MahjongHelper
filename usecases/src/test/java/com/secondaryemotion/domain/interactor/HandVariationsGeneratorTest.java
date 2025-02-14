package test.java.com.secondaryemotion.domain.interactor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static main.java.com.secondaryemotion.domain.interactor.HandVariationsGenerator.*;

class HandVariationsGeneratorTest {

    @Test
    @DisplayName("Check if findSets works correctly")
    void findSets_test() {
        // arrange
        ArrayList<String> expected = new ArrayList<>();
        expected.add("1c678c");
        expected.add("1c678c");
        expected.add("1c6c78c");
        expected.add("1c6c7c8c");
        // act
        ArrayList<String> actual = findSets(new int[]{1,6,7,8});
        // assert
        Assertions.assertIterableEquals(expected,actual);
    }

    @Test
    @DisplayName("Check if getOptimalSetsFrom works correctly")
    void getOptimalSetsFrom_test() {
        // arrange
        ArrayList<String> sets = new ArrayList<>();
        sets.add("1c678c");
        sets.add("1c678c");
        sets.add("1c6c78c");
        sets.add("1c6c7c8c");
        // act
        String[] actual = getOptimalSetsFrom(sets);
        String[] expected = new String[]{"1c678c"};
        // assert
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("Check if getOptimalHonorsSets works correctly")
    void getOptimalHonorsSets_test() {
        // arrange
        int[] honors = new int[]{1,1,1,3,3,5};
        // act
        String[] actual = getOptimalHonorsSets(honors);
        String[] expected = new String[]{"111c33c5c"};
        // assert
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("Check if transformSetsToArrays works correctly")
    void transformSetsToArrays_test() {
        // arrange
        String variation = "111c33c5c";
        // act
        int[][] actual = transformSetsToArrays(variation);
        int[][] expected = new int[][]{{1,1,1},{3,3},{5}};
        // assert
        Assertions.assertArrayEquals(expected,actual);
    }
}