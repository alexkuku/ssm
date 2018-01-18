package edu.hust.mvc.dao;

import edu.hust.mvc.db.DBAccess;
import edu.hust.mvc.model.Message;
import org.apache.ibatis.session.SqlSession;


import java.util.ArrayList;
import java.util.List;

public class MessageDAO {
    IMessage iMessage;

    public List<Message> queryMessageList(String command, String description) {
        List<Message> messageList = new ArrayList<Message>();
        SqlSession session = null;
        try {
            DBAccess dbAccess = new DBAccess();
            session = dbAccess.getSqlSession();
            Message message = new Message();
            message.setCommand(command);
            message.setDescription(description);
            iMessage = session.getMapper(IMessage.class);
            messageList = iMessage.queryMessageList(message);
            //messageList = session.selectList("edu.hust.mvc.dao.IMessage.queryMessageList", message);

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return messageList;
    }

    public void deleteMessage(int id) {
        SqlSession session = null;
        try {
            DBAccess dbAccess = new DBAccess();
            session = dbAccess.getSqlSession();
            session.delete("Message.deleteOne", id);
            session.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }

    }


}
