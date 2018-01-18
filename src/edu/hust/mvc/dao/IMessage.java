package edu.hust.mvc.dao;

import edu.hust.mvc.model.Message;

import java.util.List;

public interface IMessage {

    public List<Message> queryMessageList(Message message);
}
