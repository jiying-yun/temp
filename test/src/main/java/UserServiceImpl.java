

public class UserServiceImpl implements IUerSerivce {

    public User findUserById(Integer id){
        return new User(id, "userA");
    }
}
