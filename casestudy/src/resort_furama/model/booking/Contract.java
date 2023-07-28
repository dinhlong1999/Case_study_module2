package resort_furama.model.booking;

public class Contract {
    private int contractNumber;
    private String idBooking;
    private int reserveMoney;
    private int moneyPayments;

    public Contract(int contractNumber, String idBooking, int reserveMoney, int moneyPayments) {
        this.contractNumber = contractNumber;
        this.idBooking = idBooking;
        this.reserveMoney = reserveMoney;
        this.moneyPayments = moneyPayments;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public int getReserveMoney() {
        return reserveMoney;
    }

    public void setReserveMoney(int reserveMoney) {
        this.reserveMoney = reserveMoney;
    }

    public int getMoneyPayments() {
        return moneyPayments;
    }

    public void setMoneyPayments(int moneyPayments) {
        this.moneyPayments = moneyPayments;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber=" + contractNumber +
                ", idBooking=" + idBooking +
                ", reserveMoney=" + reserveMoney +
                ", moneyPayments=" + moneyPayments +
                '}';
    }
}
