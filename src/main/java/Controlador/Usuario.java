package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;

/**
 * Servlet implementation class Usuario
 */
@WebServlet("/Usuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO usDao = new UsuarioDAO();
		if(request.getParameter("insertar")!=null) {
			int cedula=0;
			String usuario,nombre,contraseña,correo;
			
			if(!request.getParameter("cedula").equals("")) {
				cedula = Integer.parseInt(request.getParameter("cedula"));
			}
			usuario = request.getParameter("usuario");
			nombre = request.getParameter("nombre");
			contraseña = request.getParameter("contraseña");
			correo = request.getParameter("correo");
			
			
			UsuarioDTO us = new UsuarioDTO(cedula,usuario,nombre,contraseña,correo);
			if(usDao.Insertar_Usuario(us)) {
				//JOptionPane.showMessageDialog(null,"Registro del usuario exitoso..");
				response.sendRedirect("Usuario.jsp?men=Registro de Usuario Exitoso");
			}else {
				//JOptionPane.showMessageDialog(null,"No se registro el usuario..");
				response.sendRedirect("Usuario.jsp?men=No se registro el usuario");
			}
		}
		//CONSULTAR
		if(request.getParameter("consultar")!=null) {
			int cedula;
			String usuario,nombre,contraseña,correo;
			cedula = Integer.parseInt(request.getParameter("cedula"));
			UsuarioDTO us=usDao.Buscar_Usuario(cedula);
			if(us!=null) {
			cedula=us.getCedula();
			usuario=us.getUsuario();
			nombre=us.getNombre();
			contraseña=us.getContraseña();
			correo=us.getCorreo();
			
			response.sendRedirect("Usuario.jsp?cedula="+cedula+"&&usuario="+usuario+"&&nombre="+nombre+"&&contraseña="+contraseña+"&&correo="+correo);
			}else {
				response.sendRedirect("Usuario.jsp?men=El Usuario NO se encontro");
			}
		}
		//ACTUALIZAR
        if(request.getParameter("actualizar")!=null) {
        	int cedula=0;
        	String usuario,nombre,contraseña,correo;
        	cedula = Integer.parseInt(request.getParameter("cod"));
        	usuario = request.getParameter("usuario");
        	nombre = request.getParameter("nombre");
        	contraseña = request.getParameter("contraseña");
        	correo = request.getParameter("correo");
        	
        	UsuarioDTO usDto_Act = new UsuarioDTO(cedula,usuario,nombre,contraseña,correo);
        	if(usDao.Actualizar_Usuario(usDto_Act)) {
        		response.sendRedirect("Usuario.jsp?men=Usuario Actualizado Exitosamente.");
        	}else {
        		response.sendRedirect("Usuario.jsp?men=El Usuario no se Modifico.");
        	}
        	}
        
        //ELIMINAR
        if(request.getParameter("eliminar")!=null) {
        	int cedula;
            cedula = Integer.parseInt(request.getParameter("cod"));
            int op=JOptionPane.showConfirmDialog(null, "Desea Eliminar el Usuario Cedula: "+cedula);
            if(op==0) {
            if(usDao.Eliminar_Usuario(cedula)) {
                response.sendRedirect("Usuario.jsp?men=Usuario Eliminado");
            }else {
                response.sendRedirect("Usuario.jsp?men=Usuario no se elimino");
            }
            }else if(op==1) {
            	response.sendRedirect("Usuario.jsp?men= Usuario no se elimino");
            }else {
                response.sendRedirect("Usuario.jsp?men=Accion Cancelada");
            }
        }
	}

}
