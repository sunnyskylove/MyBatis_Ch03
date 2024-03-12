package com.ohgiraffers.section01.xmlconfig;

/* 필기.
*   # Service 의 역할
*   1. SqlSession 생성
*   2. DAO(데이터베이스 접근 객체)의 메소드 호출
*   3. 트랜젝션(commit, rollback) 제어
*   4. SqlSession 닫기
* */

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

// * 실제 중요한 로직들, 실제 명령을 실행하는 걸 담당하는 것이 Service 의 역할 (=DAO)
public class MenuService {
    private final MenuDAO menuDAO;      // MenuDAO 도 새로운 클래스 생성!

    public MenuService() {
        this.menuDAO = new MenuDAO();
    }

    public List<MenuDTO> selectAllMenu() {

        SqlSession sqlSession = getSqlSession();        // ?? 연결 만들기

        List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);
        // selectAllMenu 로 또 명령, (통로) 만들어줌

        sqlSession.close();

        return menuList;

    }

    public MenuDTO selectMenuByCode(int code) {
        SqlSession sqlSession = getSqlSession();

        // 아까는 전체를 조회했지만 여기서는 1행만 조회하면 됨!
        MenuDTO menu = menuDAO.selectMenuByCode(sqlSession, code);

        sqlSession.close();

        return menu;

    }

    public boolean registMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.insertMenu(sqlSession, menu);

        // 트랜젝션
        if(result > 0) {                 // 0보다 커야 참!
            sqlSession.commit();        // 성공시ㅣ: 제출해주겠다~
        } else {
            sqlSession.rollback();          // 실패시: (NO!) 내가 다시 돌려보내겠다.
        }

        sqlSession.close();

        return result > 0 ? true : false;

    }



    public boolean editMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.editMenu(sqlSession, menu);

        // 트랜젝션
        if(result > 0) {                 // 0보다 커야 참!
            sqlSession.commit();        // 성공시ㅣ: 제출해주겠다~
        } else {
            sqlSession.rollback();          // 실패시: (NO!) 내가 다시 돌려보내겠다.
        }

        sqlSession.close();

        return result > 0 ? true : false;           // 따라서 밑에 result 1,0 값은 참,거짓으로 표현된다!

    }

    public boolean deleteMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.deleteMenu(sqlSession, menu);

        // 트랜젝션
        if(result > 0) {                 // 0보다 커야 참!
            sqlSession.commit();        // 성공시ㅣ: 제출해주겠다~
        } else {
            sqlSession.rollback();          // 실패시: (NO!) 내가 다시 돌려보내겠다.
        }

        sqlSession.close();

        return result > 0 ? true : false;

    }
}
