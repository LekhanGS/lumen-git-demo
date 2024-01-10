package com.example.mavendemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

//@Disabled
class MathUtilsTests {
    @ParameterizedTest(name = "number={0},square{0}")
    @CsvSource(value = {"6,36","-9,81","5,25","-3,9"})
    void squaresAGivenInteger(int n,int square){
        MathUtils mu = new MathUtils();
        int result = mu.square(n);
        assertEquals(square,result);
//        throw new RuntimeException("Something is wrong");
    }
    @Test
    void computesTheAreOfCircleForNonNegativeRadius(){
        MathUtils mu = new MathUtils();
        assertEquals(78.54,mu.getAreaOfCircle(5),0.01);
    }
    @Tag("foo")
    @ParameterizedTest
    @ValueSource(doubles = {-1,-3,-5,-67,-789})
    void throwsExceptionForNegativeRadii(double r){
        MathUtils mu = new MathUtils();

        RuntimeException runtimeException = assertThrows(
                RuntimeException.class,
                ()->mu.getAreaOfCircle(r)
        );
        assertEquals(
                "negative radius is not allowed",
                runtimeException.getMessage()
        );
    }
}