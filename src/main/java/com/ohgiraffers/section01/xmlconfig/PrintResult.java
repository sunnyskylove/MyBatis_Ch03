package com.ohgiraffers.section01.xmlconfig;

import com.mysql.cj.util.StringInspector;

import java.util.List;

// DTO랑 Result 랑 맞춤???

public class PrintResult {

    /* 필기.
     *   사용자 -> 인포직원 -> 청소업체
     *   요청의 결과 <-       <-
     * */
    public void printMenuList(List<MenuDTO> menuList) {

        System.out.println("전체 메뉴 조회의 결과는!!!");
        for (MenuDTO menu : menuList) {

            System.out.println(menu);
        }
    }

    // 출력문 에러메세지일때, 1번~5번 만들어주기!
    public void printErrorMessage(String errorCode) {

        String errorMessage = "";
        switch (errorCode) {
            case "selectList" : errorMessage = "메뉴 전체 조회를 실패했습니다..."; break;
            case "selectOne" : errorMessage = "메뉴 코드로 메뉴 조회를 실패했습니다..."; break;
            case "insert" : errorMessage = "신규 메뉴 등록에 실패했습니다...";  break;
    }

    System.out.println(errorMessage);

    }

    public void printMenu(MenuDTO menu) {

        System.out.println(menu);   // 1개니깐 메뉴만 출력해주면 된다!

    }

    public void printSuccessMessage(String successCode) {  // 원랜 successCode가 아닌 insert 였음~(보고 이해하기 쉽게)

        String SuccessMessage = "";
        switch (successCode) {
            case "insert" : SuccessMessage = "신규 메뉴 등록을 성공하였습니다!!!"; break;
        }

        System.out.println(SuccessMessage);
    }

    //insertMenu : 어떤 내용 작성해야하는지??? / 성공적으로 구동될때 나오는 메세지??
    public void printInsertMenu(String SuccessCode) {

        String successMessage = "";
        switch (SuccessCode) {
            case "insert" : successMessage = " 정상적으로 메뉴등록 완료하였습니다. : "; break;
        }
        System.out.println(successMessage);

    }


}
