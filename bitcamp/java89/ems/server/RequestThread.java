package bitcamp.java89.ems.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class RequestThread extends Thread {
  private Scanner in;
  private PrintStream out;
  private Socket socket;
  private HashMap<String, Command> commandMap;
  
  public RequestThread (Socket socket, HashMap<String, Command> commandMap) {
    this.socket = socket;
    this.commandMap = commandMap;
  }
  @Override
  public void run() {
    try  { // 외부 변수를 쓰기 때문에 () 이 괄호 안씀  
      // in out 은 다른 메서드에서 사용하므로 내부에 변수 선언 을 하면 안된다.
      in = new Scanner(
       new BufferedInputStream(socket.getInputStream()));
      out = new PrintStream(
       new BufferedOutputStream(socket.getOutputStream()), true);
      
      out.println("비트캠프 관리시스템에 오신걸 환영합니다.");
      
      loop:
      while (true) {
       // 클라이언트에게 데이터를 전송한다.
        out.println("명령>");
        out.println(); // 빈 줄은 보내는 데이터의 끝을 의미한다.
       
       // 클라이언트로부터 명령을 읽는다.
       // 클라이언트가 보낸 명령문을 분석하여 명령어와 파라미터 로 분리 추출한다.
        String[] command = in.nextLine().split("\\?");
       
        HashMap<String,String> paraMap = new HashMap<>();
       
       // 파라미터 문자열이 있다면 이 문자열을 분석하여 HashMap에 보관
        if (command.length == 2) {
        String[] params = command[1].split("&");
          for (String value : params) {
            String[] kv = value.split("=");
            paraMap.put(kv[0], kv[1]);
          }
        }
       
         Command commandHandler = commandMap.get(command[0]);
         
         if (commandHandler == null) {
           if (command[0].equals("quit")) {
             doQuit();
             break;
           }
           out.println("지원하지 않는 명령어입니다.");
           continue; // 다음줄 실행 안하고 반복문 조건 검사로 건너 뛴다.
         } 
         // 클라이언트가 보낸 명령을 처리할 객체가 있다면 작업을 실행한다.
         commandHandler.service(paraMap, out);
      }
    } catch (Exception e) {
    
    } finally {
    try { in.close(); } catch (Exception e) {}
    try { out.close(); } catch (Exception e) {}
    try { socket.close(); } catch (Exception e) {}
    }
   
  }

  private boolean doQuit() {
    doSave();
    System.out.println("클라이언트 연결 종료");
    return true;
  }

  private void doSave() {
    try {
//      teacherController.save();
    } catch (Exception e) {
      System.out.println("학생 정보 저장 중에 오류가 발생했습니다.");
    }
    try {
//      contactController.save();
    } catch (Exception e) {
      System.out.println("연락처 정보 저장 중에 오류가 발생했습니다.");
    }
  }
}
