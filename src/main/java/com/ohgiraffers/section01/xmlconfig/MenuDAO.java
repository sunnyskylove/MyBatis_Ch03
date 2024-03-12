package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {


    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {
        //  xml 쿼리만들어서 했던걸 호출 할 수 있는 것 만들기~

        return sqlSession.selectList("MenuMapper.selectAllMenu");

    }

    public MenuDTO selectMenuByCode(SqlSession sqlSession, int code) {

        return sqlSession.selectOne("MenuMapper.selectMenuByCode", code);

    }

    // insertMenu
    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.insert("MenuMapper.insertMenu", menu);

    }

    public int editMenu(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.insert("MenuMapper.updateMenu", menu);

    }

    public int deleteMenu(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.insert("MenuMapper.deleteMenu", menu);
    }
}
