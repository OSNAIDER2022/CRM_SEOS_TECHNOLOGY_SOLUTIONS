package com.amsterdam.crm_ossoluciones.daoMySQL;

import com.amsterdam.crm_ossoluciones.db.DatabaseOsSoluciones;
import com.amsterdam.crm_ossoluciones.idao.IdaoGeneral;
import com.amsterdam.crm_ossoluciones.model.General;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GeneralDaoMysql implements IdaoGeneral<General> {
    @Override
    public General guardar(String tipo, General general) {
        Connection connection = null;

        try {
            connection = DatabaseOsSoluciones.getConnection();

            StringBuffer SQL_INSERT_GENERAL = new StringBuffer();
            SQL_INSERT_GENERAL.append("insert into ").append("GENERAL").append("(valor)").append(" values(?)");

            switch (tipo){
                case "roll":
                    SQL_INSERT_GENERAL.replace(12,19,"ROLLES").replace(19,24,"PERFIL");
                    break;
                case "estado_servicio":
                    SQL_INSERT_GENERAL.replace(12,19,"ESTADOS_DE_SERVICIOS").replace(33,38,"NOMBRE_ESTADO");
                    break;
                case "estado_producto":
                    SQL_INSERT_GENERAL.replace(12,19,"ESTADOS_DE_PRODUCTOS").replace(33,38,"ESTADO");
                    break;
                case "tiempo_garantia":
                    SQL_INSERT_GENERAL.replace(12,19,"TIEMPOS_GARANTIA").replace(29,34,"TIEMPO");
                    break;
                default:
                    return null;
            }

            PreparedStatement psInsert = connection.prepareStatement(String.valueOf(SQL_INSERT_GENERAL),Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1,general.getValor());
            psInsert.execute();

            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()){
                general = new General(rs.getInt(1),rs.getString(2));
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

        return general;
    }

    @Override
    public List<General> buscarTodos(String generales) {
        Connection connection = null;
        General general = null;
        List<General> generalList = new ArrayList<>();

        try {
            StringBuffer SQL_SEARCH_ALL_GENERALS = new StringBuffer();
            SQL_SEARCH_ALL_GENERALS.append("select * from ").append("GENERAL");
            switch (generales){
                case "rolles":
                    SQL_SEARCH_ALL_GENERALS.replace(14,21,"ROLLES");
                    break;
                case "estados_servicios":
                    SQL_SEARCH_ALL_GENERALS.replace(14,21,"ESTADOS_DE_SERVICIOS");
                    break;
                case "estados_productos":
                    SQL_SEARCH_ALL_GENERALS.replace(14,21,"ESTADOS_DE_PRODUCTOS");
                    break;
                case "tiempos_garantias":
                    SQL_SEARCH_ALL_GENERALS.replace(14,21,"TIEMPOS_GARANTIAS");
                    break;
                default:
            }

            connection = DatabaseOsSoluciones.getConnection();
            PreparedStatement psSearchAll = connection.prepareStatement(String.valueOf(SQL_SEARCH_ALL_GENERALS));

            ResultSet rs = psSearchAll.executeQuery();
            while (rs.next()){
                general = new General(rs.getInt(1),rs.getString(2));
                generalList.add(general);
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

        return generalList;
    }

    @Override
    public General buscarPorId(String tipo, Integer id) {
        Connection connection = null;
        General general = null;

        try{
            StringBuffer SQL_SEARCH_GENERAL_BY_ID = new StringBuffer();
            SQL_SEARCH_GENERAL_BY_ID.append("select * from ").append("GENERAL").append(" where id = ?");
            switch (tipo){
                case "roll":
                    SQL_SEARCH_GENERAL_BY_ID.replace(14,20,"ROLLES");
                    break;
                case "estado_servicio":
                    SQL_SEARCH_GENERAL_BY_ID.replace(14,20,"ESTADOS_DE_SERVICIOS");
                    break;
                case "estado_producto":
                    SQL_SEARCH_GENERAL_BY_ID.replace(14,20,"ESTADOS_DE_PRODUCTOS");
                    break;
                case "tiempo_garantia":
                    SQL_SEARCH_GENERAL_BY_ID.replace(14,20,"TIEMPOS_GARANTIAS");
                    break;
                default:
            }

            connection = DatabaseOsSoluciones.getConnection();
            PreparedStatement psSearchById = connection.prepareStatement(String.valueOf(SQL_SEARCH_GENERAL_BY_ID));
            psSearchById.setInt(1,general.getId());

            ResultSet rs = psSearchById.executeQuery();
            while (rs.next()){
                general = new General(rs.getInt(1),rs.getString(2));

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

        return general;
    }

    @Override
    public void eliminarPorId(String tipo, Integer id) {
        Connection connection = null;

        try {
            StringBuffer SQL_DELETE_GENERAL_BY_ID = new StringBuffer();
            SQL_DELETE_GENERAL_BY_ID.append("delete from ").append("GENERAL").append(" where id = ?");
            switch (tipo){
                case "roll":
                    SQL_DELETE_GENERAL_BY_ID.replace(12,19,"ROLLES");
                    break;
                case "estado_servicio":
                    SQL_DELETE_GENERAL_BY_ID.replace(12,19,"ESTADOS_DE_SERVICIOS");
                    break;
                case "estado_producto":
                    SQL_DELETE_GENERAL_BY_ID.replace(12,19,"ESTADOS_DE_PRODUCTOS");
                case "tiempo_garantia":
                    SQL_DELETE_GENERAL_BY_ID.replace(12,19,"TIEMPOS_GARANTIAS");
                    break;
                default:
            }

            connection = DatabaseOsSoluciones.getConnection();
            PreparedStatement psDeleteById = connection.prepareStatement(String.valueOf(SQL_DELETE_GENERAL_BY_ID));
            psDeleteById.setInt(1,id);
            psDeleteById.execute();

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
    public void actualizar(String tipo,General general) {
        Connection connection = null;

        try {
            StringBuffer SQL_UPDATE_GENERAL = new StringBuffer();
            SQL_UPDATE_GENERAL.append("update ").append("GENERAL").append(" set VALOR = ?").append(" where ID = ?");

            switch (tipo){
                case "roll":
                    SQL_UPDATE_GENERAL.replace(7,14,"ROLLES").replace(18,23,"PERFIL");
                    break;
                case "estado_servicio":
                    SQL_UPDATE_GENERAL.replace(7,14,"ESTADOS_DE_SERVICIOS").replace(32,37,"NOMBRE_ESTADO");
                    break;
                case "estado_producto":
                    SQL_UPDATE_GENERAL.replace(7,14,"ESTADOS_DE_PRODUCTOS").replace(32,37,"ESTADO");
                    break;
                case "tiempo_garantia":
                    SQL_UPDATE_GENERAL.replace(29,34,"TIEMPO");
                    break;
                default:
            }

            connection = DatabaseOsSoluciones.getConnection();
            PreparedStatement psUpdate = connection.prepareStatement(String.valueOf(SQL_UPDATE_GENERAL));
            psUpdate.setString(1, general.getValor());
            psUpdate.setInt(2,general.getId());
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
}
