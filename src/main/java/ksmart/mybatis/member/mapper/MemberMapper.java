package ksmart.mybatis.member.mapper;

import java.util.List;

import ksmart.mybatis.member.dto.Search;
import org.apache.ibatis.annotations.Mapper;

import ksmart.mybatis.member.dto.Member;
import ksmart.mybatis.member.dto.MemberLevel;

@Mapper
public interface MemberMapper {
	// 회원 검색 조회
	List<Member> getSearchList(Search search);

	// 판매자 현황
	List<Member> getSellerList();
	
	// 회원 탈퇴
	int removeMemberById(String memberId);
	
	// 회원 로그인 이력 삭제
	int removeLoginHistoryById(String memberId);
	
	// 회원수정
	int modifyMember(Member member);
	
	// 특정회원정보조회
	Member getMemberInfoById(String memberId);
	
	// 회원가입
	int addMember(Member member);
	
	// 아이디 중복체크
	boolean idCheck(String memberId);
	
	// 회원등급 조회
	List<MemberLevel> getMemberLevelList();

	// 회원목록 조회
	List<Member> getMemberList();
}
