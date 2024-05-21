package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.command.DeleteCommand;
import com.command.ListCommand;
import com.command.SelectCommand;
import com.command.UpdateCommand;
import com.command.ViewCommand;
import com.command.WriteCommand;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
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
    // 리스트 불러오기
    case "/list.do":
      command = new ListCommand();
      command.execute(request, response);
      viewPage = "list.jsp";
      break;
     
    // 게시물 상세보기
    case "/view.do":
      command = new ViewCommand();
      command.execute(request, response);
      viewPage = "view.jsp";
      break;
      
    // 글 작성하기.
    case "/write.do":
      viewPage = "write.jsp";
      break;
    case "/writeOk.do":
      command = new WriteCommand();
      command.execute(request, response);
      viewPage = "writeOk.jsp";
      break;
    
    // 글 수정
    case "/update.do":
      command = new SelectCommand();
      command.execute(request, response);
      viewPage = "update.jsp";
      break;
    case "/updateOk.do" :
      command = new UpdateCommand();
      command.execute(request, response);
      viewPage = "updateOk.jsp";
      break;
    // 글 삭제 
    case "/deleteOk.do":
      command = new DeleteCommand();
      command.execute(request, response);
      viewPage = "deleteOk.jsp";
      break;
    }
    
    // view Page로 forward
    if(viewPage != null) {
      RequestDispatcher dispatcher = 
          request.getRequestDispatcher("/WEB-INF/views/board/" + viewPage);
      dispatcher.forward(request, response);
    }
    
	  
	  
//	  actionDo(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
		doGet(request, response);
	}
	
//	protected void actionDo(HttpServletRequest request, HttpServletResponse response) 
//	throws ServletException, IOException {
//	  
//	 
//	  
//	  
//	}

}
