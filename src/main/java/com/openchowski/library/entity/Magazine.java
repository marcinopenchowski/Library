package com.openchowski.library.entity;

import javax.persistence.*;

@Entity
@Table(name = "magazine")
public class Magazine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;


    public Magazine() {
    }

    public Magazine(Item item) {
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }


    @Override
    public String toString() {
        return "Magazine{" +
                "id=" + id +
                ", item=" + item +
                '}';
    }
}
