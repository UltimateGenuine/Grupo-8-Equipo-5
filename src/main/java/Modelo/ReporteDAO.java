package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ReporteDAO {
	Conexion cnn = new Conexion();
	Connection con = cnn.Conecta();
    PreparedStatement ps=null;
    ResultSet res=null;
    
    public ArrayList<ReporteDTO> cargarReporte(){
    	ReporteDTO rep=null;
    	ArrayList<ReporteDTO> lista=new ArrayList<>();
    	try {
    		String sql = "select c.cedula_cliente,c.nombre_cliente,sum(v.total_venta) from clientes as c inner join ventas as v on c.cedula_cliente = v.cedula_cliente group by v.cedula_cliente";
    		ps=con.prepareStatement(sql);
    		res=ps.executeQuery();
    		while(res.next()) {
    			rep=new ReporteDTO(res.getInt(1),res.getString(2),res.getDouble(3));
    			lista.add(rep);
    		}
    	}catch(SQLException ex) {
    		JOptionPane.showMessageDialog(null,"Error al cargar "+ ex);
    	}return lista;
    }
}
