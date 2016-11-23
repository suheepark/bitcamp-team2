package bitcamp.java89.ems.server.controller;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ClassroomDao;
import bitcamp.java89.ems.server.vo.Classroom;
public class ClassroomListController implements Command {
  private ClassroomDao classroomDao;
  
  public ClassroomListController() throws IOException {
    classroomDao = ClassroomDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    ArrayList<Classroom> list = classroomDao.getList();
    for (Classroom classroom : list) {
      out.printf("%d %d %s %s %s %s\n",
      classroom.getRoomNo(), classroom.getCapacity(),
      classroom.getClassName(), classroom.getClassTime(),
      ((classroom.isProjector()) ? "Yes" : "No"),
      ((classroom.isLocker()) ? "Yes" : "No"));
    }
  }

}
