package com.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.BoardDAO;
import com.beans.BoardDTO;

public class WriteCommand implements Command {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) {
    int cnt = 0;
    
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    
    BoardDTO dto = new BoardDTO();
    dto.setTitle(title);
    dto.setContent(content);
    
    if(title != null && title.trim().length() > 0) {

      try {
        cnt = new BoardDAO().insert(dto);
      } catch (Exception e) {
          e.printStackTrace();
      }
      
    }
 
      request.setAttribute("result", cnt);
      request.setAttribute("dto", dto);
    
    
  }

}
