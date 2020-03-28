package ie.gmit.single;

public class ValidateUser {

    public boolean checkUser(User user)
    {
        return isValidUser(user);
    }

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

    private boolean isValidEmail(String email) {
        return true;
    }

    private boolean isValidAlphaNumeric(String name) {
        return true;
    }

    private boolean isPresent(String name) {

        return true;
    }
}
