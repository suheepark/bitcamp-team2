package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.CurriculumDao;
import bitcamp.java89.ems.server.vo.Curriculum;

public class CurriculumAddController implements Command {
  private CurriculumDao curriculumDao;

  public CurriculumAddController() {
    curriculumDao = CurriculumDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    
    if (curriculumDao.existCurriculumName(paramMap.get("curriculumName"))) {
      out.println("같은 이름이 존재합니다. 등록을 취소합니다.");
      return;
    }
    
    Curriculum curriculum = new Curriculum();
    curriculum.setCurriculumName(paramMap.get("curriculumName"));
    curriculum.setIntroduce(paramMap.get("introduce"));
    curriculum.setBenefit(paramMap.get("benefit"));
    curriculum.setTarget(paramMap.get("target"));
    curriculum.setDocument(paramMap.get("document"));
    curriculum.setLevelTest((paramMap.get("levelTest").equals("true"))? true : false);
    curriculum.setLimit(Integer.parseInt(paramMap.get("limit")));
    curriculum.setTime(Integer.parseInt(paramMap.get("time")));
    curriculum.setTerm(Integer.parseInt(paramMap.get("term")));
    curriculumDao.insert(curriculum);
    out.println("등록하였습니다.");
  }
}

