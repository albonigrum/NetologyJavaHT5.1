import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditPaymentServiceTest {
    CreditPaymentService creditPaymentService;
    long amountInRubles;
    long periodInYears;
    double interestRatePerYearInPercents;

    @BeforeEach
    void setUp() {
        creditPaymentService = new CreditPaymentService();
        amountInRubles = 0;
        periodInYears = 0;
        interestRatePerYearInPercents = 0D;
    }

    // ==================== Test by difference years ====================
    @Test
    void shouldCalculateYear1Amount1_000_000IR9_99() {
        amountInRubles = 1_000_000;
        periodInYears = 1;
        interestRatePerYearInPercents = 9.99;

        assertEquals(87911,
                creditPaymentService.calculate(amountInRubles, periodInYears, interestRatePerYearInPercents));
    }

    @Test
    void shouldCalculateYear2Amount1_000_000IR9_99() {
        amountInRubles = 1_000_000;
        periodInYears = 2;
        interestRatePerYearInPercents = 9.99;

        assertEquals(46140,
                creditPaymentService.calculate(amountInRubles, periodInYears, interestRatePerYearInPercents));
    }

    @Test
    void shouldCalculateYear3Amount1_000_000IR9_99() {
        amountInRubles = 1_000_000;
        periodInYears = 3;
        interestRatePerYearInPercents = 9.99;

        assertEquals(32262,
                creditPaymentService.calculate(amountInRubles, periodInYears, interestRatePerYearInPercents));
    }

    // ==================== Test by difference amount ====================
    @Test
    void shouldCalculateYear1Amount0IR10() {
        amountInRubles = 0;
        periodInYears = 1;
        interestRatePerYearInPercents = 10D;

        assertEquals(0,
                creditPaymentService.calculate(amountInRubles, periodInYears, interestRatePerYearInPercents));
    }

    // Тест проходит хотя на самом деле не должен, это связано с тем что возвращаемое значение типа long,
    // когда платёж может составлять доли рублей.
    @Test
    void shouldCalculateYear1Amount1IR10() {
        amountInRubles = 1;
        periodInYears = 1;
        interestRatePerYearInPercents = 10D;

        assertEquals(0,
                creditPaymentService.calculate(amountInRubles, periodInYears, interestRatePerYearInPercents));
    }

    @Test
    void shouldCalculateYear1Amount237684327IR10() {
        amountInRubles = 237684327;
        periodInYears = 1;
        interestRatePerYearInPercents = 10D;

        assertEquals(20_896_228,
                creditPaymentService.calculate(amountInRubles, periodInYears, interestRatePerYearInPercents));

    }

    @Test
    void shouldCalculateYear1AmountMAXIR10() {
        amountInRubles = 1_000_000_000;
        periodInYears = 1;
        interestRatePerYearInPercents = 10D;

        assertEquals(87_915_887,
                creditPaymentService.calculate(amountInRubles, periodInYears, interestRatePerYearInPercents));
    }

    // ==================== Test by difference IR ====================

    //Этот тест нашёл ошибку, добавил отдельный случай для IR == 0
    @Test
    void shouldCalculateYear1Amount1_000_000IR0() {
        amountInRubles = 1_000_000;
        periodInYears = 1;
        interestRatePerYearInPercents = 0;

        assertEquals(83_333,
                creditPaymentService.calculate(amountInRubles, periodInYears, interestRatePerYearInPercents));
    }

    @Test
    void shouldCalculateYear1Amount1_000_000IR50() {
        amountInRubles = 1_000_000;
        periodInYears = 1;
        interestRatePerYearInPercents = 50;

        assertEquals(107_585,
                creditPaymentService.calculate(amountInRubles, periodInYears, interestRatePerYearInPercents));
    }

    //Этот тест нашёл ошибку, добавил Math.round(...) в CreditPaymentService.calculate(...)
    @Test
    void shouldCalculateYear1Amount1_000_000IR100() {
        amountInRubles = 1_000_000;
        periodInYears = 1;
        interestRatePerYearInPercents = 100;

        assertEquals(134_996,
                creditPaymentService.calculate(amountInRubles, periodInYears, interestRatePerYearInPercents));
    }

    @Test
    void shouldCalculateYear1Amount1_000_000IR200() {
        amountInRubles = 1_000_000;
        periodInYears = 1;
        interestRatePerYearInPercents = 200;

        assertEquals(197_769,
                creditPaymentService.calculate(amountInRubles, periodInYears, interestRatePerYearInPercents));
    }

}