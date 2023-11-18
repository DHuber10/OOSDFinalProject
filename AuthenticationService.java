package FinalProject;

public interface AuthenticationService {

    boolean login(String username, String password);
    boolean register(User user);

    
    
}
