package com.board.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by nobug on 1/10/16.
 */
//数据库连接类
@Configuration
public class Conn {
    private static Connection connection;

    public static Connection getConnection() {
        //连接数据库
        try {
            //千万别图省事  ?useUnicode=true&characterEncoding=UTF-8"一定写上
            String url = "jdbc:mysql://localhost/message_board?useUnicode=true&characterEncoding=UTF-8";
            String userName = "root";
            String userPassword = "2141314";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, userPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
