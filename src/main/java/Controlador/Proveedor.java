package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.ProveedorDAO;
import Modelo.ProveedorDTO;



/**
 * Servlet implementation class Proveedor
 */
@WebServlet("/Proveedor")
public class Proveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Proveedor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProveedorDAO prDao = new ProveedorDAO();
		if(request.getParameter("insertar")!=null) {
			int nit=0,telefono=0;
			String nombre,ciudad,direccion;
			
			if(!request.getParameter("cedula").equals("")) {
				nit = Integer.parseInt(request.getParameter("nit"));
			}
			if(!request.getParameter("telefono").equals("")) {
				telefono = Integer.parseInt(request.getParameter("telefono"));
			}
			nombre = request.getParameter("nombre");
			ciudad = request.getParameter("ciudad");
			direccion = request.getParameter("direccion");
			
			
			ProveedorDTO pr = new ProveedorDTO(nit,telefono,nombre,ciudad,direccion);
			if(prDao.Insertar_Proveedor(pr)) {
				//JOptionPane.showMessageDialog(null,"Registro del usuario exitoso..");
				response.sendRedirect("Proveedor.jsp?men=Registro de Proveedor Exitoso");
			}else {
				//JOptionPane.showMessageDialog(null,"No se registro el usuario..");
				response.sendRedirect("Proveedor.jsp?men=No se registro el Proveedor");
			}
		}
		//CONSULTAR
		if(request.getParameter("consultar")!=null) {
			int nit,telefono;
			String nombre,ciudad,direccion;
			nit = Integer.parseInt(request.getParameter("nit"));
			ProveedorDTO pr=prDao.Buscar_Proveedor(nit);
			if(pr!=null) {
			nit=pr.getNit();
			telefono=pr.getTelefono();
			nombre=pr.getNombre();
			ciudad=pr.getCiudad();
			direccion=pr.getDireccion();
			
			response.sendRedirect("Proveedor.jsp?nit="+nit+"&&telefono="+telefono+"&&nombre="+nombre+"&&ciudad="+ciudad+"&&direccion="+direccion);
			}else {
				response.sendRedirect("Proveedor.jsp?men=El Proveedor NO se encontro");
			}
		}
		//ACTUALIZAR
        if(request.getParameter("actualizar")!=null) {
        	int nit=0,telefono=0;
        	String nombre,ciudad,direccion;
        	nit = Integer.parseInt(request.getParameter("cod"));
        	telefono = Integer.parseInt(request.getParameter("telefono"));
        	nombre = request.getParameter("nombre");
        	ciudad = request.getParameter("ciudad");
        	direccion = request.getParameter("direccion");
        	
        	ProveedorDTO prDto_Act = new ProveedorDTO(nit,telefono,nombre,ciudad,direccion);
        	if(prDao.Actualizar_Proveedor(prDto_Act)) {
        		response.sendRedirect("Proveedor.jsp?men=Proveedor Actualizado Exitosamente.");
        	}else {
        		response.sendRedirect("Proveedor.jsp?men=El Proveedor no se Modifico.");
        	}
        	}
        
        //ELIMINAR
        if(request.getParameter("eliminar")!=null) {
        	int nit;
            nit = Integer.parseInt(request.getParameter("cod"));
            int op=JOptionPane.showConfirmDialog(null, "Desea Eliminar el Proveedor NIT: "+nit);
            if(op==0) {
            if(prDao.Eliminar_Proveedor(nit)) {
                response.sendRedirect("Proveedor.jsp?men=Proveedor Eliminado");
            }else {
                response.sendRedirect("Proveedor.jsp?men=Proveedor no se elimino");
            }
            }else if(op==1) {
            	response.sendRedirect("Proveedor.jsp?men= Proveedor no se elimino");
            }else {
                response.sendRedirect("Proveedor.jsp?men=Accion Cancelada");
            }
        }
		
	}

}
