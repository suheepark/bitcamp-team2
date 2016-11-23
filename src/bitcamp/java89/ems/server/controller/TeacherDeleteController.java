/* 작업내용: 직렬화 적용 
*/
package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.TeacherDao;
import bitcamp.java89.ems.server.vo.Teacher;

public class TeacherDeleteController implements Command {
  private TeacherDao teacherDao;

  public TeacherDeleteController() {

    teacherDao = TeacherDao.getInstance();
  }

  public void service(HashMap<String, String> paramMap, PrintStream out) {
    if (!teacherDao.existName(paramMap.get("name"))) {
      out.println("해당 데이터가 없습니다.");
      return;
    }
    teacherDao.delete(paramMap.get("name"));
    out.print("삭제하였습니다.\n");
  
  }
}
