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

    @ElementCollection
    private List<String> userPlan;

    public User(String email, long otherParentId, List<String> userPlan) {
        this.email = email;
        this.otherParentId = otherParentId;
        this.userPlan = userPlan;
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


    public void setPlanUser(List<String> JSON){
//TODO: parse incoming json and set to a List to return.
    }

    public List<String> getPlanUser(){
        return userPlan;
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
