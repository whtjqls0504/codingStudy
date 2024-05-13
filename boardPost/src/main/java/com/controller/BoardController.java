package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.command.ListCommand;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
	  actionDo(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
	  
	  // 인코딩하기
	  request.setCharacterEncoding("UTF-8");
	  
	  Command command = null;  // 어떠한 로직을 수행할 것인가?? -> HttpServletRequest, HttpServletResponse
	  String viewPage = null;  // 어떠한 페이지를 보여줄 것인가?
	  
	  // URL로부터 command를 분리하자.
	  
	  String uri = request.getRequestURI();          // /board/list.do
	  String conPath = request.getContextPath();     // /board
	  String com = uri.substring(conPath.length());  // list.do
	  
	  switch(com) {
	  case "/list.do":
	    command = new ListCommand();
	    command.execute(request, response);
	    viewPage = "list.jsp";
	    break;
	  case "/view.do":
	    break;
	  case "/write.do":
	    break;
	  case "/writeOk.do":
	    break;
	  case "/update.do":
	    break;
	  case "/deleteOk.do":
	    break;
	  }
	  
	  // view Page로 forward
	  if(viewPage != null) {
	    RequestDispatcher dispatcher = 
	        request.getRequestDispatcher("/WEB-INF/views/board/" + viewPage);
	    dispatcher.forward(request, response);
	  }
	  
	  
	  
	}

}
