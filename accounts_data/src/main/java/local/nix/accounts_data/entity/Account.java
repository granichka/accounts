package local.nix.accounts_data.entity;

import local.nix.accounts_data.AbstractData;

import java.math.BigDecimal;


public class Account extends AbstractData<Account> {

    private String code;
    private String phoneNumber;
    private BigDecimal amount;

    public Account(final String code)  {
        this.code = code;
    }


    public class MoneyBox {

        private BigDecimal deposit;

        public void addMoneyToMoneyBox(BigDecimal amount) {
                if (amount.compareTo(new BigDecimal(0)) == -1) {

                    throw new IllegalArgumentException("Попытка добавить отрицательную сумму");

                } else {

                    if(Account.this.amount.compareTo(amount) == -1) {
                        throw new IllegalArgumentException("Недостаточно денег на счету для перевода в копилку");
                    } else {
                        Account.this.amount.subtract(amount);
                        deposit.add(amount);
                    }

                }
        }

        public void withdrawMoneyFromMoneyBox(BigDecimal amount) {
                    if(amount.compareTo(new BigDecimal(0)) == -1) {

                        throw new IllegalArgumentException("Попытка добавить отрицательную сумму");

                    } else {

                        if(deposit.compareTo(amount) == -1) {
                            throw new IllegalArgumentException("Недостаточно денег в копилке для снятия");
                        } else {
                            deposit.subtract(amount);
                            Account.this.amount.add(amount);
                        }

                    }
        }

        public BigDecimal getDeposit() {
            return deposit;
        }
    }


    public String getCode() {
        return code;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void addMoneyToAccount(BigDecimal account) {
            if(account.compareTo(new BigDecimal(0)) == -1) {
                throw new IllegalArgumentException("Попытка добавить отрицательную сумму");
            } else {
                this.amount.add(amount);
            }
    }

    public void withdrawMoneyFromAccount(BigDecimal account) {
            if(account.compareTo(new BigDecimal(0)) == -1) {

                throw new IllegalArgumentException("Попытка отнять отрицательную сумму");

            } else {

                if(this.amount.compareTo(amount) == -1) {

                    throw new IllegalArgumentException("Недостаточно денег на счету для снятия");

                } else {

                    this.amount.subtract(amount);
                }

            }
    }


}
