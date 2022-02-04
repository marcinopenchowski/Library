package com.openchowski.library.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "language")
    private String language;

    @Column(name = "status")
    private String status;

    @ManyToMany
    @JoinTable(
            name = "item_author",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authorList;

    @ManyToMany
    @JoinTable(
            name = "borrow_item",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "borrow_id")
    )
    private List<Borrow> borrowList;

    @ManyToOne
    @JoinColumn(name = "publisherId")
    private Publisher publisher;

    public Item() {
    }

    public Item(String title, String language, String status, List<Author> authorList, List<Borrow> borrowList, Publisher publisher) {
        this.title = title;
        this.language = language;
        this.status = status;
        this.authorList = authorList;
        this.borrowList = borrowList;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Borrow> getBorrowList() {
        return borrowList;
    }

    public void setBorrowList(List<Borrow> borrowList) {
        this.borrowList = borrowList;
    }


    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", status='" + status + '\'' +
                ", authorList=" + authorList +
                ", borrowList=" + borrowList +
                ", publisher=" + publisher +
                '}';
    }
}
