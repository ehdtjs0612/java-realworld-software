import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzer {
    private static final String RESOURCE = "/Users/yoodongseon/Desktop/유동선/RealWorldSoftware/src/main/resources/bank-data-simple.csv";

    public static void main(String[] args) throws IOException {
        BankStatementCSVParser parser = new BankStatementCSVParser();

        Path path = Path.of(RESOURCE);
        List<String> lines = Files.readAllLines(path);

        List<BankTransaction> bankTransactions = parser.parseLineFromCSV(lines);

        System.out.println("Your transaction total amount is " + calculateTotalAmount(bankTransactions));
        System.out.println("Your January total amount is " + monthCaclulateTotaAmount(bankTransactions, Month.JANUARY));
    }

    private static Double calculateTotalAmount(List<BankTransaction> bankTransactions) {
        double totalAmount = 0d;

        for(BankTransaction bankTransaction : bankTransactions) {
            totalAmount += bankTransaction.getAmount();
        }

        return totalAmount;
    }

    private static double monthCaclulateTotaAmount(List<BankTransaction> bankTransactions, Month month) {
        double totalAmount = 0d;

        for(BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getLocalDate().getMonth() == month) {
                totalAmount += bankTransaction.getAmount();
            }
        }

        return totalAmount;
    }
}
