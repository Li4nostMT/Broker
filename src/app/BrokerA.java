package app;

public class BrokerA extends Broker implements Commission {

    private String email;

    public BrokerA(String name, String phone, String email) {
        super(name, phone);
        this.email = email;
    }

    public String infoBroker() {
        String name = getName();
        String phone = getPhone();
        String email = getEmail();
        return "Брокер: " + name + ", Телефон: " + phone + ", Почта: " + email + "\n";
    }

    public String getEmail() {
        return email;
    }

    @Override
    public double calcCommission(double sales) {
        double commission;
        if (sales <= 10000) {
            commission = sales * 0.10;
        } else if (sales > 10000 && sales <= 30000) {
            commission = sales * 0.15;
        } else {
            commission = sales * 0.20;
        }
        return commission;
    }
}
