package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ContactDao;
import bitcamp.java89.ems.server.vo.Contact;

public class ContactUpdateController implements Command {
  private ContactDao contactDao;

  public ContactUpdateController() {
    contactDao = ContactDao.getInstance();
  }

  public void service(HashMap<String,String> paraMap, PrintStream out) {
    if (!contactDao.existEmail(paraMap.get("email"))) {
      out.print("이메일을 찾지 못했습니다.\n");
      return;
    }
    Contact contact = new Contact();
    contact.setName(paraMap.get("name"));
    contact.setPosition(paraMap.get("position"));
    contact.setTel(paraMap.get("tel"));
    contact.setEmail(paraMap.get("email"));
    
    contactDao.update(contact);
    out.print("업데이트하였습니다.\n");
  }
}

