package Modelo.bancos;

import Controlador.banco.banco;
import Modelo.Conexion;
import java.sql.*;
import java.util.*;

public class BancoDAO {

    private static final String SQL_SELECT = "SELECT id_banco, idTipo_bodega, nombre, direccion, status FROM banco";
    private static final String SQL_INSERT = "INSERT INTO banco(idTipo_bodega, nombre, direccion, status) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE banco SET idTipo_bodega = ?, nombre = ?, direccion = ?, status = ? WHERE id_banco = ?";
    private static final String SQL_DELETE = "DELETE FROM banco WHERE id_banco = ?";
    private static final String SQL_QUERY = "SELECT id_banco, idTipo_bodega, nombre, direccion, status FROM banco WHERE id_banco = ?";

    public List<banco> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<banco> lista = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                banco b = new banco();
                b.setId_banco(rs.getInt("id_banco"));
                b.setIdTipo_bodega(rs.getString("idTipo_bodega"));
                b.setNombre(rs.getString("nombre"));
                b.setDireccion(rs.getString("direccion"));
                b.setStatus(rs.getString("status"));
                lista.add(b);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return lista;
    }

    public int insert(banco b) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, b.getIdTipo_bodega());
            stmt.setString(2, b.getNombre());
            stmt.setString(3, b.getDireccion());
            stmt.setString(4, b.getStatus());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(banco b) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, b.getIdTipo_bodega());
            stmt.setString(2, b.getNombre());
            stmt.setString(3, b.getDireccion());
            stmt.setString(4, b.getStatus());
            stmt.setInt(5, b.getId_banco());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(banco b) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, b.getId_banco());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public banco query(banco b) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, b.getId_banco());
            rs = stmt.executeQuery();
            if (rs.next()) {
                b.setIdTipo_bodega(rs.getString("idTipo_bodega"));
                b.setNombre(rs.getString("nombre"));
                b.setDireccion(rs.getString("direccion"));
                b.setStatus(rs.getString("status"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return b;
    }

    public boolean existeBanco(int idBanco) {
        String sql = "SELECT 1 FROM banco WHERE id_banco = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean existe = false;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idBanco);
            rs = stmt.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return existe;
    }
}
