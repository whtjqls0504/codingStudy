package com.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.protocol.ResultsetRow;

import common.D;

public class BoardDAO {

  Connection conn;
  PreparedStatement pstmt;
  ResultSet rs;
  
  public BoardDAO() {
    try {
      Class.forName(D.DRIVER);
      conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void close() throws SQLException {
      if(rs != null) rs.close();
      if(pstmt != null) pstmt.close();
      if(conn != null) conn.close();
  }

  
  // list가져오기
  
  private List<BoardDTO> buildList(ResultSet rs) throws SQLException {
    
    List<BoardDTO> list = new  ArrayList<>();
    
    while (rs.next()) {
      int num = rs.getInt("num");
      String title = rs.getString("title");
      String content = rs.getString("content");
      
      // 만약, 내용물이 비어있으면 비어있는채로 두어라?
      if(content  == null) content = "";
      LocalDateTime uploadDate = rs.getObject("uploadDate", LocalDateTime.class);
      
      BoardDTO dto = new BoardDTO(num, title, content, uploadDate);
      list.add(dto);
      
    }
    return list;
    
  }
  
  
  
  
  
  public List<BoardDTO> select() throws SQLException {

    List<BoardDTO> list = null;
    
    try {
      pstmt = conn.prepareStatement(D.SQL_BOARD_SELECT);
      rs = pstmt.executeQuery();
      list = buildList(rs);
      
    } finally {
      close();
    }
    
    return list;
  }
  
}
