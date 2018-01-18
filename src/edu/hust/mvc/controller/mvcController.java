package edu.hust.mvc.controller;

import edu.hust.mvc.dao.MessageDAO;
import edu.hust.mvc.model.Message;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class mvcController {

    MessageDAO md = new MessageDAO();

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/message")
    public String getMessage(HttpServletRequest req) throws UnsupportedEncodingException {
        // 设置编码
        // 接受页面的值
        req.setCharacterEncoding("UTF-8");

        String command = String.valueOf(req.getParameter("command"));
        System.out.println(command);
        String description = String.valueOf(req.getParameter("description"));
        System.out.println(description);
        req.setAttribute("messageList", md.queryMessageList(command, description));

        //分页


        return "Message";
    }
    @RequestMapping("/deleteOne")
    public String deleteMessage(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        md.deleteMessage(id);
        return "redirect:/message";
    }


}
