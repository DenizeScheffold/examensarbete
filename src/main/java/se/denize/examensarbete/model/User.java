package se.denize.examensarbete.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="users")
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId;

    private String name;

    public User(String name) {
        this.name = name;
    }


}
