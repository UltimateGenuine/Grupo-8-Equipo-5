package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;

/**
 * Servlet implementation class Cliente
 */
@WebServlet("/Cliente")
public class Cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteDAO clDao = new ClienteDAO();
		if(request.getParameter("insertar")!=null) {
			int cedula=0,telefono=0;
			String nombre,correo,direccion;
			
			if(!request.getParameter("cedula").equals("")) {
				cedula = Integer.parseInt(request.getParameter("cedula"));
			}
			if(!request.getParameter("telefono").equals("")) {
				telefono = Integer.parseInt(request.getParameter("telefono"));
			}
			nombre = request.getParameter("nombre");
			correo = request.getParameter("correo");
			direccion = request.getParameter("direccion");
			
			
			ClienteDTO cl = new ClienteDTO(cedula,telefono,nombre,correo,direccion);
			if(clDao.Insertar_Cliente(cl)) {
				//JOptionPane.showMessageDialog(null,"Registro del usuario exitoso..");
				response.sendRedirect("Cliente.jsp?men=Registro de Cliente Exitoso");
			}else {
				//JOptionPane.showMessageDialog(null,"No se registro el usuario..");
				response.sendRedirect("Cliente.jsp?men=No se registro el Cliente");
			}
		}
		//CONSULTAR
		if(request.getParameter("consultar")!=null) {
			int cedula,telefono;
			String nombre,correo,direccion;
			cedula = Integer.parseInt(request.getParameter("cedula"));
			ClienteDTO cl=clDao.Buscar_Cliente(cedula);
			if(cl!=null) {
			cedula=cl.getCedula();
			telefono=cl.getTelefono();
			nombre=cl.getNombre();
			correo=cl.getCorreo();
			direccion=cl.getDireccion();
			
			response.sendRedirect("Cliente.jsp?cedula="+cedula+"&&telefono="+telefono+"&&nombre="+nombre+"&&correo="+correo+"&&direccion="+direccion);
			}else {
				response.sendRedirect("Cliente.jsp?men=El Cliente NO se encontro");
			}
		}
		//ACTUALIZAR
        if(request.getParameter("actualizar")!=null) {
        	int cedula=0,telefono=0;
        	String nombre,correo,direccion;
        	cedula = Integer.parseInt(request.getParameter("cod"));
        	telefono = Integer.parseInt(request.getParameter("telefono"));
        	nombre = request.getParameter("nombre");
        	correo = request.getParameter("correo");
        	direccion = request.getParameter("direccion");
        	
        	ClienteDTO clDto_Act = new ClienteDTO(cedula,telefono,nombre,correo,direccion);
        	if(clDao.Actualizar_Cliente(clDto_Act)) {
        		response.sendRedirect("Cliente.jsp?men=Cliente Actualizado Exitosamente.");
        	}else {
        		response.sendRedirect("Cliente.jsp?men=El Cliente no se Modifico.");
        	}
        	}
        
        //ELIMINAR
        if(request.getParameter("eliminar")!=null) {
        	int cedula;
            cedula = Integer.parseInt(request.getParameter("cod"));
            int op=JOptionPane.showConfirmDialog(null, "Desea Eliminar el Cliente Cedula: "+cedula);
            if(op==0) {
            if(clDao.Eliminar_Cliente(cedula)) {
                response.sendRedirect("Cliente.jsp?men=Cliente Eliminado");
            }else {
                response.sendRedirect("Cliente.jsp?men=Cliente no se elimino");
            }
            }else if(op==1) {
            	response.sendRedirect("Cliente.jsp?men= Cliente  no se elimino");
            }else {
                response.sendRedirect("Cliente.jsp?men= Accion Cancelada");
            }
        }
		
		
		
		
	}

}
