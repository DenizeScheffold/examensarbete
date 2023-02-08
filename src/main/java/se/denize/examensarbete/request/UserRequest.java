package se.denize.examensarbete.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class UserRequest {

    public UserRequest() {
    }

    public UserRequest(String username, long otherParentId, String email, String password, String role) {
        this.username = username;
        this.otherParentId = otherParentId;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    private String username;
    private long otherParentId;
    private String email;
    private String password;
    private String role;
}
