package com.ymy.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

public class BaseDao<T> {

    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(BaseDao.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 单例
     */
    private BaseDao() {

    }

    private static class SingletonHolder{
        private static BaseDao INSTANCE = new BaseDao();
    }

    public static BaseDao getInstance(){
        return SingletonHolder.INSTANCE;
    }

    /**
     * 获取连接
     *
     * @return
     */
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 增删改
     *
     * @param sql
     * @param params
     * @return
     */
    public int executeUpdate(String sql, Object[] params) {
        int len = -1;

        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }

            len = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection, preparedStatement);
        }
        return len;
    }

    /**；
     * 通用查询
     *
     * @param sql
     * @param params
     * @return
     */
    public List<Map<String, Object>> executeQuery(String sql, Object[] params) {
        List<Map<String, Object>> resultList = new ArrayList<>();

        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            //获取列的数量
            int columnCount = resultSetMetaData.getColumnCount();

            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                for (int i = 0; i < columnCount; i++) {
                    map.put(resultSetMetaData.getColumnName(i + 1), resultSet.getObject(i + 1));
                }
                resultList.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection, preparedStatement);
        }
        return resultList;
    }

    public List<T> executeQuery(String sql, Object[] params, Class<?> clazz) {
        List<T> resultList = new ArrayList<>();

        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            //获取列的数量
            int columnCount = resultSetMetaData.getColumnCount();

            while (resultSet.next()) {
                T obj = (T) clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    String filedName = resultSetMetaData.getColumnName(i+1);
                    Field field = clazz.getDeclaredField(filedName);
                    field.setAccessible(true);
                    field.set(obj,convert(resultSet.getString(i+1),field.getType()));
                }
                resultList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection, preparedStatement);
        }
        return resultList;
    }

    /**
     * 类型转换
     * @param param
     * @param clazz
     * @param <T>
     */
    private <T extends Serializable> T convert(String param, Class<?> clazz) {
        if (param == null || param == "" || clazz == null) {
            return null;
        }
        String type = clazz.getName();
        if (type.equals("java.lang.String")) {
            return (T) param;
        }
        try {
            if (type.equals("java.util.Date")) {
                return (T) new java.util.Date(Timestamp.valueOf(param).getTime());
            }
            if (type.equals("java.sql.Date")) {
                return (T) new java.sql.Date(Timestamp.valueOf(param).getTime());
            }
            if (type.equals("java.sql.Timestamp")) {
                return (T) Timestamp.valueOf(param);
            }
            if (type.equals("java.lang.Char")) {
                return (T) Character.valueOf(param.charAt(0));
            }
            if (type.equals("java.lang.Integer") || type.equals("int")) {
                return (T) Integer.valueOf(param);
            }
            if (type.equals("java.lang.Double") || type.equals("double")) {
                return (T) Double.valueOf(param);
            }
            if (type.equals("java.lang.Float") || type.equals("float")) {
                return (T) Float.valueOf(param);
            }
            if (type.equals("java.lang.Byte") || type.equals("byte")) {
                return (T) Byte.valueOf(param);
            }
            if (type.equals("java.lang.Short") || type.equals("short")) {
                return (T) Short.valueOf(param);
            }
            if (type.equals("java.lang.Long") || type.equals("long")) {
                return (T) Long.valueOf(param);
            }
            if (type.equals("java.lang.Boolean") || type.equals("boolean")) {
                return (T) Boolean.valueOf(param);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * 释放资源,关闭连接
     *
     * @param connection
     * @param preparedStatement
     */
    private void closeAll(Connection connection, PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
