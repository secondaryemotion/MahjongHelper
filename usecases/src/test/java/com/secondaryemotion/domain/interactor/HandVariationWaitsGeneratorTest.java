package com.secondaryemotion.domain.interactor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HandVariationWaitsGeneratorTest {

    @Test
    @DisplayName("Check if generateSuitWaits works correctly ")
    void generateSuitWaits_test() {
        // arrange
        int[][] suit = new int[][]{{1,1,3},{1,2,2},{4,4,4}};
        // act
        int[][] expected = new int[][] {{2,1},{2,3},{}};
        int[][] actual = HandVariationWaitsGenerator.generateSuitWaits(suit);
        // assert
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("Check if generateWaitsForThreeTiles works correctly ")
    void generateWaitsForThreeTiles_test() {
        // arrange
        int[] set = new int[]{1,1,3};
        // act
        int[] expected = new int[]{2,1};
        int[] actual = HandVariationWaitsGenerator.generateWaitsForThreeTiles(set);
        // assert
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("Check if generateWaitsForTwoTiles works correctly ")
    void generateWaitsForTwoTiles_test() {
        // arrange
        int[] set = new int[]{7,8};
        // act
        int[] expected = new int[]{6,9};
        int[] actual = HandVariationWaitsGenerator.generateWaitsForTwoTiles(set);
        // assert
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("Check if generateEdgeAndIdenticalWaits works correctly ")
    void generateEdgeAndIdenticalWaits_test() {
        // arrange
        int[] set = new int[]{8,8,9};
        // act
        int[] expected = new int[]{7,8};
        int[] actual = HandVariationWaitsGenerator.generateEdgeAndIdenticalWaits(set);
        // assert
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("Check if generateSideAndIdenticalWaits works correctly ")
    void generateSideAndIdenticalWaits_test() {
        // arrange
        int[] set = new int[]{7,7,8};
        // act
        int[] expected = new int[]{6,9,7};
        int[] actual = HandVariationWaitsGenerator.generateSideAndIdenticalWaits(set);
        // assert
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("Check if generateClosedAndSideWaitForTriple works correctly ")
    void generateClosedAndSideWaitForTriple_test() {
        // arrange
        int[] set = new int[]{7,7,9};
        // act
        int[] expected = new int[]{8,7};
        int[] actual = HandVariationWaitsGenerator.generateClosedAndSideWaitForTriple(set);
        // assert
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("Check if generateSideWaits works correctly ")
    void generateSideWaits_test() {
        // arrange
        int[] set = new int[]{7,8};
        // act
        int[] expected = new int[]{6,9};
        int[] actual = HandVariationWaitsGenerator.generateSideWaits(set);
        // assert
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("Check if generateEdgeWait works correctly ")
    void generateEdgeWait_test() {
        // arrange
        int[] set = new int[]{1,2};
        // act
        int[] expected = new int[]{3};
        int[] actual = HandVariationWaitsGenerator.generateEdgeWait(set);
        // assert
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("Check if generateClosedWait works correctly ")
    void generateClosedWait_test() {
        // arrange
        int[] set = new int[]{1,3};
        // act
        int[] expected = new int[]{2};
        int[] actual = HandVariationWaitsGenerator.generateClosedWait(set);
        // assert
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("Check if generatePairWait works correctly ")
    void generatePairWait_test() {
        // arrange
        int[] set = new int[]{1};
        // act
        int[] expected = new int[]{1};
        int[] actual = HandVariationWaitsGenerator.generatePairWait(set);
        // assert
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("Check if generateHonorWaits works correctly ")
    void generateHonorWaits_test() {
        // arrange
        int[][] honors = new int[][]{{1,1,1},{3,3},{5}};
        // act
        int[][] expected = new int[][]{{1},{3},{5}};
        int[][] actual = HandVariationWaitsGenerator.generateHonorWaits(honors);
        // assert
        Assertions.assertArrayEquals(expected,actual);
    }
}