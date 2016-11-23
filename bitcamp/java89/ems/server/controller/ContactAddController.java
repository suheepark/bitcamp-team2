package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ContactDao;
import bitcamp.java89.ems.server.vo.Contact;

public class ContactAddController implements Command {
  private ContactDao contactDao;

  public ContactAddController() {
    contactDao = ContactDao.getInstance();
  }

  public void service(HashMap<String,String> paraMap, PrintStream out) {
    if (contactDao.existEmail(paraMap.get("email"))) {
      out.println("같은 이메일이 존재합니다. 등록을 취소합니다.");
      return;
    }
    Contact contact = new Contact();
    contact.setName(paraMap.get("name"));
    contact.setPosition(paraMap.get("position"));
    contact.setTel(paraMap.get("tel"));
    contact.setEmail(paraMap.get("email"));
    
    contactDao.insert(contact);
    out.println("등록하였습니다.");
    }
}

