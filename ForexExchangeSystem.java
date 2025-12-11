import java.util.Scanner;
class ForexExchangeSystem {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      String[] currencies = {"USD", "EUR", "JPY", "GBP", "AUD"};
      String[] dates = {"Nov 1", "Nov 2", "Nov 3", "Nov 4", "Nov 5",};
      double[][] rates = new double[5][5];
      
      for (int x = 0; x < currencies.length; x++) {
         System.out.println("Currency: " + currencies[x]);
         for (int day = 0; day < dates.length; day++) {
            System.out.print("Rate on " + dates[day] + ": ");
            rates[x][day] = input.nextDouble();
         }
         System.out.println();
      }
      
      System.out.println("=================== FOREX SUMMARY (Nov 1 - Nov 5) ======================");
      System.out.printf("%-9s | %-8s %-8s %-8s %-8s %-8s %-8s %-8s%n", 
                         "Currency", "Nov1", "Nov2", "Nov3", "Nov4", "Nov5", "Peak", "Lowest");
      System.out.println("-------------------------------------------------------------------------");
      
      for (int x = 0; x < currencies.length; x++) {
         double peak = rates[x][0];
         double lowest = rates[x][0];
         for (int i = 0; i < 5; i++) {
            if (rates[x][i] > peak) peak = rates[x][i];
            if (rates[x][i] < lowest) lowest = rates[x][i];
         }
         System.out.printf("%-9s | ", currencies[x]);
         for (int i = 0; i < 5; i++) {
            System.out.printf("%-8.2f ", rates[x][i]);
         }
         System.out.printf("%-8.2f %-8.2f%n", peak, lowest);
      }
      System.out.println("-------------------------------------------------------------------------\n");
      
      System.out.println("=== DAILY CHANGES (Comparison From Previous Day) ===");
      System.out.println("(+ increase / - decrease / no change for same value)");
      
      for (int x = 0; x < currencies.length; x++) {
         System.out.println("Currency: " + currencies[x]);
         
         for (int day = 0; day < 4; day++) {
            double day1 = rates[x][day];
            double day2 = rates[x][day + 1];
            double diff = day2 - day1;
            
            System.out.print(dates[day] + " -> " + dates[day + 1] + ": ");
            if (diff == 0) {
               System.out.println("no change for same value");
            }
            else if (diff > 0) {
               System.out.printf("+ %.2f%n", diff);
            }
            else {
               System.out.printf("- %.2f%n", diff * -1);
            }
            System.out.println();
         }
      }
      
   }
}
