package ie.gmit.single;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {

    //Handles incoming JSON requests that work on User resource/entity

        //Store used by controller
        Store store = new Store();

    //Validates the user object
    boolean isValidUser(User user) {
            if(!isPresent(user.getName())) {
                return false;
            }

            user.setName(user.getName().trim());

            if(!isValidAlphaNumeric(user.getName())) {
                return false;
            }
            if(user.getEmail() == null || user.getEmail().trim().length() == 0) {
                return false;
            }
            user.setEmail(user.getEmail().trim());
            if(!isValidEmail(user.getEmail())) {
                return false;
            }
            return true;
        }

        //Simply checks if value is null or empty..
        private boolean isPresent(String value) {
            return value != null && value.trim().length() > 0;
        }
        //check string for special characters
        private boolean isValidAlphaNumeric(String value) {
            Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
            Matcher matcher = pattern.matcher(value);
            return !matcher.find();
        }
        //check string for valid email address - this is not for prod.
        //Just for demo. This fails for lots of valid emails.
        private boolean isValidEmail(String value) {
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher matcher = pattern.matcher(value);
            return matcher.find();
        }


    private UserPersistenceService persistenceService = new UserPersistenceService();


    //Create a new user
    public String createUser(String userJson, Store store) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        User user = mapper.readValue(userJson, User.class); // Takes information maps it, String gets map,

        ValidateUser myUser = new ValidateUser();

        boolean checkUser = myUser.checkUser(user);

        if(!checkUser) {
            return "ERROR";
        }

        persistenceService.saveUser(user); // Information is stored here


        return "SUCCESS";
    }
}

