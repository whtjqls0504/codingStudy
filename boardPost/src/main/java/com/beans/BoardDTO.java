package com.beans;

import java.time.LocalDateTime;

public class BoardDTO {

  private int num;                // num int
  private String title;           // title varchar
  private String content;         // content text
  private LocalDateTime uploadDate;  // upload_date  datetime
  
  
  // 이건뭐임?
  // 자바 생성자로, 객체를 초기화하는 데 사용되는 특수한 메소드.
  // 클래스에 생성자를 정의하지 않으면 자바는 기본적으로 매개변수 없는 기본 생성자를 제공한다.
  
  public BoardDTO() {
    super();
  }
  
  
  public BoardDTO(int num, String title, String content, LocalDateTime uploadDate) {
    super();
    this.num = num;
    this.title = title;
    this.content = content;
    this.uploadDate = uploadDate;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public LocalDateTime getUploadDate() {
    return uploadDate;
  }


  public void setUploadDate(LocalDateTime uploadDate) {
    this.uploadDate = uploadDate;
  }



  
  
}
