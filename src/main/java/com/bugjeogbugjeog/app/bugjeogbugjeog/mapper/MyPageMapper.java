package com.bugjeogbugjeog.app.bugjeogbugjeog.mapper;

import com.bugjeogbugjeog.app.bugjeogbugjeog.domain.dto.MemberInquireDTO;
import com.bugjeogbugjeog.app.bugjeogbugjeog.domain.dto.MemberLikeDTO;
import com.bugjeogbugjeog.app.bugjeogbugjeog.domain.dto.MyPageReplyDTO;
import com.bugjeogbugjeog.app.bugjeogbugjeog.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MyPageMapper {

//    회원정보 조회
    public MemberVO select(Long memberId);

//    회원정보 수정
    public void update(MemberVO memberVO);

//    회원정보 삭제
    public void deleteMember(Long memberId);

//    휴대폰 모든 정보 조회
    public List<String> selectAllPhoneNumber();

//    유통업체 회원정보 조회
    public BusinessVO selectBuisness(Long businessId);

//    좋아요 한 게시물 수
    public Integer likeCount(Long memberId);

//    좋아요 한 게시물 리스트
    public List<BoardFreeVO> likeList(@Param("memberId") Long memberId, @Param("criteria") Criteria criteria);

//    문의 작성 목록
    public List<BoardInquiryVO> inquireList(@Param("memberId") Long memberId,@Param("criteria") Criteria criteria);

//    문의 게시글 작성 갯수
    public Integer inquireCount(Long memberId);

//    문의 답변 여부
    public Long inquireAnswer(Long boardInquireId);

//  댓글 단 게시물 목록
    public List<MyPageReplyDTO> replyList(@Param("memberId") Long memberId,@Param("criteria") Criteria criteria);

//    댓글 단 갯수
    public Integer replyCount(Long memberId);

//  자유 게시판 목록
    public List<BoardFreeVO> freeList(@Param("memberId") Long memberId,@Param("criteria") Criteria criteria);

//    자유 게시판 개수
    public Integer freeCount(Long memberId);

    //유통 분야 설정 추가
    public void updateLocation(BusinessVO businessVO);


}
