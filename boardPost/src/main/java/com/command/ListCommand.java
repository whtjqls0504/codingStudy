package com.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.BoardDAO;
import com.beans.BoardDTO;

public class ListCommand implements Command {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) 
  {

    List<BoardDTO> list = null;
    
    try {
       list = new BoardDAO().select();
       
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    request.setAttribute("list", list);
  }

}
