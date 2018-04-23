/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phat.actions;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import phat.dtos.JaegerDTO;
import phat.models.JaegerDAO;

/**
 *
 * @author user
 */
public class ChooseRobotAction {

    private static final String CHOOSE = "choose";
    private static final String LOAD = "load";
    private List<JaegerDTO> listjaeger;

    public ChooseRobotAction() {
    }

    public String execute() throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        String Ability = (String) session.getAttribute("ABI");
        String IdJaeger = (String) session.getAttribute("JaegerId");
        String url = CHOOSE;
        if (IdJaeger == null) {
            JaegerDAO dao = new JaegerDAO();
            dao.ChooseJaeger(Ability);
            listjaeger = dao.getListjaeger();
        }else{
            url = LOAD;
        }

        return url;
    }

    public List<JaegerDTO> getListjaeger() {
        return listjaeger;
    }

}
