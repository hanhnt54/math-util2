/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hanhnt.mathutil;

import static com.hanhnt.mathutil.core.MathUtil.getFactorial;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author DELL
 */
public class MathUtilTestDDT {
    //chuẩn bị bộ data
    public static Object[][] initData() {
        return new Integer[][]{
            {1, 1},
            {2, 2},
            {5, 120},
            {6, 720},
            {4, 24}
        };
    }
    @ParameterizedTest
    @MethodSource(value = "initData") //tên hàm cung cấp data ngầm định thứ tự của các phần tử mảng, map vào tham số hàm
    public void testGetFactorialGivenRightArgReturnWell(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }
    @Test
    public void testGetFactorialGivenWrongArgThrowException() {
        // assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
        assertEquals("Invalid argument. n must be between 0 and 20.", ex.getMessage());
    }
}
