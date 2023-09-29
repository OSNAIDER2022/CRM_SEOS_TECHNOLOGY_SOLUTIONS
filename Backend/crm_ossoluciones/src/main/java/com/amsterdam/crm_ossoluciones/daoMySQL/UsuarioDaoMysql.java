package com.amsterdam.crm_ossoluciones.daoMySQL;

import com.amsterdam.crm_ossoluciones.db.DatabaseOsSoluciones;
import com.amsterdam.crm_ossoluciones.idao.IdaoUsuario;
import com.amsterdam.crm_ossoluciones.model.Usuario;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Repository
public class UsuarioDaoMysql implements IdaoUsuario<Usuario> {
    @Override
    public Usuario guardar(Usuario usuario) {
        Connection connection = null;

        try{
            connection = DatabaseOsSoluciones.getConnection();
            StringBuffer SQL_INSERT = new StringBuffer();
            SQL_INSERT
                    .append("insert into ").append("USUARIO")
                    .append("(NOMBRE_COMPLETO, EMAIL, PASSWORD, CELULAR, IDENTIFICACION, FOTO, ROLL_ID)")
                    .append(" values").append("(?,?,?,?,?,?,?)");

            switch (usuario.getRoll_id()){
                /*los valores de los case serán reemplazados por los traídos desde la tabla de ROLLES
                * modificandolos por el roll.perfil*/
                case 10:
                    SQL_INSERT.replace(12,19,"CLIENTES");
                    break;
                case 11:
                    SQL_INSERT.replace(12,19,"PROVEEDORES");
                    break;
                default:
                    SQL_INSERT.replace(12,19,"COLABORADORES");
            }


            PreparedStatement psinsert = connection.prepareStatement(String.valueOf(SQL_INSERT), Statement.RETURN_GENERATED_KEYS);
            psinsert.setString(1, usuario.getNombreCompleto());
            psinsert.setString(2,usuario.getEmail());
            psinsert.setString(3,usuario.getPassword());
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
    public List<Usuario> buscarTodos() {
        return null;
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        return null;
    }

    @Override
    public void eliminarPorId(Integer id) {

    }

    @Override
    public void actualizar(Usuario usuario) {

    }

    @Override
    public String mostrarPerfilDeRoll(String nombreCompleto) {
        return null;
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return null;
    }
}
