/* 작업내용: 직렬화 적용 
*/
package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.TeacherDao;
import bitcamp.java89.ems.server.vo.Teacher;

public class TeacherViewController implements Command {
  private TeacherDao teacherDao;

  public TeacherViewController() {

    teacherDao = TeacherDao.getInstance();
  }

  public void service(HashMap<String, String> paramMap, PrintStream out) {
    ArrayList<Teacher> list = teacherDao.getListByName(paramMap.get("name"));
    for (Teacher teacher : list) {
      out.printf("%s, %s, %s, %s, %s, %s\n",
          teacher.getName(),
          teacher.getCareer(),
          teacher.getLangauge(),
          ((teacher.isBook()) ? "yes" : "no"),
          teacher.getEmail(),
          teacher.getTel());
    }
  }
}
