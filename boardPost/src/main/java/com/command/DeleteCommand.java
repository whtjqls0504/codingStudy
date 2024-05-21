package com.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.BoardDAO;

public class DeleteCommand implements Command {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) {

    int cnt = 0;
    int num = Integer.parseInt(request.getParameter("num"));
    
    try {
      cnt = new BoardDAO().delete(num);
    } catch (SQLException e) {
      e.printStackTrace();    
    }
    
    request.setAttribute("result", cnt);
  }

}
