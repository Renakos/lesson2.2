public class BankAccount {
    private double amount;

    public BankAccount(double initialAmount) {
        this.amount = initialAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void deposit(double sum) {
        if (sum > 0) {
            amount += sum;
            System.out.println("Депозит на " + sum + " успешно выполнен.");
        } else {
            System.out.println("Неверная сумма для депозита.");
        }
    }

    public void withdraw(double sum) {
        if (sum > 0) {
            if (sum <= amount) {
                amount -= sum;
                System.out.println("Снятие " + sum + " успешно выполнено.");
            } else {
                System.out.println("Недостаточно средств на счете.");
                throw new IllegalArgumentException("Недостаточно средств на счете");
            }
        } else {
            System.out.println("Неверная сумма для снятия.");
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        System.out.println("Текущий баланс: " + account.getAmount());

        account.deposit(500);
        System.out.println("Текущий баланс после депозита: " + account.getAmount());

        try {
            account.withdraw(1500);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Текущий баланс после снятия: " + account.getAmount());
    }
}
