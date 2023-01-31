package se.denize.examensarbete.serviceImpl;

import org.springframework.stereotype.Service;
import se.denize.examensarbete.dataObjects.UserDTO;
import se.denize.examensarbete.model.User;

@Service
public class UserMappingService {

    public UserDTO convertEntityToDTO(User user){

        return new UserDTO(user);
    }

}
