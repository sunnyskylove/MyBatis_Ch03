package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    private static SqlSessionFactory sqlSessionFactory;


    public static SqlSession getSqlSession() {
        // template 이기때문에 한번 만들어주면 변경 안하고, 나중에 새로운 메소드 getSqlSession 만 변경해주면 된다.

        if (sqlSessionFactory == null) {
            String resource = "com/ohgiraffers/section01/xmlconfig/mybatis-config.xml";

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);

                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


            } catch (IOException e) {
                throw new RuntimeException(e);

            }

        }

        return sqlSessionFactory.openSession(false);
        // sqlSession 타입에 객체가 하나 return 되는 것이다.

    }

}