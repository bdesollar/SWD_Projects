import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ChangeComputationTest {
    int[] num_of_each_currency;
    int[] num_of_currency_test;
    double us;

    @Test
    public void ConvertUsdToEuTest1() {
        // 1st Test
        num_of_each_currency = new int[]{2, 1, 0, 4, 0, 1, 0, 0, 3};
        // 54.23 in euro
        us = 64.56;
        num_of_currency_test = ChangeComputation.ConvertUsdToEu(us);
        for (int i = 0; i < 8; i++) {
            assertEquals(num_of_each_currency[i], num_of_currency_test[i]);
        }
    }
    @Test
    public void ConvertUsdToEuTest2() {
        // 2nd Test
        num_of_each_currency = new int[]{2, 0, 1, 1, 0, 1, 0, 0, 3};
        // 46.21 in euro
        us = 55.01;
        num_of_currency_test = ChangeComputation.ConvertUsdToEu(us);
        for (int i = 0; i < 8; i++) {
            assertEquals(num_of_each_currency[i], num_of_currency_test[i]);
        }
    }
    @Test
    public void ConvertUsdToEuTest3() {
        // 3rd Test
        num_of_each_currency = new int[]{0, 0, 1, 3, 1, 1, 1, 0, 4};
        // 8.84 in euro
        us = 10.52;
        num_of_currency_test = ChangeComputation.ConvertUsdToEu(us);
        for (int i = 0; i < 8; i++) {
            assertEquals(num_of_each_currency[i], num_of_currency_test[i]);
        }
    }
    @Test
    public void ConvertUsdToEuTest4() {
        // 4th Test
        num_of_each_currency = new int[]{1, 0, 0, 1, 0, 0, 0, 0, 0};
        // 21.00
        us = 25.00;
        num_of_currency_test = ChangeComputation.ConvertUsdToEu(us);
        for (int i = 0; i < 8; i++) {
            assertEquals(num_of_each_currency[i], num_of_currency_test[i]);
        }
    }
    @Test
    public void ConvertUsdToEuTest5() {
        // 5th Test
        num_of_each_currency = new int[]{0, 1, 1, 3, 1, 0, 1, 1, 2};
        // 18.67 in euro
        us = 22.23;
        num_of_currency_test = ChangeComputation.ConvertUsdToEu(us);
        for (int i = 0; i < 8; i++) {
            assertEquals(num_of_each_currency[i], num_of_currency_test[i]);
        }
    }
    @Test
    public void ConvertUsdToEuTest6() {
        // 6th Test
        num_of_each_currency = new int[]{4, 0, 1, 3, 1, 1, 0, 1, 1};
        // 88.76 in euro
        us = 105.67;
        num_of_currency_test = ChangeComputation.ConvertUsdToEu(us);
        for (int i = 0; i < 8; i++) {
            assertEquals(num_of_each_currency[i], num_of_currency_test[i]);
        }
    }
    @Test
    public void ConvertUsdToEuTest7() {
        // 7th Test
        num_of_each_currency = new int[]{21, 0, 1, 2, 0, 0, 0, 0, 1};
        // 427.01 in euro
        us = 508.34;
        num_of_currency_test = ChangeComputation.ConvertUsdToEu(us);
        for (int i = 0; i < 8; i++) {
            assertEquals(num_of_each_currency[i], num_of_currency_test[i]);
        }
    }
    @Test
    public void ConvertUsdToEuTest8() {
        // 8th Test
        num_of_each_currency = new int[]{1, 0, 1, 1, 1, 2, 0, 1, 4};
        // 26.99 in euro
        us = 32.13;
        num_of_currency_test = ChangeComputation.ConvertUsdToEu(us);
        for (int i = 0; i < 8; i++) {
            assertEquals(num_of_each_currency[i], num_of_currency_test[i]);
        }
    }
    @Test
    public void ConvertUsdToEuTest9() {
        // 9th Test
        num_of_each_currency = new int[]{2, 1, 1, 1, 0, 1, 0, 1, 1};
        // 56.26 in euro
        us = 66.98;
        num_of_currency_test = ChangeComputation.ConvertUsdToEu(us);
        for (int i = 0; i < 8; i++) {
            assertEquals(num_of_each_currency[i], num_of_currency_test[i]);
        }
    }
    @Test
    public void ConvertUsdToEuTest10() {
        // 10th Test
        num_of_each_currency = new int[]{0, 0, 0, 0, 1, 1, 1, 0, 4};
        // 0.84 in euro
        us = 1.00;
        num_of_currency_test = ChangeComputation.ConvertUsdToEu(us);
        for (int i = 0; i < 8; i++) {
            assertEquals(num_of_each_currency[i], num_of_currency_test[i]);
        }
    }
    @Test
    public void ConvertUsdToEuTest11() {
        // 11th Test
        num_of_each_currency = new int[]{0, 0, 1, 3, 0, 2, 0, 0, 0};
        // 8.40 in euro
        us = 10.00;
        num_of_currency_test = ChangeComputation.ConvertUsdToEu(us);
        for (int i = 0; i < 8; i++) {
            assertEquals(num_of_each_currency[i], num_of_currency_test[i]);
        }
    }
    @Test
    public void ConvertUsdToEuTest12() {
        // 12th Test
        num_of_each_currency = new int[]{0, 1, 0, 3, 0, 0, 0, 1, 1};
        // 13.06 in euro
        us = 15.55;
        num_of_currency_test = ChangeComputation.ConvertUsdToEu(us);
        for (int i = 0; i < 8; i++) {
            assertEquals(num_of_each_currency[i], num_of_currency_test[i]);
        }
    }
    @Test
    public void ConvertUsdToEuTest13() {
        // 13th Test
        num_of_each_currency = new int[]{210, 1, 1, 2, 1, 2, 0, 0, 3};
        // 4217.93 in euro
        us = 5021.35;
        num_of_currency_test = ChangeComputation.ConvertUsdToEu(us);
        for (int i = 0; i < 8; i++) {
            assertEquals(num_of_each_currency[i], num_of_currency_test[i]);
        }
    }
    @Test
    public void ConvertUsdToEuTest14() {
        // 14th Test
        num_of_each_currency = new int[]{1, 1, 1, 3, 0, 0, 1, 1, 3};
        // 38.18 in euro
        us = 45.45;
        num_of_currency_test = ChangeComputation.ConvertUsdToEu(us);
        for (int i = 0; i < 8; i++) {
            assertEquals(num_of_each_currency[i], num_of_currency_test[i]);
        }
    }
    @Test
    public void ConvertUsdToEuTest15() {
        // 15th Test
        num_of_each_currency = new int[]{2, 1, 1, 3, 0, 1, 1, 0, 4};
        // 58.34 in euro
        us = 69.45;
        num_of_currency_test = ChangeComputation.ConvertUsdToEu(us);
        for (int i = 0; i < 8; i++) {
            assertEquals(num_of_each_currency[i], num_of_currency_test[i]);
        }
    }
    }