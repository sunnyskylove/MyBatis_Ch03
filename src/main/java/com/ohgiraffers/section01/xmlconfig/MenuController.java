package com.ohgiraffers.section01.xmlconfig;

/* 필기.
 *   # Controller 의 역할
 *   view 즉 현재는 Application 에서 사용자가 입력한 정보를 파라미터 형태로 전달을 받으면
 *   전달 받은 값들을 검증하거나 추가적인 정보가 필요한 경우 가공을 한 뒤,
 *   service 쪽으로 전달하기 위한 인스턴스를 담고 서비스의 비즈니스 로직을 담당하는 method 를 호출한다.
 *   또한 호출한 수행 결과를 반환 받아 어떠한 뷰를 다시 사용자에게 보여줄 것인지를 결정하는 역할을 한다.
 * */

import java.util.List;
import java.util.Map;

public class MenuController {

    // 선언과 동시에 초기화, 생성자를 통해 초기화 할 수 있었는데, final 를 붙이면 불변의 기능을 함으로써,
    // 메뉴서비스를 만들 준비를 한다!
    private final MenuService menuService;          // MenuService 클래스도 없어서, 클래스 새로 만들어준다.
    private final PrintResult printResult;      // 모든 수행 결과물을 보여줄 수 있는 페이지 만들 것임

    public MenuController() {
        this.menuService = new MenuService();
        this.printResult = new PrintResult();   // 얘도 위에 새로 또 만들어줬으니 초기화 해줘야함!
    }

    public void selectAllMenu() {

// <Type>, 메뉴 서비스에 뭔가를 전달~~, selectAllMenu 클래스 추가!
        List<MenuDTO> menuList = menuService.selectAllMenu();

        if (menuList != null) {
            printResult.printMenuList(menuList);

        } else {
            printResult.printErrorMessage("selectList");

        }

    }

    public void selectMenuByCode(Map<String, String> parameter) {

        // 사용자가 String 타입으로 입력한 값을 서버 측에서 int로 파싱
        int code = Integer.parseInt(parameter.get("code"));

        MenuDTO menu = menuService.selectMenuByCode(code);

        if (menu != null) {
            printResult.printMenu(menu);        // printMenu라고 새로 또 만들어준 것임!

        } else {
            printResult.printErrorMessage("selectOne");
            // ▲ 쿼리문 실패시, selectOne 메세지 보낼것임!!

        }

    }

    public void registMenu(Map<String, String> parameter) {

        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        if (menuService.registMenu(menu)) {      // 보내준 메세지가 성공이면, ▼
            printResult.printSuccessMessage("insert");

        } else {
            printResult.printErrorMessage("insert");

        }

    }

    // insertMenu
    public void editMenu(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();               // NenuDTO menu 가져오기!
        menu.setCode(code);
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        if (menuService.editMenu(menu)) {             // 보내준 메세지가 성공이면, ▼
            printResult.printSuccessMessage("insert");

        } else {
            printResult.printErrorMessage("insert");

        }


    }

    public void deleteMenu(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code")); // parameter.get("") 쓰고 alt +enter 변경!

        MenuDTO menu = new MenuDTO();               // NenuDTO menu 가져오기!
        menu.setCode(code);

        if (menuService.deleteMenu(menu)) {             // 보내준 메세지가 성공이면, ▼
            printResult.printSuccessMessage("insert");

        } else {
            printResult.printErrorMessage("insert");


        }
    }
}