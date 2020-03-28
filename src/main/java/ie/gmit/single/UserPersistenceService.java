

package ie.gmit.single;

public class UserPersistenceService {
    private Store store = new Store (); //Hash map, responsible for dealing with the sore

    public void saveUser(User user) // So people can access this, make this public/ Gives obkect(saveUser)
    {
        store.store(user);
    }
}
