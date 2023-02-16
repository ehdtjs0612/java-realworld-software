import java.time.LocalDate;
import java.util.Objects;

public class BankTransaction {
    private final LocalDate localDate;
    private final Double amount;
    private final String description;

    public BankTransaction(LocalDate localDate, Double amount, String description) {
        this.localDate = localDate;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public Double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "localDate=" + localDate +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankTransaction)) return false;
        BankTransaction that = (BankTransaction) o;
        return Objects.equals(getLocalDate(), that.getLocalDate()) && Objects.equals(getAmount(), that.getAmount()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocalDate(), getAmount(), getDescription());
    }
}
