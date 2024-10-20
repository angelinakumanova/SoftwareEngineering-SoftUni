package entities;

import orm.annotations.Column;
import orm.annotations.Entity;
import orm.annotations.Id;

import java.time.LocalDateTime;

@Entity(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "order_datetime")
    private LocalDateTime orderDatetime;

    public Order() {}

    public Order(LocalDateTime orderDatetime) {
        this.orderDatetime = orderDatetime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDatetime=" + orderDatetime +
                '}';
    }
}
