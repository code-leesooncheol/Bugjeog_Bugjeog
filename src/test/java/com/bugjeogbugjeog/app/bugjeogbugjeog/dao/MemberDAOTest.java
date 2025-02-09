package com.bugjeogbugjeog.app.bugjeogbugjeog.dao;


import com.bugjeogbugjeog.app.bugjeogbugjeog.domain.dao.MemberDAO;
import com.bugjeogbugjeog.app.bugjeogbugjeog.domain.vo.BusinessVO;
import com.bugjeogbugjeog.app.bugjeogbugjeog.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberDAOTest {
    @Autowired
    MemberDAO memberDAO;

//    자영업자 회원가입
    @Test
    public void insertTest() {
        MemberVO memberVO = new MemberVO();

        memberVO.setMemberEmail("jjy1234@naver.com");
        memberVO.setMemberName("정지영");
        memberVO.setMemberPhoneNumber("01071228966");
        memberVO.setMemberPassword("1234");

        memberDAO.register(memberVO);
    }

//    이메일 중복검사
    @Test
    public void selectEmail() {
        log.info(memberDAO.findByEmail("jjy1234@naver.com").toString());
    }

//    휴대폰번호 중복검사
    @Test
    public void selectPhoneNumber() {
        log.info(memberDAO.findByPhoneNumber("01012341234").toString());
    }

//    자영업자 로그인
    @Test
    public void loginTest() {
        MemberVO memberVO = new MemberVO();

        memberVO.setMemberEmail("jjy1234@naver.com");
        memberVO.setMemberPassword("d2pkd2xkdWQxIQ==");
        log.info("memberId : " + memberDAO.findByMemberId(memberVO));
    }

//    유통업체 회원가입
    @Test
    public void insertBusinessTest() {
        BusinessVO businessVO = new BusinessVO();

        businessVO.setBusinessEmail("jjy1111@naver.com");
        businessVO.setBusinessCeoName("정지영");
        businessVO.setBusinessCompanyName("주식");
        businessVO.setBusinessEstablishmentDate("2019/05/25");
        businessVO.setBusinessNumber("111-11-11111");
        businessVO.setBusinessPhoneNumber("01012341111");
        businessVO.setBusinessPassword("wjdwldud1!");
        memberDAO.registerBusiness(businessVO);
    }

//    유통업체 이메일 중복검사
    @Test
    public void businessSelectByEmail() {
        log.info("businessId : " + memberDAO.businessFindByEmail("jjy1234@naver.com"));
    }

//    유통업체 휴대폰 중복검사
    @Test
    public void businessSelectByPhoneNumber() {
        log.info("businessPhoneNumber : " + memberDAO.businessFindByPhoneNumber("01012341234"));
    }

//    유통업체 로그인
    @Test
    public void selectByBusinessIdAndBusinessPassword() {
        log.info("businessId : " + memberDAO.findByBusinessId("jjy1234@naver.com", "d2pkd2xkdWQxIQ=="));
    }

//    자영업자 계정 찾기
    @Test
    public void findEmail() {
        log.info("memberEmail : " + memberDAO.findByPhoneNumberForEmail("01012341234"));
    }

//    사업자 계정 찾기
    @Test
    public void businessFindEmail() {
        log.info("memberEmail : " + memberDAO.businessFindByPhoneNumberForEmail("01012341234"));
    }

//   자영업자 비밀번호 변경
    @Test
    public void updatePassword() {
        memberDAO.setPassword("jjy1234@naver.com", "wjdwldud1!!");
    }

//   사업자 비밀번호 변경
    @Test
    public void businessUpdatePassword() {
        memberDAO.businessSetPassword("jjy1234@naver.com", "wjdwldud1!!");
    }

//    자영업자 계정 상태 조회
    @Test
    public void selectForStatus() {
        log.info("memberStatus : " + memberDAO.findForStatus("jjy1234@naver.com"));
    }

//    사업자 계정 상태 조회
    @Test
    public void businessSelectForStatus() {
        log.info("businessStatus : " + memberDAO.businessFindForStatus("jjy1234@naver.com"));
    }
}
