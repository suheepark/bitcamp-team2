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

  public void service(HashMap<String, String> paramMap, PrintStream out) {
    if (!teacherDao.existEmail(paramMap.get("email"))) {
      out.print("이메일을 찾지 못했습니다.\n");
    }
    Teacher teacher = new Teacher();
      teacher.setEmail(paramMap.get("email"));
      teacher.setName(paramMap.get("name"));
      teacher.setCareer(paramMap.get("career"));
      teacher.setLangauge(paramMap.get("langauge"));
      teacher.setBook(paramMap.get("book").equals("true") ? true : false);
      teacher.setTel(paramMap.get("tel"));
      teacherDao.update(teacher);
      out.printf("업데이트 완료하였습니다.\n");
      return;
      
  }
}
