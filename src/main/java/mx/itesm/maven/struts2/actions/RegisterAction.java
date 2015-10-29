/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.maven.struts2.actions;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author rodrigo
 */
public class RegisterAction extends ActionSupport{  
private String user,password,name;  
  
//setters and getters  
public String execute(){  
    int i=RegisterDao.save(this);  
    if(i>0){  
    return "success";  
    }
    addFieldError("user","Ya existe el username");
    return "error";  
}

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}  
