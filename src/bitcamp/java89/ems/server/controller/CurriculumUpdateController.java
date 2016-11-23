package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.CurriculumDao;
import bitcamp.java89.ems.server.vo.Curriculum;

public class CurriculumUpdateController implements Command {
  private CurriculumDao curriculumDao;

  public CurriculumUpdateController() {
    curriculumDao = CurriculumDao.getInstance();
  }

  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (!curriculumDao.existCurriculumName(paramMap.get("curriculumName"))) {
      out.print("이메일을 찾지 못했습니다.\n");
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
    
    curriculumDao.update(curriculum);
    out.print("업데이트하였습니다.\n");
  }
}

