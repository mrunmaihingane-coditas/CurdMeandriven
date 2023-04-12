package model;

import dao.BookDaoImple;
import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Entity
public class Book extends BookDaoImple {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int Bid;
    private String bookname;
    private String authername;
    private  String publisher;

    private int publishyear,price;

    @Override
    public String toString() {
        return "model.Book{" +
                "Bid=" + Bid +
                ", bookname='" + bookname + '\'' +
                ", authername='" + authername + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishyear=" + publishyear +
                ", price=" + price +
                '}';
    }

    public int getBid() {
        return Bid;
    }

    public void setBid(int bid) {
        Bid = bid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthername() {
        return authername;
    }

    public void setAuthername(String authername) {
        this.authername = authername;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublishyear() {
        return publishyear;
    }

    public void setPublishyear(int publishyear) {
        this.publishyear = publishyear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
