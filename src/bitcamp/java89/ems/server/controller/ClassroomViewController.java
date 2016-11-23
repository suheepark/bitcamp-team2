package bitcamp.java89.ems.server.controller;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.ClassroomDao;
import bitcamp.java89.ems.server.vo.Classroom;
public class ClassroomViewController implements Command {
  private ClassroomDao classroomDao;
  
  public ClassroomViewController() throws IOException {
    classroomDao = ClassroomDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    ArrayList<Classroom> list = classroomDao.getListByRoomNo(Integer.parseInt(paramMap.get("roomno")));
    for (Classroom classroom : list) {
      if (classroom.getRoomNo() == Integer.parseInt(paramMap.get("roomno"))) {
        out.printf("강의실 번호 : %d\n", classroom.getRoomNo());
        out.printf("수용인원 : %d\n", classroom.getCapacity());
        out.printf("강의명 : %s\n", classroom.getClassName());
        out.printf("강의 시간 : %s\n", classroom.getClassTime());
        out.printf("프로젝터 유무 : %s\n", (classroom.isProjector()) ? "YES" : "NO");
        out.printf("사물함 유무 : %s\n", (classroom.isLocker()) ? "YES" : "NO");
        out.println("-----------------------");
      }
    }
  }

}
