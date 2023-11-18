package FinalProject;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationServiceImpl implements AuthenticationService {

    private Map<String, String> userCredentials; // Storing username and password
    private Logger logger;

    public AuthenticationServiceImpl(Logger logger) {
        this.userCredentials = new HashMap<>();
        this.logger = logger;

    }
    
    @Override
    public boolean register(User user) {
        // Check if username already exists
        if (userCredentials.containsKey(user.getUsername())) {
            logger.log("Registration failed. Username already exists." + user.getUsername());
            return false; // Username already exists
        }

        // Register new user
        userCredentials.put(user.getUsername(), user.getPassword());
        logger.log("Registration successful." + user.getUsername());
        return true;
    }
    
    @Override
    public boolean login(String username, String password) {
        // Check if username exists and password matches
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            logger.log("Login successful: " + username);
            return true;
        } else {
            logger.log("Login failed: " + username);
            return false;
        }
       
    }
}
