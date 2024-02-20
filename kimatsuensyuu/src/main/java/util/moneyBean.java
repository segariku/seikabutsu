package util;

public class moneyBean {


    public moneyBean(int user_id, int money) {
        this.user_id = user_id;
        this.money = money;
    }

    private int user_id;
    private int money;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

}
