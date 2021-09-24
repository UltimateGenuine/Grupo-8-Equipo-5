package Controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import Modelo.ProductoDAO;

/**
 * Servlet implementation class Producto
 */
@WebServlet("/Producto")
@MultipartConfig
public class Producto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Producto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductoDAO proDao = new ProductoDAO();
		
		//ARCHIVO CSV
        if(request.getParameter("cargar")!=null) {
        	Part archivo = request.getPart("archivo");
        	String Url="C://Users//Sergio Castro//eclipse-workspace//Mi_Tienda_Base//src//main//webapp//Documentos//";//Si genera error el backslash poner el otro slash
        	
        	//En Mysql: show variables like 'secure_file_priv'// Error que le salio a la profe
        	//String Url="C:/ProgramaData/MySQL/MySQL Server 8.0/Uploads/";//error que le salio a la profe
        	
        	//Solucion a error java.sql.sqlintegrityconstraintviolationexception cannot add or update a child row ... = crear lsita proveedores primero
        	if(archivo.getContentType().equals("application/vnd.ms-excel")) {
        		try {
        		InputStream file = archivo.getInputStream(); 
        		File copia = new File(Url+"productos.csv");
        		FileOutputStream escribir = new FileOutputStream(copia);
        		int num=file.read();
        		while(num !=-1) {
        			escribir.write(num);
        			num=file.read();
        		}
        		file.close();
        		escribir.close();
        		JOptionPane.showMessageDialog(null, "Se cargo el archivo correctamente");
        		
        		if(proDao.Cargar_Producto(Url+"productos.csv")) {
        			//JOptionPane.showMessageDialog(null, "Se registro producto correctamente");
        			response.sendRedirect("Producto.jsp?men=Se registro producto correctamente");
        		}else {
        			//JOptionPane.showMessageDialog(null, "No se registro producto");
        			response.sendRedirect("Producto.jsp?men=No se registro producto");
        		}
        	}catch(Exception e) {
        		//JOptionPane.showMessageDialog(null,"Error al cargar el archivo" +e);
        		response.sendRedirect("Producto.jsp?men=Error al cargar el archivo");
        		
        	}
        	}else {
        		//JOptionPane.showMessageDialog(null, "Formato de Archivo no permitido");
        		response.sendRedirect("Producto.jsp?men=Formato de Archivo no permitido");
        	}
        }
	}

}
