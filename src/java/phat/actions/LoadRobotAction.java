/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phat.actions;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import phat.dtos.JaegerdetailDTO;
import phat.models.JaegerDAO;

/**
 *
 * @author user
 */
public class LoadRobotAction {
    private List<JaegerdetailDTO> jaegerdetail;
    private static final String SUCCESS = "success";
    public LoadRobotAction() {
    }
    
    public String execute() throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        String IdJaeger = (String) session.getAttribute("JaegerId");
        if(IdJaeger != null){
            JaegerDAO dao = new JaegerDAO();
            dao.LoadJaeger(IdJaeger);
            jaegerdetail = dao.getJagerdetail();
        }
        return SUCCESS;
    }

    public List<JaegerdetailDTO> getJaegerdetail() {
        return jaegerdetail;
    }
    
    
}
