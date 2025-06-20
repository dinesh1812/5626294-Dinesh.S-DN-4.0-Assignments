import java.util.*;
public class FinancialForecast {
    public static double forecast(double price , double growthRate, int years){
        if(years == 0){
            return price;
        }
        return forecast(price, growthRate, years - 1) * (1 + growthRate);
    }public static void main(String[] args) {
        double price = 10000.0;
        double growthRate = 0.05;
        int years = 5;

        double futureValue = forecast(price, growthRate, years);
        System.out.printf("Future value after %d years: Rs.%.2f\n", years, futureValue);
    }
}

/*
 * In this program, I have calculated the price over every year and multiplied them using Recursion to get the Forecasted price.
 - Time Complexity : O(n)
 - Space Complexity : O(n)

 * Problems:
        - For large n values , it might cause Stack Overflow.
        - Excessive Computation which increases Time and Space Complexities.
 * How to Optimize
        - To optimize the code, we can use Iteration (for loop).
*/
