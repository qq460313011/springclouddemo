package com.fw.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName
 * @Description TODO
 * @Author li
 * @Date 2020/1/27 12:57
 **/
@Data
@NoArgsConstructor
@Accessors(chain = true)//链式写法
public class Dept implements Serializable {

    private Long deptno;

    public Dept(String dname) {
        this.dname = dname;
    }

    private String dname;
    private String db_source;



}
