package DAO.impl;

import DAO.GenericDAO;
import mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T> {
    public Connection getConnection() {
        try {
            //Class.forName("com.mysql.jdbc.driver");//load drive mysql
            String url = "jdbc:mysql://locallhost:3306/jsp_servlet";//dia chi mysql
            String username = "root";
            String password = "123456";
            return DriverManager.getConnection(url, username, password);//tra ve doi tuong la 1 connection
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... Parameters) {
        List<T> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet=null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setParameter(statement,Parameters);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                result.add(rowMapper.mapRow(resultSet));

            }
            return result;

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public void Update(String sql, Object... parameters) {

        Connection connection = null;
        PreparedStatement statement = null;
    try{
        connection = getConnection();
        connection.setAutoCommit(false);
        statement= connection.prepareStatement(sql);
        setParameter(statement,parameters);
        statement.executeUpdate();
        connection.commit();


    }catch(Exception e){
        e.printStackTrace();
        }finally {
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }


    }

    @Override
    public Long insert(String sql, Object... parameters) {
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            Long id = null;
            statement = connection.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);
            connection.setAutoCommit(false);
            setParameter(statement,parameters);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getLong(1);
            }
            connection.commit();
            return id;

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return null;
    }

    private void setParameter(PreparedStatement statement, Object... parameters) {
        for(int i=0 ; i < parameters.length;i++){
            Object parameter = parameters[i];
            int index = i+1;
            if(parameter instanceof  Long)
            {
                try {
                    statement.setLong(index , (Long)parameter);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            else if(parameter instanceof  String)
            {
                try {
                    statement.setString(index , (String)parameter);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            else if(parameter instanceof Integer){
                try {
                    statement.setInt(index,(Integer)parameter);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
