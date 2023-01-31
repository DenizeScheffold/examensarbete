package se.denize.examensarbete.dataObjects;

import java.util.List;

public class UserDTO {
    private final String username;
    private final List<String> authorities;


    public UserDTO(String username, List<String> authorities) {
        this.username = username;
        this.authorities = authorities;
    }
}
