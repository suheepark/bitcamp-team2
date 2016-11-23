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

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (!contactDao.existEmail(paramMap.get("email"))) {
      out.print("이메일을 찾지 못했습니다.\n");
      return;
    }
    Contact contact = new Contact();
    contact.setName(paramMap.get("name"));
    contact.setPosition(paramMap.get("position"));
    contact.setTel(paramMap.get("tel"));
    contact.setEmail(paramMap.get("email"));
    
    contactDao.update(contact);
    out.print("업데이트하였습니다.\n");
  }
}

