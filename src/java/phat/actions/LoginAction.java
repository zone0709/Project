/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phat.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import phat.models.UserDAO;

/**
 *
 * @author user
 */
public class LoginAction {
    private static final String ADMIN = "admin";
    private static final String USER = "user";
    private static final String FAIL = "fail";
    private String username;
    private String password;
    private String id;
    public LoginAction() {
        
    }
    
    public String execute() throws Exception {
        String url = FAIL;
        UserDAO dao = new UserDAO();
        String role = dao.checkLogin(username, password);
        HttpServletRequest request = ServletActionContext.getRequest();
        if(role.equals("fail")){
            request.setAttribute("ERROR", "Invalid Id or Password!");
        }else if(role.equals("admin")){
            url = ADMIN;
        }else if(role.equals("user")){
            url = USER;
        }else{
            request.setAttribute("ERROR", "Role not support!!");
        }
        return url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
}
