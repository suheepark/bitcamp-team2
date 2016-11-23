package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ContactDao;
import bitcamp.java89.ems.server.vo.Contact;

public class ContactDeleteController implements Command {
  private ContactDao contactDao;

  public ContactDeleteController() {
    contactDao = ContactDao.getInstance();
  }

  public void service(HashMap<String,String> paraMap, PrintStream out) {
    if (!contactDao.existEmail(paraMap.get("email"))) {
      out.println("해당 데이터가 없습니다.");
      return;
    }
    contactDao.delete(paraMap.get("email"));
    out.print("삭제하였습니다.\n");
  }
}

