package PratikPatikaKlonu.Model;

import PratikPatikaKlonu.Helper.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private int id;
    private String name;
    private String username;
    private String pass;
    private String type;

    public User(String name, String username, String pass, String type) {
        this.name = name;
        this.username = username;
        this.pass = pass;
        this.type = type;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setID(Integer id){
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<User> getUserList(){
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user";
        User user;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                user = new User();
                user.setID(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPass(rs.getString("pass"));
                user.setType(rs.getString("usertype"));
                userList.add(user);
                //System.out.println(user.getId() + user.getName() + user.getType());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public static boolean addUser(String name, String username, String pass, String type ){
        boolean key = true;
        String query = "INSERT INTO user (name, username, pass, usertype) VALUES (?,?,?,?) ";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setString(2,username);
            pr.setString(3,pass);
            pr.setString(4,type);
            key = pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return key;
    }

    public static User getFetch(String username){
        User user = null;
        String query = "SELECT * FROM user WHERE username = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,username);
            ResultSet rs = pr.executeQuery();
            if(rs.next()){
                user = new User();
                user.setID(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPass(rs.getString("pass"));
                user.setType(rs.getString("usertype"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    public static boolean deleteUser(int id){
        boolean key = true;
        String query = "DELETE FROM user WHERE id= ?";
        try {
            PreparedStatement pr = null;
            pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            key = pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return key;
    }

    public static boolean updateUser(int id,String name, String username, String pass, String type){
        boolean key = true;
        String query = "UPDATE user SET name=?, username=?, pass=?, usertype=? WHERE id=?";
        boolean ifKey = getFetch(username) != null && getFetch(username).getId() != id;
        boolean ifKey2 = !Arrays.stream(Config.USER_TYPES).anyMatch(str -> str.equals(type));

        if(ifKey || ifKey2 ){
            key = false;
        }   else {
                try {
                    PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
                    pr.setString(1,name);
                    pr.setString(2,username);
                    pr.setString(3,pass);
                    pr.setString(4,type);
                    pr.setInt(5,id);
                    if(pr.executeUpdate() != 1){
                        key = false;
                    }
                } catch (SQLException e) {
                    throw   new RuntimeException(e);
                }
            }

        return key;
    }
    public static boolean searchUser(int id){
        boolean key = true;
        String query = "";

        return key;
    }
}
