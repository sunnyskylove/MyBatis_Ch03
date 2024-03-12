package com.ohgiraffers.section01.xmlconfig;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        /* 필기.
         *   우리는 아직 view 즉 사용자들이 정보를 입력할 수 있는 화면을 배우지 않았다.
         *   따라서 아직은 Application 이 view 라고 생각하고 진행을 해보자.
         * */

        /* 필기.
         *   시스템 요구사항
         *   1. 메뉴 전체 조회
         *   2. 메뉴 코드로 메뉴 조회
         *   3. 신규 메뉴 추가
         *   4. 메뉴 수정
         *   5. 메뉴 삭제
         * */

        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();
        // 없는 클래스이기 때문에 alt+enter 해서 클래스 생성하기!(앞으로 많아짐.......ㅠㅠ)

        do {
            System.out.println("===========오지라퍼 메뉴 관리 시스템=============");
            System.out.println("1. 메뉴 전체 조회하기");
            System.out.println("2. 메뉴 코드로 메뉴 조회하기");
            System.out.println("3. 신규 메뉴 등록하기");
            System.out.println("4. 메뉴 수정하기");
            System.out.println("5. 메뉴 삭제하기");

            System.out.println("메뉴 관리 번호를 입력해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                // 1. break 앞에 명령어!(사용자->인포직원에게 모든메뉴 조회해줘 명령)
                case 1: menuController.selectAllMenu(); break;
                case 2: menuController.selectMenuByCode(inputMenuCode()); break;
                case 3: menuController.registMenu(inputMenu()); break;
                case 4: menuController.editMenu(updateMenu()); break;
                case 5: menuController.deleteMenu(deleteMenu());break;
                default:
                    System.out.println("잘못된 메뉴를 입력하셨습니다. ");
                    break;
            }

        } while (true);

    }

    private static  Map<String, String> deleteMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" 삭제할 메뉴 코드를 입력해주세요 : ");
        String code = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;
    }

    private static Map<String, String> inputMenuCode() {  // Object ->Map<>으로 변경함!!

        Scanner sc = new Scanner(System.in);
        System.out.println("조회할 메뉴 코드를 입력해주세요. : ");
        String code = sc.nextLine();

        // ▼ 위에 작성한 code 라는 값을 ▼
        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);  // key = code, value= 4(숫자)다

        return parameter;

    }

    private static Map<String, String> inputMenu() {

        /* 메뉴 이름, 메뉴 가격, 카테고리 코드를 입력 받아 넘겨준다. */
        Scanner sc = new Scanner(System.in);
        System.out.println("메뉴 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.println("메뉴 가격을 입력하세요 : ");
        String price = sc.nextLine();
        System.out.println("카테고리 코드를 입력하세요 :");
        String categoryCode = sc.nextLine();

        // parameter에 위에서 작성한 "이름,가격,카테고리코드" 가 다 들어있는 것이다!
        Map<String ,String > parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("price", price);
        parameter.put("categoryCode", categoryCode);

        return parameter;

    }

    // 수정메뉴만들기:
    private static Map<String, String> updateMenu(){

        /* 메뉴 이름, 메뉴 가격, 카테고리 코드를 입력 받아 넘겨준다.*/
        Scanner sc = new Scanner(System.in);
        System.out.println("업데이트 할 메뉴 코드를 입력해주세요 : ");
        String code = sc.nextLine();
        System.out.println("업데이트 할 메뉴 이름을 입력해주세요 ");
        String name = sc.nextLine();
        System.out.println("메뉴 가격을 입력해주세요. : ");
        String price = sc.nextLine();
        System.out.println("카테고리 코드를 입력해주세요 : ");
        String categoryCode = sc.nextLine();

        // * 여기 잘 이해안감..ㅠㅠ
        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);
        parameter.put("name", name);
        parameter.put("price", price);
        parameter.put("categoryCode", categoryCode);

        return parameter;

    }

}