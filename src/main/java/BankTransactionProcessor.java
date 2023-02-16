import java.time.Month;
import java.util.List;

public class BankTransactionProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankTransactionProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public Double calculateTotalAmount() {
        double totalAmount = 0d;

        for(BankTransaction bankTransaction : bankTransactions) {
            totalAmount += bankTransaction.getAmount();
        }

        return totalAmount;
    }

    public double monthCaclulateTotaAmount(Month month) {
        double totalAmount = 0d;

        for(BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getLocalDate().getMonth() == month) {
                totalAmount += bankTransaction.getAmount();
            }
        }

        return totalAmount;
    }

    public double yourCategoryCalculateTotalAmount(String category) {
        double totalAmount = 0d;

        for(BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDescription().equals(category)) {
                totalAmount += bankTransaction.getAmount();
            }
        }

        return totalAmount;
    }
}
