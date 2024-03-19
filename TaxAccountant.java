import java.util.Scanner;

public class TaxAccountant {
    public static void main(String[] args) {
// declare variables
        int customerID = 0;
        double totalEarnings = 0.0;
        double deductions = 0.0;
        double taxableIncome = 0.0;
        double federalTaxes = 0.0;
        double stateTaxes = 0.0;
        double federalTaxesWH = 0.0;
        double stateTaxesWH = 0.0;
        double federalRefund = 0.0;
        double stateRefund = 0.0;
        String output = new String();
        output += "\n\nCust.                   Taxable Federal State Federal State Federal State \n";
            output += " ID   Income Deductions Income    Tax    Tax    W/H    W/H  Refund  Refund\n";
            output += "===== ====== ========== ======= ======= ===== ======= ===== ======= ======\n";
        
// Create a Scanner input object
        Scanner input = new Scanner(System.in);
        
// Begin first customer
// Get first Customer ID
        System.out.print("Hello, please enter your Customer ID: ");
        customerID = input.nextInt();

        while(customerID != -1){
            
        // Get income and withholding information
            System.out.print("Please enter your total income for the year: ");
            totalEarnings = input.nextDouble();
            System.out.print("Please enter your deductions for the year: ");
            deductions = input.nextDouble();
            taxableIncome = totalEarnings - deductions;
            System.out.print("Please enter your Withheld Federal Taxes for the year: ");
            federalTaxesWH = input.nextDouble();
            System.out.print("Please enter your Withheld State Taxes for the year: ");
            stateTaxesWH = input.nextDouble();
            
        // Calculate taxes due/refunds
            if (taxableIncome <= 10000.0){
                federalTaxes = 0.0;
            }else
                if(taxableIncome <= 45000.0){
                    federalTaxes = (taxableIncome - 10000.0) * 0.15;
                }else
                    if(taxableIncome <= 70000.0){
                        federalTaxes = (taxableIncome - 45000.0) * 0.2 + 35000.0 * 0.15;
                    }else
                        federalTaxes = (taxableIncome - 70000.0) * 0.3 + 25000.0 * 0.2 + 35000.0 * 0.15;
            stateTaxes = federalTaxes * 0.07;
            federalRefund = federalTaxesWH - federalTaxes;
            stateRefund = stateTaxesWH - stateTaxes;
            
        // Add data to output String
            output += String.format("%3d   $%5.0f  $%5.0f    $%5.0f  $%5.0f  $%3.0f  $%5.0f  $%4.0f  $%4.0f  $%4.0f\n",
                  customerID, totalEarnings, deductions, taxableIncome, federalTaxes, stateTaxes, federalTaxesWH, stateTaxesWH,
                  federalRefund, stateRefund);
            
        // Get next Customer ID
            System.out.print("Please enter the next Customer ID: ");
            customerID = input.nextInt();
        }
// Print out table of data and end program
        System.out.println(output);
   }
}