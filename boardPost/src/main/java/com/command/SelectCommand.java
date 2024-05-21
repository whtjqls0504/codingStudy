package com.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.BoardDAO;
import com.beans.BoardDTO;

public class SelectCommand implements Command {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) {

    int num = Integer.parseInt(request.getParameter("num"));
    List<BoardDTO> list = null;
    
    try {
      list = new BoardDAO().selectByNum(num);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    request.setAttribute("list", list);
  }

}
