package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
import Modelo.ReporteDAO;
import Modelo.ReporteDTO;
import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;

@WebServlet("/Reportes")
public class Reportes extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Reportes() {
    	super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("opcion");
		PrintWriter salida= response.getWriter();
        Gson datos= new Gson();
        
        if(op.equals("Usuario")) {
        	UsuarioDAO usuDao= new UsuarioDAO();
        	ArrayList<UsuarioDTO> lista= new ArrayList<>();
        	lista=usuDao.cargarUsuarios();
        	salida.println(datos.toJson(lista));
        }
        
        if(op.equals("Cliente")) {
        	ClienteDAO cliDao= new ClienteDAO();
        	ArrayList<ClienteDTO> lista= new ArrayList<>();
        	lista=cliDao.cargarClientes();
        	salida.println(datos.toJson(lista));
        }
        
        if(op.equals("Venta")) {
        	ReporteDAO repDao= new ReporteDAO();
        	ArrayList<ReporteDTO> lista= new ArrayList<>();
        	lista=repDao.cargarReporte();
        	salida.println(datos.toJson(lista));
        }
	}

}
