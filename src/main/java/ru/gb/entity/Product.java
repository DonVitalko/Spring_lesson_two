package ru.gb.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String title;
    private int cost;

    public Product(int id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", title=" + title +
                ", cost=" + cost;
    }
}
