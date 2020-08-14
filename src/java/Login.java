
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexander
 */
@ManagedBean
@RequestScoped
public class Login implements Serializable {
   private String usuario;
   private String contraseña;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

   
     public void ingresar() {
         FacesContext context = FacesContext.getCurrentInstance();
        if (usuario.equals("admin") && contraseña.equals("1234")) {
            context.addMessage(null, new FacesMessage("Successful",  "Ingreso Correctamente") );
            
        } else {
            context.addMessage(null, new FacesMessage("Error",  "Datos Erroneos") );
            
        }
   }
}
