package se.denize.examensarbete.model;


import jakarta.persistence.*;


import java.util.Map;

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




//private Map<Weekday, String> planUser;


    /*
    private Map<Weekday, String> planUserA = new LinkedHashMap<>();
    private List<String> planUserB;


    public void setPlanUserA() {
        Map<Weekday, String> planUserA = Stream.of(new Object[][] {

            {Weekday.MONDAY, "Y"},
            {Weekday.TUESDAY, "Y"},
            }).collect(Collectors.toMap(data -> (Weekday) data[0], data -> (String) data[1]));



    }*/

}
