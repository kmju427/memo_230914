package com.memo.user.bo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserBOTest {

	@Autowired
	UserBO userBO;
	
	@Transactional // rollback
	@Test
	void 유저추가테스트() {
		log.info("######## 유저 추가 테스트 시작");
		userBO.addUser("test2222", "비번 테스트2", "테스트2", "test2@test.com");
	}

} // class UserBOTest