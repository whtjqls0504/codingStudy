package com.source.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

class BoardBatch {

  // SQL Driver을 연결하기
  // 기존 INSERT 값을 BoardBatch문에서 임의로 넣기.
  
  Connection conn = null;
  Statement stmt = null;
  PreparedStatement pstmt = null;
  int cnt = 0;
  
  // DRIVER.URL, USERID, USERPW입력하기 -> MYSQL하고 연결하기
  public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
  public static final String URL = "jdbc:mysql://localhost:3306/cjb";
  public static final String USERID = "root";
  public static final String USERPW = "1111";
  
  
  // insert 값을 넣기
  public static final String SQL_WRITE_INSERT = 
      "INSERT INTO board"
        + "(title, content)"
        + "VALUES(?, ?)";
  
  @Test
  void test() {
      try {
        Class.forName(DRIVER);
        conn = DriverManager.getConnection(URL, USERID, USERPW);
        
        // insert
        pstmt = conn.prepareStatement(SQL_WRITE_INSERT);
        
        int num = 10;
        for (int i=0; i< num; i++) {
          pstmt.setString(1, String.format("제목%03d", i));
          pstmt.setString(2, String.format("내용이다%03d", i));
          cnt += pstmt.executeUpdate();
        }
        
        System.out.println(cnt + "개의 데이터 입력 완료");
        
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
          try {
            if(stmt != null) stmt.close();
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
          } catch (Exception e) {
            e.printStackTrace();
          }
        
        
      }

  }

}
