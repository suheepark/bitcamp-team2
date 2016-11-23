/* 작업내용: 직렬화 적용 
*/
package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.TeacherDao;
import bitcamp.java89.ems.server.vo.Teacher;

public class TeacherAddController implements Command {
  private TeacherDao teacherDao;

  public TeacherAddController() {

    teacherDao = TeacherDao.getInstance();
  }

  public void service(HashMap<String, String> paraMap, PrintStream out) {
    if (teacherDao.existEmail(paraMap.get("email"))) {
      out.println("같은 이메일이 존재합니다. 등록을 취소합니다.");
      return;
    }
    Teacher teacher = new Teacher();
    teacher.setName(paraMap.get("name"));
    teacher.setCareer(paraMap.get("career"));
    teacher.setLangauge(paraMap.get("langauge"));
    teacher.setBook(paraMap.get("book").equals("true") ? true : false);
    teacher.setEmail(paraMap.get("email"));
    teacher.setTel(paraMap.get("tel"));
    
    teacherDao.insert(teacher);
    out.println("등록하였습니다.");
  
  }
}
