package com.lv.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lv
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer bid;

    private String bname;

    private String detail;

    private String price;

    private String writer;

    private String printer;

    private Date date;

    private String type;

    private String image;

    private Integer store;
    
}