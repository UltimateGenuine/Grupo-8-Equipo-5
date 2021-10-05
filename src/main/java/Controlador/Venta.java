package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
import Modelo.ProductoDAO;
import Modelo.ProductoDTO;


@WebServlet("/Venta")
public class Venta extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public Venta() {
    	super();
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ClienteDAO cliDao=new ClienteDAO();
			ProductoDAO proDao=new ProductoDAO();
			
			if(request.getParameter("consultar")!=null) {
				int cedula;
				String nombre;
				cedula=Integer.parseInt(request.getParameter("cedula"));
				ClienteDTO cli=cliDao.Buscar_Cliente(cedula);
				if(cli!=null) {
				cedula=cli.getCedula();
				nombre=cli.getNombre();
				response.sendRedirect("Ventas.jsp?cedula="+cedula+"&&nombre="+nombre);
				}else {
					response.sendRedirect("Ventas.jsp?men=Cliente no encontrado");
				}
			}
			
			if(request.getParameter("consultaruno")!=null) {
				int codigo;
				String producto;
				double iva, precioCom, precioVen;
				codigo=Integer.parseInt(request.getParameter("codigo"));
				ProductoDTO pro=proDao.ConsultarProducto(codigo);
				if(pro!=null) {
				codigo=pro.getCodigo();
				producto=pro.getNombre();
				iva=pro.getIva();
				precioCom=pro.getPrecioCompra();
				precioVen=pro.getPrecioVenta();
				response.sendRedirect("Ventas.jsp?codigo="+codigo+"&&producto="+producto+"&&iva="+iva+"&&precioCom="+precioCom+"&&precioVen="+precioVen);
				}else {
					response.sendRedirect("Ventas.jsp?men=Producto no encontrado");
				}
			}
			
			if(request.getParameter("consultardos")!=null) {
				int codigo;
				String producto;
				double iva, precioCom, precioVen;
				codigo=Integer.parseInt(request.getParameter("codigodos"));
				ProductoDTO pro=proDao.ConsultarProducto(codigo);
				if(pro!=null) {
				codigo=pro.getCodigo();
				producto=pro.getNombre();
				iva=pro.getIva();
				precioCom=pro.getPrecioCompra();
				precioVen=pro.getPrecioVenta();
				response.sendRedirect("Ventas.jsp?codigodos="+codigo+"&&productodos="+producto+"&&ivados="+iva+"&&precioComdos="+precioCom+"&&precioVendos="+precioVen);
				}else {
					response.sendRedirect("Ventas.jsp?men=Producto no encontrado");
				}
			}
			
			if(request.getParameter("consultartres")!=null) {
				int codigo;
				String producto;
				double iva, precioCom, precioVen;
				codigo=Integer.parseInt(request.getParameter("codigotres"));
				ProductoDTO pro=proDao.ConsultarProducto(codigo);
				if(pro!=null) {
				codigo=pro.getCodigo();
				producto=pro.getNombre();
				iva=pro.getIva();
				precioCom=pro.getPrecioCompra();
				precioVen=pro.getPrecioVenta();
				response.sendRedirect("Ventas.jsp?codigotres="+codigo+"&&productotres="+producto+"&&ivatres="+iva+"&&precioComtres="+precioCom+"&&precioVentres="+precioVen);
				}else {
					response.sendRedirect("Ventas.jsp?men=Producto no encontrado");
				}
			}
			
			if(request.getParameter("confirmar")!=null) {
				double valortotaluno,precioCom,cantidaduno,valortotaldos,precioComdos,cantidaddos,valortotaltres,precioComtres,cantidadtres,totalventa,totaliva,precioVen,precioVendos,precioVentres,total;
				precioCom=Double.parseDouble(request.getParameter("precioCom"));
				cantidaduno=Double.parseDouble(request.getParameter("cantidaduno"));
				valortotaluno=precioCom*cantidaduno;
				precioComdos=Double.parseDouble(request.getParameter("precioComdos"));
				cantidaddos=Double.parseDouble(request.getParameter("cantidaddos"));
				valortotaldos=precioComdos*cantidaddos;
				precioComtres=Double.parseDouble(request.getParameter("precioComtres"));
				cantidadtres=Double.parseDouble(request.getParameter("cantidadtres"));
				valortotaltres=precioComtres*cantidadtres;
				totalventa=valortotaluno+valortotaldos+valortotaltres;
				precioVen=Double.parseDouble(request.getParameter("precioVen"));
				precioVendos=Double.parseDouble(request.getParameter("precioVendos"));
				precioVentres=Double.parseDouble(request.getParameter("precioVentres"));
				totaliva=((precioVen*cantidaduno)-valortotaluno)+((precioVendos*cantidaddos)-valortotaldos)+((precioVentres*cantidadtres)-valortotaltres);
				total=totalventa+totaliva;
				response.sendRedirect("Ventas.jsp?valortotaluno="+valortotaluno+"&&cantidaduno="+cantidaduno+"&&valortotaldos="+valortotaldos+"&&cantidaddos="+cantidaddos+"&&valortotaltres="+valortotaltres+"&&cantidadtres="+cantidadtres+"&&totalventa="+totalventa+"&&totaliva="+totaliva+"&&total="+total);
				//response.sendRedirect("Ventas.jsp?valortotaltres="+valortotaltres+"&&cantidadtres="+cantidadtres);
			}
	}

}
