package spring.service;

import spring.dao.BoardDao;
import spring.dao.MemberDao;
import spring.exception.AlreadyExistingMemberException;
import spring.vo.Board;
import spring.vo.Member;
import spring.vo.RegisterPostRequest;
import spring.vo.RegisterRequest;

public class PostRegisterService {
	
	private BoardDao boardDao;

	public PostRegisterService(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	public void pregist(RegisterPostRequest preq) {
	
			
				Board newBoard = new Board(preq.getMemberName(),preq.getQnaBoardTitle(),preq.getQnaBoardContent());
				
				boardDao.insert(newBoard); // 게시글 등록
		
	}

}
