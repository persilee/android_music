package net.lishaoy.music.utils;

import net.lishaoy.music.model.user.User;

public class UserManager {
    private static UserManager instance;
    private User mUser;

    public UserManager() {
    }

    public static UserManager getInstance() {
        if(instance == null){
            synchronized (UserManager.class) {
                if(instance == null){
                    instance = new UserManager();
                }
            }
        }
        return instance;
    }

    public void saveUser(User user){
        mUser = user;
        saveLocal(user);
    }

    public void saveLocal(User user){

    }

    public User getUser() {
        return mUser;
    }

    public User getLocalUser() {
        return null;
    }

    public boolean hasLogined() {
        return getUser() == null ? false : true;
    }

    public void removeUser() {
        mUser = null;
    }

    public void removeLocalUser() {

    }
}
