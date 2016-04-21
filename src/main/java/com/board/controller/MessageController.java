package com.board.controller;

import com.board.domain.MessagesEntity;
import com.board.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 29979 on 2015/12/22.
 */
@Controller
@RequestMapping(value = "comment")
public class MessageController {
    @Autowired
    private MessageService messageService;

    //处理留言请求
    @RequestMapping(value = "{userName}")
    public String commit(@PathVariable("userName") String userName, ModelMap modelMap) {
        modelMap.addAttribute("userName", userName);
        return "write";
    }

    //处理留言内容
    @RequestMapping(value = "commit")
    public String commitHandler(@RequestParam("userName") String userName,
                                @RequestParam("message") String message) {
        boolean judge = messageService.writeMessage(userName, message);
        if (judge) {
            return "CommitSuccess";
        } else {
            return "CommitFail";
        }
    }

    //显示某个用户的留言
    @RequestMapping(value = "showMessages/{currentUser}")
    public String showMessages(@PathVariable("currentUser") String currentUser, ModelMap modelMap) {
        messageService.showMessages(currentUser);
        List<MessagesEntity> messages = messageService.showMessages(currentUser);
        modelMap.addAttribute("messages",messages);
        return "messages";
    }



}
