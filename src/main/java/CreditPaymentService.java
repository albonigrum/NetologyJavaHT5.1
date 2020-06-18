public class CreditPaymentService {
    long calculate(long amountInRubles, long periodInYears, double interestRatePerYearInPercents) {
        double interestRatePerMonth = interestRatePerYearInPercents / 100 / 12;
        long periodInMonths = periodInYears * 12;

        // if (interestRatePerYearInPercents == 0)
        if (interestRatePerYearInPercents < 0.001D && interestRatePerYearInPercents > -0.001D)
            return Math.round(amountInRubles / (double)periodInMonths);

        double coefficientAnnuity = interestRatePerMonth * Math.pow(1 + interestRatePerMonth, periodInMonths) /
                (Math.pow(1 + interestRatePerMonth, periodInMonths) - 1);
        return Math.round(amountInRubles * coefficientAnnuity);
    }
}
