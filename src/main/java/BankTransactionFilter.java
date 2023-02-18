@FunctionalInterface
public interface BankTransactionFilter {

    public boolean filter(BankTransaction bankTransaction);
}
