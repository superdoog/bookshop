package com.lv.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lv
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    private Integer id;

    private Integer orderId;

    private Integer bookId;

    private Integer bookNum;

    private String status;

    private List<Book> books;
}