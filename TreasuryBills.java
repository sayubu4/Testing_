import java.util.Scanner;
class TreasuryBills {

public static double computeInvestmentValue(double principal, double rate, int periodsPerYear, double sec_deposit, int total_period) {
double total_invest = principal;
double ratePerPeriod = rate / periodsPerYear;    
for (int i = 0; i < total_period; i++) {
total_invest = total_invest * (1 + ratePerPeriod) + sec_deposit;
}   
return total_invest;
}
public static void main(String[]args){

Scanner input = new Scanner(System.in);
System.out.println("Kindly enter the principal amount: ");
double principal = input.nextDouble();
System.out.println("Kindly enter the yearly rate: ");
double rate = input.nextDouble();
System.out.println("Kindly enter the number of times the interest is compounded each year: ");
int periodsPerYear = input.nextInt();
System.out.println("Kindly enter the amount you will add to the account in each period after the deposit  : ");
double sec_deposit = input.nextDouble();
System.out.println("Kindly enter the number of periods the investment will accrue over(total period): ");
int total_period = input.nextInt();

double total_invest = computeInvestmentValue(principal, rate, periodsPerYear, sec_deposit, total_period);
double total_interest_overTime = total_invest - (principal + sec_deposit * total_period);
System.out.printf("The total value of the investement is: %.2f%n", total_invest);
System.out.printf("The total interest earned over a period of time is: %.2f%n", total_interest_overTime);

}
}


