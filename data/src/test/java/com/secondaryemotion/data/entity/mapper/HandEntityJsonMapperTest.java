package test.java.com.secondaryemotion.data.entity.mapper;

import main.java.com.secondaryemotion.data.entity.HandEntity;
import main.java.com.secondaryemotion.data.entity.mapper.HandEntityJsonMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HandEntityJsonMapperTest {

    @Test
    @DisplayName("Check if transformHand works correctly with standard hand")
    void transformHandEntity_standard_test() {
        // arrange
        String handJsonResponse = "{\"hand\":\"1678m9p58s1112455z\"}";
        // act
        HandEntity result = HandEntityJsonMapper.transformHandEntity(handJsonResponse);
        HandEntity expected = new HandEntity(new int[]{1,6,7,8}, new int[]{9},new int[]{5,8},new int[]{1,1,1,2,4,5,5});
        // assign
        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName("Check if transformHand works correctly with empty suit")
    void transformHandEntity_emptySuit_test() {
        // arrange
        String handJsonResponse = "{\"hand\":\"1678m158s1112455z\"}";
        // act
        HandEntity result = HandEntityJsonMapper.transformHandEntity(handJsonResponse);
        HandEntity expected = new HandEntity(new int[]{1,6,7,8}, new int[]{},new int[]{1,5,8},new int[]{1,1,1,2,4,5,5});
        // assign
        Assertions.assertEquals(expected,result);
    }
}