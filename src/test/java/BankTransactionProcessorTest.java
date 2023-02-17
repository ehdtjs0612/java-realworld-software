import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BankTransactionProcessorTest {

    List<BankTransaction> bankTransactionList;
    BankTransactionProcessor bankTransactionProcessor;
    @BeforeEach
    public void setUp() {
        bankTransactionList = createBankTransaction();
        bankTransactionProcessor = new BankTransactionProcessor(bankTransactionList);
    }

    private List<BankTransaction> createBankTransaction() {
        List<BankTransaction> bankTransactionList = new ArrayList<>();
        bankTransactionList.add(new BankTransaction((LocalDate.of(2017, Month.JANUARY, 30)), -100d, "Deliveroo"));
        bankTransactionList.add(new BankTransaction((LocalDate.of(2017, Month.JANUARY, 30)), -50d, "Tesco"));
        bankTransactionList.add(new BankTransaction((LocalDate.of(2017, Month.FEBRUARY, 01)), 6000d, "Salary"));
        bankTransactionList.add(new BankTransaction((LocalDate.of(2017, Month.FEBRUARY, 02)), 2000d, "Royalties"));
        bankTransactionList.add(new BankTransaction((LocalDate.of(2017, Month.FEBRUARY, 03)), -4000d, "Rent"));
        bankTransactionList.add(new BankTransaction((LocalDate.of(2017, Month.MARCH, 03)), 3000d, "Tesco"));
        bankTransactionList.add(new BankTransaction((LocalDate.of(2017, Month.MAY, 05)), -30d, "Cinema"));
        return bankTransactionList;
    }

    @Test
    public void calculateTotalAmount() {
        // given
        double total = 6820d;

        // when
        Double totalAmount = bankTransactionProcessor.calculateTotalAmount();

        // then
        assertThat(totalAmount).isEqualTo(total);
    }
}