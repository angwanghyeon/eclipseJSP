package com.keduit.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduit.dao.BoardDAO;
import com.keduit.dto.BoardVo;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("num");
		
		BoardDAO bd = BoardDAO.getInstance();
		bd.updateReadcount(num);
		BoardVo bv =  bd.selectOne(num);
		request.setAttribute("board", bv);
		
		RequestDispatcher disp = request.getRequestDispatcher("/board/boardView.jsp");
		disp.forward(request, response);
	}

}