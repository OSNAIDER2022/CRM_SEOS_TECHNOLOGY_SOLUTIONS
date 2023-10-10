package com.amsterdam.crm_ossoluciones.daoMySQL;

import com.amsterdam.crm_ossoluciones.db.DatabaseOsSoluciones;
import com.amsterdam.crm_ossoluciones.idao.IdaoUsuario;
import com.amsterdam.crm_ossoluciones.model.Usuario;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioDaoMysql implements IdaoUsuario<Usuario> {
    @Override
    public Usuario guardar(Usuario usuario) {
        Connection connection = null;

        try{
            connection = DatabaseOsSoluciones.getConnection();

            StringBuffer SQL_INSERT_USER = new StringBuffer();
            SQL_INSERT_USER.append("insert into ").append("USUARIO").append("(NOMBRE_COMPLETO, EMAIL, PASSWRD, CELULAR, IDENTIFICACION, FOTO, ROLL_ID)").append(" values").append("(?,?,?,?,?,?,?);");

            switch (usuario.getRoll_id()){
                case 10:
                    SQL_INSERT_USER.replace(12,19,"CLIENTES");
                    break;
                case 11:
                    SQL_INSERT_USER.replace(12,19,"PROVEEDORES");
                    break;
                default:
                    SQL_INSERT_USER.replace(12,19,"COLABORADORES");
            }

            PreparedStatement psinsert = connection.prepareStatement(String.valueOf(SQL_INSERT_USER), Statement.RETURN_GENERATED_KEYS);
            psinsert.setString(1, usuario.getNombreCompleto());
            psinsert.setString(2,usuario.getEmail());
            psinsert.setString(3,usuario.getPasswrd());
            psinsert.setString(4,usuario.getCelular());
            psinsert.setString(5,usuario.getIdentificacion());
            psinsert.setString(6,usuario.getFoto());
            psinsert.setInt(7,usuario.getRoll_id());
            psinsert.execute();

            ResultSet rs = psinsert.getGeneratedKeys();
            while (rs.next()){
                usuario.setId(rs.getInt(1));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }

        return usuario;
    }

    @Override
    public List<Usuario> buscarTodos(String usuarios) {
        Connection connection = null;
        Usuario usuario = null;
        List<Usuario> usuariosList = new ArrayList<>();

        try{
            connection = DatabaseOsSoluciones.getConnection();

            StringBuffer SQL_SEARCH_ALL = new StringBuffer();
            SQL_SEARCH_ALL.append("select * from ").append("USUARIO");

            switch (usuarios){
                /*los valores de los case serán reemplazados por los traídos desde la tabla de ROLLES
                 * modificandolos por el roll.perfil*/

                case "clientes":
                    SQL_SEARCH_ALL.replace(14,21,"CLIENTES");
                    break;

                case "proveedores":
                    SQL_SEARCH_ALL.replace(14,21,"PROVEEDORES");
                    break;
                case "colaboradores":
                    SQL_SEARCH_ALL.replace(14,21,"COLABORADORES");
                    break;
                    default:
                        return null;
            }

            PreparedStatement psSearchAll = connection.prepareStatement(String.valueOf(SQL_SEARCH_ALL));
            ResultSet rs = psSearchAll.executeQuery();

            while (rs.next()){
                usuario = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
                usuariosList.add(usuario);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }

        return usuariosList;
    }

    @Override
    public Usuario buscarPorId(String tipo, Integer id) {
        Connection connection = null;
        Usuario usuario = null;

        try{
            connection = DatabaseOsSoluciones.getConnection();

            StringBuffer SQL_SEARCH_USER_BY_ID = new StringBuffer();
            SQL_SEARCH_USER_BY_ID.append("select * from ").append("USUARIO").append(" where id = ?");

            switch (tipo){

                case "cliente":
                    SQL_SEARCH_USER_BY_ID.replace(14,21,"CLIENTES");
                    break;
                case "proveedor":
                    SQL_SEARCH_USER_BY_ID.replace(14,21,"PROVEEDORES");
                    break;
                case "colaborador":
                    SQL_SEARCH_USER_BY_ID.replace(14,21,"COLABORADORES");
                    break;
                default:
                   return null;
            }

            PreparedStatement psSearchById = connection.prepareStatement(String.valueOf(SQL_SEARCH_USER_BY_ID));
            psSearchById.setInt(1,id);

            ResultSet rs = psSearchById.executeQuery();
            while (rs.next()){
                usuario = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }

        return usuario;
    }

    @Override
    public void eliminarPorId(String tipo, Integer id) {
        Connection connection = null;
        Usuario usuario = null;

        try{
            connection = DatabaseOsSoluciones.getConnection();

            StringBuffer SQL_DELETE_USER_BY_ID = new StringBuffer();
            SQL_DELETE_USER_BY_ID.append("delete from ").append("USUARIO").append(" where id = ?");

            switch (tipo){

                case "cliente":
                    SQL_DELETE_USER_BY_ID.replace(12,19,"CLIENTES");
                    break;
                case "proveedor":
                    SQL_DELETE_USER_BY_ID.replace(12,19,"PROVEEDORES");
                    break;
                case "colaborador":
                    SQL_DELETE_USER_BY_ID.replace(12,19,"COLABORADORES");
                    break;
                    default:
            }

            PreparedStatement psDelete = connection.prepareStatement(String.valueOf(SQL_DELETE_USER_BY_ID));
            psDelete.setInt(1,id);
            psDelete.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    @Override
    public void actualizar(Usuario usuario) {
        Connection connection = null;

        try {
            connection = DatabaseOsSoluciones.getConnection();

            StringBuffer SQL_UPDATE_USER = new StringBuffer();
            SQL_UPDATE_USER.append("update ").append("USUARIO").append(" set NOMBRE_COMPLETO = ?, EMAIL = ?, PASSWRD = ?, CELULAR = ?, IDENTIFICACION = ?, FOTO = ?, ROLL_ID = ?").append(" where ID = ?");

            switch (usuario.getRoll_id()){
                case 10:
                    SQL_UPDATE_USER.replace(7,14,"CLIENTES");
                    break;
                case 11:
                    SQL_UPDATE_USER.replace(7,14,"PROVEEDORES");
                    break;
                default:
                    SQL_UPDATE_USER.replace(7,14,"COLABORADORES");
            }

            PreparedStatement psUpdate = connection.prepareStatement(String.valueOf(SQL_UPDATE_USER));
            psUpdate.setString(1, usuario.getNombreCompleto());
            psUpdate.setString(2, usuario.getEmail());
            psUpdate.setString(3, usuario.getPasswrd());
            psUpdate.setString(4,usuario.getCelular());
            psUpdate.setString(5, usuario.getIdentificacion());
            psUpdate.setString(6, usuario.getFoto());
            psUpdate.setInt(7,usuario.getRoll_id());
            psUpdate.setInt(8,usuario.getId());
            psUpdate.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    @Override
    public String mostrarPerfilDeRoll(String tipo, String nombreCompleto) {
        /*
        Connection connection = null;
        Roll roll = null;

        try {
            connection = DatabaseOsSoluciones.getConnection();

            StringBuffer SQL_SHOW_ROLL_PROFILE = new StringBuffer();
            SQL_SHOW_ROLL_PROFILE.append("select ROLLES.PERFIL from ").append("USUARIO").append(" left join ROLLES on ").append("USUARIO").append(".ROLL_ID = ROLLES.ID WHERE ").append("USUARIO").append(".NOMBRE_COMPLETO = ?");

            switch (tipo){
                case "cliente":
                    SQL_SHOW_ROLL_PROFILE.replace(26,33,"CLIENTES").replace(55,62,"CLIENTES").replace(90,97,"CLIENTES");
                    break;
                case "proveedor":
                    SQL_SHOW_ROLL_PROFILE.replace(26,33,"PROVEEDORES").replace(58,65,"PROVEEDORES").replace(96,103,"PROVEEDORES");
                    break;
                case "colaborador":
                    SQL_SHOW_ROLL_PROFILE.replace(26,33,"COLABORADORES").replace(60,67,"COLABORADORES").replace(100,107,"COLABORADORES");
                    break;
                default:
            }

            PreparedStatement psShowProfile = connection.prepareStatement(String.valueOf(SQL_SHOW_ROLL_PROFILE));
            psShowProfile.setString(1,nombreCompleto);

            ResultSet rs = psShowProfile.executeQuery();
            while (rs.next()){
                roll = new Roll(rs.getInt(1),rs.getString(2));

            }
            System.out.println(roll.getPerfil());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        */

        return null;
    }

    @Override
    public Usuario buscarPorEmail(String tipo, String email) {
        /*
        Connection connection = null;
        Usuario usuario = null;

        try{
            connection = DatabaseOsSoluciones.getConnection();

            StringBuffer SQL_SEARCH_BY_EMAIL = new StringBuffer();
            SQL_SEARCH_BY_EMAIL.append("select * from ").append("USUARIO").append(" where EMAIL = ?");

            switch (tipo){
                case "cliente":
                    SQL_SEARCH_BY_EMAIL.replace(14,21,"CLIENTES");
                    break;
                case "proveedor":
                    SQL_SEARCH_BY_EMAIL.replace(14,21,"PROVEEDORES");
                    break;
                case "colaborador":
                    SQL_SEARCH_BY_EMAIL.replace(14,21,"COLABORADORES");
                    break;
                default:
            }

            PreparedStatement psSearchByEmail = connection.prepareStatement(String.valueOf(SQL_SEARCH_BY_EMAIL));
            psSearchByEmail.setString(1, email);

            ResultSet rs = psSearchByEmail.executeQuery();
            while (rs.next()){
                usuario = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        */
        return null;
    }
}
