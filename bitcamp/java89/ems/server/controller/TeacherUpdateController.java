/* 작업내용: 직렬화 적용 
*/
package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.TeacherDao;
import bitcamp.java89.ems.server.vo.Teacher;

public class TeacherUpdateController implements Command {
  private TeacherDao teacherDao;

  public TeacherUpdateController() {

    teacherDao = TeacherDao.getInstance();
  }

  public void service(HashMap<String, String> paraMap, PrintStream out) {
    if (!teacherDao.existEmail(paraMap.get("email"))) {
      out.print("이메일을 찾지 못했습니다.\n");
    }
    Teacher teacher = new Teacher();
      teacher.setEmail(paraMap.get("email"));
      teacher.setName(paraMap.get("name"));
      teacher.setCareer(paraMap.get("career"));
      teacher.setLangauge(paraMap.get("langauge"));
      teacher.setBook(paraMap.get("book").equals("true") ? true : false);
      teacher.setTel(paraMap.get("tel"));
      teacherDao.update(teacher);
      out.printf("업데이트 완료하였습니다.\n");
      return;
      
  }
}
