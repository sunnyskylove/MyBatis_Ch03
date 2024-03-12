package com.ohgiraffers.section01.xmlconfig;

import lombok.*;

//@NoArgsConstructor   //기본생성자
//@AllArgsConstructor  //모든생성자
//@Getter
//@Setter
//@ToString
// # 하지만, 매핑이 모두 다 안되게 오류가 나서, 이것도 수기로 모두 다시 작성함!

//@Data      //상위의 있는 모든것을 한번에  @Data로 다 포함해서 쓸 수 있지만, 혹시모를 에러발생때문에 이건 잘 안쓰인다.
//▲▲ @Data - 위에 다섯가지 요소를 한 번에 포함하는 어노테이션(@)


public class MenuDTO {

    private int code;
    private String name;
    private int price;
    private int categoryCode;
    private String orderableStatus;

    public MenuDTO() {}

    public MenuDTO(int code, String name, int price, int categoryCode, String orderableStatus) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}