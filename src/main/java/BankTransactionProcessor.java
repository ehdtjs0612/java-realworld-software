import java.time.Month;
import java.util.ArrayList;
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

    public double monthCaclulateTotalAmount(Month month) {
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

    //특정 금액 이상의 은행 거래 내역 찾기
    public List<BankTransaction> findTransactionGreaterThanEqaul(int amount) {
        List<BankTransaction> result = new ArrayList<>();

        for(BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getAmount() >= amount) {
                result.add(bankTransaction);
            }
        }

        return result;
    }
}
