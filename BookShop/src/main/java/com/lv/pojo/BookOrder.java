package com.lv.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lv
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookOrder {
    private Integer oid;

    private String date;

    private String oname;

    private String adress;

    private String status;

    private Integer uid;

    private List<OrderDetail> orderDetails;

}