package com.tienda.services.impl;

import com.tienda.domain.Usuario;
import com.tienda.services.RegistroService;
import com.tienda.services.UsuarioService;
import jakarta.mail.MessagingException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public class RegistroServiceImpl implements RegistroService {
    
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Model crearUsuario(Model model, Usuario usuario) throws MessagingException {
        String mensaje;
        if (!usuarioService.existeUsuarioPorUsernameOCorreo(
                usuario.getUsername(), 
                usuario.getCorreo())) {
            String clave="xyz";
            usuario.setPassword(clave);
            usuario.setActivo(false);
            usuarioService.save(usuario, true);
            enviarCorreoActivacion(usuario);
            ///
        } else {  //El username o el correo ya existen
            
        }
        return null;
    }

    @Override
    public Model activarUsuario(Model model, String username, String clave) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Model habilitaUsuario(Usuario usuario, MultipartFile imagenFile) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Model recordarUsuario(Model model, Usuario usuario) throws MessagingException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //Continuar acá
    private void enviarCorreoActivacion(Usuario usuario) throws MessagingException {
        //String mensaje=messageSource.getMessage("registro.correo.activar",null,Locale.getDefault());
    }
    
}
