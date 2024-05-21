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
  
  
  public BoardDAO() {   // 데이터베이스 연결하기
    try {
      // jdbc 드라이버 로드
      // jdbc : 데이터베이스와의 통신을 담당하는 인터페이스이다.
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

  public int insert(BoardDTO dto) throws SQLException {

    int cnt = 0;
    
    String title = dto.getTitle();
    String content = dto.getContent();
    
    int num;
    String[] generatedCols = {"num"};
    
    try {
      pstmt = conn.prepareStatement(D.SQL_WRITE_INSERT, generatedCols);
      pstmt.setString(1, title);
      pstmt.setString(2, content);
      cnt = pstmt.executeUpdate();
      
      if (cnt >0) {
        rs = pstmt.getGeneratedKeys();
        if(rs.next()) {
          num = rs.getInt(1);
          dto.setNum(num);
        }
      }
      
    } finally {
      close();
    }
    
    return cnt;
  }

  
  // view.do를 위한 Dao
  public List<BoardDTO> readByNum(int num) throws SQLException {

    List<BoardDTO> list = null;
    
    try {
      //????
      conn.setAutoCommit(false);
     
      pstmt = conn.prepareStatement(D.SQL_BOARD_SELECT_BY_NUM);
      pstmt.setInt(1, num);
      rs = pstmt.executeQuery();
      list = buildList(rs);
      
      conn.commit();
      
    } catch (SQLException e) {
        conn.rollback();
        throw e;
      
    } finally {
        close();
    }
    
    return list;
  }

  public List<BoardDTO> selectByNum(int num) throws SQLException{
    List<BoardDTO> list = null;
    
    try {
      pstmt = conn.prepareStatement(D.SQL_BOARD_SELECT_BY_NUM);
      pstmt.setInt(1, num);
      rs = pstmt.executeQuery();
      list = buildList(rs);
    } finally {
      close();
    }
    
    return list;
  }

  public int update(int num, String title, String content) throws SQLException {
    
    int cnt = 0;
    
    try {
      pstmt = conn.prepareStatement(D.SQL_BOARD_UPDATE);
      pstmt.setString(1, title);
      pstmt.setString(2, content);
      pstmt.setInt(3, num);
      cnt = pstmt.executeUpdate();
      
    } finally {
      close();
    }
    
    
    return cnt;
  }

  public int delete(int num) throws SQLException {

    int cnt = 0;
    
    try {
      pstmt = conn.prepareStatement(D.SQL_BOARD_DELETE);
      pstmt.setInt(1, num);
      cnt = pstmt.executeUpdate();
      
    } finally {
      close();
    }
    
    return cnt;
  }
  
}
