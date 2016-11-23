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

  public void service(HashMap<String, String> paramMap, PrintStream out) {
    if (teacherDao.existEmail(paramMap.get("email"))) {
      out.println("같은 이메일이 존재합니다. 등록을 취소합니다.");
      return;
    }
    Teacher teacher = new Teacher();
    teacher.setName(paramMap.get("name"));
    teacher.setCareer(paramMap.get("career"));
    teacher.setLangauge(paramMap.get("langauge"));
    teacher.setBook(paramMap.get("book").equals("true") ? true : false);
    teacher.setEmail(paramMap.get("email"));
    teacher.setTel(paramMap.get("tel"));
    
    teacherDao.insert(teacher);
    out.println("등록하였습니다.");
  
  }
}
