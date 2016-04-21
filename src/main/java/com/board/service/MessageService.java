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
 * Created by 29979 on 2015/12/22.
 */
@Service
public class MessageService {
    private Connection connection = null;
    //构造器
    public MessageService() {
        try {
            this.connection = Conn.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //写入留言
    public boolean writeMessage(String userName, String message) {

        System.out.print(message);

        //写入
        //都是utf8  为啥还是不正常显示
        String sql = "insert into messages (message, userName, message_time) values(?, ?, CURRENT_TIMESTAMP())";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, message);
            preparedStatement.setString(2, userName);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    //显示留言
    public List showMessages(String currentUser) {
        String sql = "select * from messages where userName = ? group by id";
        ResultSet resultSet = null;
        List messagesList = null;
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1,currentUser);
            resultSet = preparedStatement.executeQuery();
            //调用方法　　使ResultSet转换为List
            messagesList = RsToList.convertList(resultSet);
            return  messagesList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messagesList;
    }



}
