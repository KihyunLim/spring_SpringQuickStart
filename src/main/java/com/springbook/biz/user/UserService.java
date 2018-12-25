package com.springbook.biz.user;

public interface UserService {

	// 회원 등록이라고 책에는 주석이 달려있는데 걍 조회네...나중에 로그인에 같이 쓰러냐??
	UserVO getUser(UserVO vo);

}