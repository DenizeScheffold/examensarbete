package se.denize.examensarbete.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "email")
    private String email;

    @Column(name = "other_parent_id")
    private long otherParentId;


    public User(String email, long otherParentId) {
        this.email = email;
        this.otherParentId = otherParentId;
    }

    public User() {

    }


    public long getUserId(){
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public long getOtherParentId() {
        return otherParentId;
    }


}
