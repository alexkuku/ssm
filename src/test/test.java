package test;

import edu.hust.mvc.dao.MessageDAO;
import edu.hust.mvc.model.Message;
import org.junit.Test;

import java.util.List;

public class test {

    @Test
    public void testDao() {
        MessageDAO md = new MessageDAO();
        List<Message> messages = md.queryMessageList("","");
        for (Message m: messages ) {
            System.out.println(m.toString());
        }
    }
}
