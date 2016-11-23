package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.CurriculumDao;
import bitcamp.java89.ems.server.vo.Curriculum;

public class CurriculumViewController implements Command {
  private CurriculumDao curriculumDao;

  public CurriculumViewController() {
    curriculumDao = CurriculumDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    ArrayList<Curriculum> list = curriculumDao.getListByCurriculumName(paramMap.get("curriculumName"));
    for (Curriculum curriculum : list) {
      out.printf("강좌소개: %s\n", curriculum.getIntroduce());
      out.printf("강좌특전: %s\n", curriculum.getBenefit());
      out.printf("강좌대상: %s\n", curriculum.getTarget());
      out.printf("강좌준비성류: %s\n", curriculum.getDocument());
      out.printf("강좌레벨테스트: %s\n", ((curriculum.isLevelTest())? "y" : "n"));
      out.printf("강좌제한인원: %d\n", curriculum.getLimit());
      out.printf("강좌시간: %d\n", curriculum.getTime());
      out.printf("강좌기간: %d\n", curriculum.getTerm());
      
    }
  }
}




