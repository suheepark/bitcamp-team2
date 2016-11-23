package bitcamp.java89.ems.server.controller;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ClassroomDao;
public class ClassroomDeleteController implements Command {
  private ClassroomDao classroomDao;
  
  public ClassroomDeleteController() throws IOException {
    classroomDao = ClassroomDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    classroomDao.delete(Integer.parseInt(paramMap.get("roomno")));
    out.println("삭제하였습니다");
  }

}
