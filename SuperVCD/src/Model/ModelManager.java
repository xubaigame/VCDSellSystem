package Model;

public class ModelManager {
    private static ModelManager _instance;

    public static ModelManager Instance() {
        if(_instance==null)
            _instance=new ModelManager();
        return _instance;
    }

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
