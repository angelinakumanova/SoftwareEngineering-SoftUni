package bg.softuni.pathfinder.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "messages")
public class Message extends BaseEntity {
    @Column(nullable = false, name = "date_time")
    private Instant dateTime;
    @Column(name = "text_content", nullable = false)
    private String content;

    @ManyToOne(optional = false)
    private User author;

    @ManyToOne(optional = false)
    private User recipient;

    public Message() {}

    public Instant getDateTime() {
        return dateTime;
    }

    public void setDateTime(Instant dateTime) {
        this.dateTime = dateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
}
