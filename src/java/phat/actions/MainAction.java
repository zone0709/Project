/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phat.actions;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author user
 */
public class MainAction {
    private String action;
    private String username;
    private String password;
    private static final String LOGIN = "login";
    private static final String FAIL = "fail";
    
    public MainAction() {
    }
    
    public String execute() throws Exception {
        String url = FAIL;
        HttpServletRequest request = ServletActionContext.getRequest();
        try {
            if(action.equals("login")){
                url = LOGIN;
            }else{
                request.setAttribute("ERROR", "Action not support!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
}
