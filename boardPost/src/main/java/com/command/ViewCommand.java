package com.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.BoardDAO;
import com.beans.BoardDTO;

public class ViewCommand implements Command {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) {

      List<BoardDTO> list = null;
      
      int num = Integer.parseInt(request.getParameter("num"));
      
      try {
         list = new BoardDAO().readByNum(num);
         
      } catch (SQLException e) {
          e.printStackTrace();
      }
        request.setAttribute("list", list);    

}
  
}
