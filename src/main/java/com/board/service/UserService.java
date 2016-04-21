package com.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 29979 on 2015/12/21.
 */

@Service
public class UserService {
    private Connection connection = null;
    //构造器
    public UserService() {
        this.connection = Conn.getConnection();
    }

    public Connection getConnection() {
        return this.connection;
    }


    //处理登陆
    public boolean login(String name, String password) {



        //查数据库
        String sql = "select * from user where name = ? and password = ?";
        PreparedStatement preparedStatement = null;

        try {
            //预处理语句
            preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    //处理注册
    public boolean register(String name, String password) {
        if (name.equals("") || password.equals("")){
            return false;
        }


        //查数据库
        String sql = "select * from user where name = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return false;
            } else {
                String insertSql = "insert into user (name, password) values(?,?)";
                preparedStatement  = this.connection.prepareStatement(insertSql);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, password);
                preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    //显示除自己外的所有用户,并保存自己的id
    public List showUsers(String name) {

        //不等用<>
        String sql = "select * from user where name <> ?";
        ResultSet resultSet = null;
        List userList = null;
        try {
            PreparedStatement preparedStatement =this.connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            //调用方法　　使ResultSet转换为List
            userList = RsToList.convertList(resultSet);

            return  userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }



}

