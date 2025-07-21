package entity;

public class Account {

    private Integer id;
    private Integer userId;
    private Double moneyAmmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getMoneyAmmount() {
        return moneyAmmount;
    }

    public void setMoneyAmmount(Double moneyAmmount) {
        this.moneyAmmount = moneyAmmount;
    }

    @Override
    public String toString() {
        return "Account id: " + id + " | User ID: " + userId + " | Balance: " + moneyAmmount;
    }
}
