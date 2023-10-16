package com.amsterdam.crm_ossoluciones.daoMySQL;

import com.amsterdam.crm_ossoluciones.db.DatabaseOsSoluciones;
import com.amsterdam.crm_ossoluciones.idao.IdaoRegistroContable;
import com.amsterdam.crm_ossoluciones.model.RegistroContable;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RegistroContableDaoMysql implements IdaoRegistroContable<RegistroContable> {
    @Override
    public RegistroContable guardar(RegistroContable registroContable) {
        Connection connection = null;

        try {
            StringBuffer SQL_INSERT_REGISTER_COUNTABLE = new StringBuffer();
            SQL_INSERT_REGISTER_COUNTABLE.append("insert into ").append("REGISTROS_CONTABLES").append("(ID, FECHA, TIPO_DE_REGISTRO, DESCRIPCION, VALOR, EVIDENCIA, REPORTADOR_ID)").append(" values(?,?,?,?,?,?,?)");

            connection = DatabaseOsSoluciones.getConnection();
            PreparedStatement psInsertRegisterCountable = connection.prepareStatement(String.valueOf(SQL_INSERT_REGISTER_COUNTABLE), Statement.RETURN_GENERATED_KEYS);
            psInsertRegisterCountable.setDate(1, Date.valueOf(registroContable.getFecha()));
            psInsertRegisterCountable.setString(2,registroContable.getTipoDeRegistro());
            psInsertRegisterCountable.setString(3,registroContable.getDescripcion());
            psInsertRegisterCountable.setDouble(4,registroContable.getValor());
            psInsertRegisterCountable.setString(5,registroContable.getEvidencia());
            psInsertRegisterCountable.setInt(6,registroContable.getReportadorId());
            psInsertRegisterCountable.execute();

            ResultSet rs = psInsertRegisterCountable.getGeneratedKeys();
            while (rs.next()){
                registroContable.setId(rs.getInt(1));
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

        return registroContable;
    }

    @Override
    public List<RegistroContable> buscarTodos() {
        Connection connection = null;
        RegistroContable registroContable = null;
        List<RegistroContable> registroContableList = new ArrayList<>();

        try {
            StringBuffer SQL_SEARCHALL_REGISTER_CONTABLE = new StringBuffer();
            SQL_SEARCHALL_REGISTER_CONTABLE.append(" select * from ").append("REGISTROS_CONTABLES");

            connection = DatabaseOsSoluciones.getConnection();
            PreparedStatement psSearchAllRegisterCountable = connection.prepareStatement(String.valueOf(SQL_SEARCHALL_REGISTER_CONTABLE));

            ResultSet rs = psSearchAllRegisterCountable.executeQuery();
            while (rs.next()){
                registroContable = new RegistroContable(rs.getInt(1),rs.getDate(2).toLocalDate(),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getInt(7));
                registroContableList.add(registroContable);
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

        return registroContableList;
    }

    @Override
    public RegistroContable buscarPorId(Integer id) {
        Connection connection = null;
        RegistroContable registroContable = null;

        try {
            StringBuffer SQL_SEARCH_BY_ID_REGISTER_COUNTABLE = new StringBuffer();
            SQL_SEARCH_BY_ID_REGISTER_COUNTABLE.append("select * from ").append("REGISTROS_CONTABLES").append(" where ID = ?");

            connection = DatabaseOsSoluciones.getConnection();
            PreparedStatement psSearchByIdRegisterCountable = connection.prepareStatement(String.valueOf(SQL_SEARCH_BY_ID_REGISTER_COUNTABLE));
            psSearchByIdRegisterCountable.setInt(1,id);

            ResultSet rs = psSearchByIdRegisterCountable.executeQuery();
            while (rs.next()){
                registroContable = new RegistroContable(rs.getInt(1),rs.getDate(2).toLocalDate(),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getInt(7));
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

        return registroContable;
    }

    @Override
    public void eliminarPorId(Integer id) {
        Connection connection = null;

        try {
            StringBuffer SQL_DELETE_BY_ID_REGISTER_COUNTABLE = new StringBuffer();
            SQL_DELETE_BY_ID_REGISTER_COUNTABLE.append("delete from ").append("REGISTROS_CONTABLES").append(" where ID = ?");

            connection = DatabaseOsSoluciones.getConnection();
            PreparedStatement psDeleteByIdRegisterCountable = connection.prepareStatement(String.valueOf(SQL_DELETE_BY_ID_REGISTER_COUNTABLE));
            psDeleteByIdRegisterCountable.setInt(1,id);
            psDeleteByIdRegisterCountable.execute();

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
    public void actualizar(RegistroContable registroContable) {
        Connection connection = null;

        try {
            StringBuffer SQL_UPDATE_REGISTER_COUNTABLE = new StringBuffer();
            SQL_UPDATE_REGISTER_COUNTABLE.append("update ").append("REGISTROS_CONTABLES").append(" set FECHA = ?, TIPO_DE_REGISTRO = ?, DESCRIPCION = ?, VALOR = ?, EVIDENCIA = ?, REPORTADOR_ID = ? ").append("where ID = ?");

            connection = DatabaseOsSoluciones.getConnection();
            PreparedStatement psUpdateRegisterCountable = connection.prepareStatement(String.valueOf(SQL_UPDATE_REGISTER_COUNTABLE));
            psUpdateRegisterCountable.setDate(1, Date.valueOf(registroContable.getFecha()));
            psUpdateRegisterCountable.setString(2,registroContable.getTipoDeRegistro());
            psUpdateRegisterCountable.setString(3,registroContable.getDescripcion());
            psUpdateRegisterCountable.setDouble(4,registroContable.getValor());
            psUpdateRegisterCountable.setString(5,registroContable.getEvidencia());
            psUpdateRegisterCountable.setInt(6,registroContable.getReportadorId());
            psUpdateRegisterCountable.setInt(7,registroContable.getId());
            psUpdateRegisterCountable.execute();

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

}
