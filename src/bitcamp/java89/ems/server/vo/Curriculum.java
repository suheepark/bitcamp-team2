package bitcamp.java89.ems.server.vo;

import java.io.Serializable;

public class Curriculum implements Serializable {
  //인스턴스 변수
  public String curriculumName;
  public String introduce;
  public String benefit;
  public String target;
  public String document;
  public boolean levelTest;
  public int limit;
  public int time;
  public int term;

  public Curriculum() {
    super();
  }

  public Curriculum(String curriculumName, String benefit, String document, int limit, int time) {
    this.curriculumName = curriculumName;
    this.benefit = benefit;
    this.document = document;
    this.limit = limit;
    this.time = time;
  }

  public String getCurriculumName() {
    return curriculumName;
  }

  public void setCurriculumName(String curriculumName) {
    this.curriculumName = curriculumName;
  }

  public String getIntroduce() {
    return introduce;
  }

  public void setIntroduce(String introduce) {
    this.introduce = introduce;
  }

  public String getBenefit() {
    return benefit;
  }

  public void setBenefit(String benefit) {
    this.benefit = benefit;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public String getDocument() {
    return document;
  }

  public void setDocument(String document) {
    this.document = document;
  }

  public boolean isLevelTest() {
    return levelTest;
  }

  public void setLevelTest(boolean levelTest) {
    this.levelTest = levelTest;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
  }

  public int getTerm() {
    return term;
  }

  public void setTerm(int term) {
    this.term = term;
  }
  
}
