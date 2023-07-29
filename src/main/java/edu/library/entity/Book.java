package edu.library.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Book {
    private Integer bookId;

    @NotBlank(message = "书名不能为空")
    private String bookName;

    @NotBlank(message = "ISBN不能为空")
    private String isbn;

    @NotBlank(message = "作者不能为空")
    private String author;

    @NotBlank(message = "出版社不能为空")
    private String press;

//    @NotBlank(message = "图书类型不能为空")
    private Integer type;

    private String typestr;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "出版日期不能在当前时间之后")
    private Date publicationDate;

    @DecimalMin(value = "0.00",message = "价格必须大于或者等于0.00")
    private BigDecimal price;

    private Boolean status;

    private Date createTime;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypestr() {
        return typestr;
    }

    public void setTypestr(String typestr) {
        this.typestr = typestr;
    }
    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", type=" + type +
                ", typestr=" + typestr +
                ", publicationDate=" + publicationDate +
                ", price=" + price +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}