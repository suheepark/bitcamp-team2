package bitcamp.java89.ems.server.controller;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ClassroomDao;
import bitcamp.java89.ems.server.vo.Classroom;
public class ClassroomUpdateController implements Command {
  private ClassroomDao classroomDao;
  
  public ClassroomUpdateController() throws IOException {
    classroomDao = ClassroomDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (!classroomDao.existRoomNo(Integer.parseInt(paramMap.get("roomno")))) {
      out.println("데이터를 찾지 못했습니다.");
      return;
    }
    Classroom classroom = new Classroom();
    classroom.setRoomNo(Integer.parseInt(paramMap.get("roomno")));
    classroom.setCapacity(Integer.parseInt(paramMap.get("capacity")));
    classroom.setClassName(paramMap.get("classname"));
    classroom.setClassTime(paramMap.get("classtime"));
    classroom.setProjector(paramMap.get("projector").equals("t") ? true : false);
    classroom.setLocker(paramMap.get("locker").equals("t") ? true : false);
    classroomDao.update(classroom);
    out.println("변경하였습니다.");
    return;
  }

}
