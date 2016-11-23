/* 작업내용: 직렬화 적용 
*/
package bitcamp.java89.ems.server.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import bitcamp.java89.ems.server.vo.Contact;
import bitcamp.java89.ems.server.vo.Teacher;

public class TeacherDao {
  private String filename = "teacher-v1.7.data";
  private ArrayList<Teacher> list;
  static TeacherDao obj;
  
  public static TeacherDao getInstance() {
    if (obj == null) {
      obj = new TeacherDao();
    }
    return obj;
  }
  private TeacherDao() {
    
    this.load(); 
  }
  


  @SuppressWarnings("unchecked")
  private void load() {
    FileInputStream in0 = null;
    ObjectInputStream in = null;
    try  {
      in0 = new FileInputStream(this.filename);
      in = new ObjectInputStream(in0);
      
      list = (ArrayList<Teacher>)in.readObject();
     
    } catch (EOFException e) {
      // 파일을 모두 읽었다.
    } catch (Exception e) {
      System.out.println("학생 데이터 로딩 중 오류 발생!");
      list = new ArrayList<Teacher>();
      //e.printStackTrace();
    } finally {
      
      try {
        in.close();
        in0.close();
      } catch (Exception e) {}

    }
  }

  public void save() throws Exception {
    FileOutputStream out0 = new FileOutputStream(this.filename);
    ObjectOutputStream out = new ObjectOutputStream(out0);

    out.writeObject(list);
    out.close();
    out0.close();
  }
  public ArrayList<Teacher> getList() {
     return this.list;
  }
  public ArrayList<Teacher> getListByName(String name) {
    ArrayList<Teacher> results = new ArrayList<Teacher>();
    for (Teacher teacher : list) {
      if (teacher.getName().equals(name)) {
        results.add(teacher);
      }
    }
    return results;
  }

  synchronized public void insert(Teacher teacher) {
   list.add(teacher);
   try {this.save(); } catch (Exception e) {}
   
  }
  synchronized public void update(Teacher teacher) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getEmail().equals(teacher.getEmail())) {
       list.set(i, teacher);
       try {this.save(); } catch (Exception e) {}
       return;
      }
    }
  }

  public boolean existEmail(String email) {
    for (Teacher teacher : list) {
      if (teacher.getEmail().toLowerCase().equals(email.toLowerCase())) {
        return true;
      }
    }
    return false;
  }

  public boolean existName(String name) {
    for (Teacher teacher : list) {
      if (teacher.getName().toLowerCase().equals(name.toLowerCase())) {
        return true;
      }
    }
    return false;
  }
  synchronized public void delete(String name)  {
    
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getName().equals(name)) {
        list.remove(i);
        try {this.save(); } catch (Exception e) {}
        return;
      }
    }
  }
  
}
