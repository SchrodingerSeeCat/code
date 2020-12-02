package entity;

public class Account {
    private int id;
    private String userName;
    private int money;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public int getMoney() {
        return money;
    }
}
