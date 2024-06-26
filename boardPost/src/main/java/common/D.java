package common;

public class D {
  
  // DRIVER.URL, USERID, USERPW입력하기 -> MYSQL하고 연결하기
  public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
  public static final String URL = "jdbc:mysql://localhost:3306/cjb";
  public static final String USERID = "root";
  public static final String USERPW = "1111";
  
  
  // INSERT
  public static final String SQL_WRITE_INSERT = 
      "INSERT INTO board"
        + "(title, content)"
        + "VALUES(?, ?)";
  
  public static final String SQL_BOARD_SELECT =
      "SELECT num num, title title, content content," 
      + "upload_date uploadDate "
      + "FROM board ORDER BY num DESC";
  
  public static final String SQL_BOARD_SELECT_BY_NUM = 
      "SELECT num num, title title, content content,"
      + "upload_date uploadDate "
      + "FROM board WHERE num = ?";
  
  public static final String SQL_BOARD_UPDATE = 
      "UPDATE board SET title = ?, content = ? WHERE num = ?";
  
  
  public static final String SQL_BOARD_DELETE = 
      "DELETE FROM board WHERE num =?";
  
  
}
