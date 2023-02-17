import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BankTransactionProcessorTest {

    private List<BankTransaction> bankTransactionList;
    private BankTransactionProcessor bankTransactionProcessor;
    private Month month;
    private String category;
    private int greaterThan;

    @BeforeEach
    public void setUp() {
        bankTransactionList = createBankTransaction();
        bankTransactionProcessor = new BankTransactionProcessor(bankTransactionList);
        month = Month.MAY;
        category = "Tesco";
        greaterThan = 3000;
    }

    private List<BankTransaction> createBankTransaction() {
        List<BankTransaction> bankTransactionList = new ArrayList<>();
        bankTransactionList.add(new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -100d, "Deliveroo"));
        bankTransactionList.add(new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50d, "Tesco"));
        bankTransactionList.add(new BankTransaction(LocalDate.of(2017, Month.FEBRUARY, 01), 6000d, "Salary"));
        bankTransactionList.add(new BankTransaction(LocalDate.of(2017, Month.FEBRUARY, 02), 2000d, "Royalties"));
        bankTransactionList.add(new BankTransaction(LocalDate.of(2017, Month.FEBRUARY, 03), -4000d, "Rent"));
        bankTransactionList.add(new BankTransaction(LocalDate.of(2017, Month.MARCH, 03), 3000d, "Tesco"));
        bankTransactionList.add(new BankTransaction(LocalDate.of(2017, Month.MAY, 05), -30d, "Cinema"));
        return bankTransactionList;
    }

    @Test
    public void testCalculateTotalAmount() {
        // given
        double expected = 6820d;

        // when
        Double actual = bankTransactionProcessor.calculateTotalAmount();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testMonthCalculateTotalAmount() {
        // given
        double expected = -30d;

        // when
        double actual = bankTransactionProcessor.monthCaclulateTotalAmount(month);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testYourCategoryCalculateTotalAmount() {
        // given
        double expected = 2950d;

        // when
        double actual = bankTransactionProcessor.yourCategoryCalculateTotalAmount(category);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testFindTransactionGreaterThanEqaul() {
        // given
        List<BankTransaction> expected = List.of(
                new BankTransaction(LocalDate.of(2017, Month.FEBRUARY, 01), 6000d, "Salary"),
                new BankTransaction(LocalDate.of(2017, Month.MARCH, 03), 3000d, "Tesco")
        );

        // when
        List<BankTransaction> actual = bankTransactionProcessor.findTransactionGreaterThanEqaul(greaterThan);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testFindTransactionInMonth() {
        // given
        List<BankTransaction> expected = List.of(
                new BankTransaction(LocalDate.of(2017, Month.MAY, 05), -30d, "Cinema")
        );

        // when
        List<BankTransaction> actual = bankTransactionProcessor.findTransactionInMonth(month);

        // then
        assertThat(expected).isEqualTo(actual);
    }
}