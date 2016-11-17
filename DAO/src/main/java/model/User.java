package model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

public class User implements Serializable{
    private int userId;
    private String userName;
    private String userLogin;
    private String userPassword;

    public User(String userName, String userLogin, String userPassword) {
        this.userId = 0;
        this.userName = userName;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String usernName) {
        this.userName = usernName;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("Id", this.userId)
                .add("name", this.userName)
                .add("login", this.userLogin)
                .add("password", this.userPassword).toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !object.getClass().getName().equals(this.getClass().getName())) {
            return false;
        }

        User that = (User)object;

        return
//                Objects.equal(this.userId, that.userId) &&
                Objects.equal(this.userName, that.userName) &&
                Objects.equal(this.userLogin, that.userLogin) &&
                Objects.equal(this.userPassword, that.userPassword);
    }
}
