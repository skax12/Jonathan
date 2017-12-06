package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MyDao;
import com.dto.MyDto;

@WebServlet("/controller.do")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		MyDao dao = new MyDao();
		 if(command.equals("TestList")) {
			 
			 List<MyDto> list = dao.selectAll();
			 System.out.println(list.size());
			 request.setAttribute("list", list);
			
			dispatch("TestList.jsp",request,response);

		 }else if(command.equals("writeform")) {
			 response.sendRedirect("QnA.jsp");
			
		 }else if(command.equals("write")) {
			 String title = request.getParameter("title");
			 String content = request.getParameter("content");
			 System.out.println(title);
			 System.out.println(content);
			 MyDto dto = new MyDto(title, content);
			 int res = dao.insert(dto);
			 if (res>0) {
				 response.sendRedirect("controller.do?command=TestList");
				 
			 }else {
				 dispatch("controller.do?command=writeform", request, response);
			 }
			 
		 }else if(command.equals("detail")) {
				int num=Integer.parseInt(request.getParameter("num"));
				MyDto dto =dao.selectOne(num);
				request.setAttribute("dto", dto);
				dispatch("Detail.jsp", request, response);
			
			}else if(command.equals("answer")) {
				int num=Integer.parseInt(request.getParameter("num"));
				MyDto dto = dao.selectOne(num);
				request.setAttribute("dto", dto);
				dispatch("QnAanswer.jsp", request, response);
				
			}else if(command.equals("answerWrite")) {
				int num=Integer.parseInt(request.getParameter("num"));
				String title = request.getParameter("title");
				String content=request.getParameter("content");
				String name = request.getParameter("name");
				
				MyDto old = dao.selectOne(num);
				int groupNo=old.getGroupNo();
				int groupSq=old.getGroupSq();
				int titleTab=old.getTitleTab();
				
				MyDto dto = new MyDto(groupNo, groupSq, titleTab, name, title, content);
				int pushSeq = dao.update(groupNo, groupSq);
				if(pushSeq>0) {
					System.out.println("�о�� ����");
				}else {
					System.out.println("�о����� or �о �� ����");
				}
				int res =dao.insertAnswer(dto);
				if(res>0) {
					response.sendRedirect("controller.do?command=TestList");
				}else {
					response.sendRedirect("controller.do?command=detail&num="+num);
				
				}
			}else if(command.equals("delete")) {
				
				int num = Integer.parseInt(request.getParameter("num"));
				int res = dao.delete(num);
				if(res>0 ) {
					response.sendRedirect("controller.do?command=TestList");
				}else {
					response.sendRedirect("controller.do?command=detail&num="+num);
					
				}
				
			}else if(command.equals("update")) {
				int num = Integer.parseInt(request.getParameter("num"));
				
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				MyDto dto = new MyDto(num, title, content);
				int res = dao.update(dto);
				if(res>0) {
					System.out.println("if왓더");
					dispatch("controller.do?command=detail&num="+num, request, response);
					
				}else {
					response.sendRedirect("controller.do?command=dtail&num="+num);
					
				}
				
				
				
			}
		
		
	}

	public void dispatch(String url,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatch=request.getRequestDispatcher(url);
		dispatch.forward(request, response);
		
		
	}
	
	
}
