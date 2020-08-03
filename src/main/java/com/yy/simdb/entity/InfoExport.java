package com.yy.simdb.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.util.Date;

@Data
public class InfoExport extends BaseRowModel {
    @ExcelProperty
    private String contentt;
    @ExcelProperty
    private Date dueTime;
    @ExcelProperty
    private String dueTimeAlt;
    @ExcelProperty
    private String dp;
    @ExcelProperty
    private String info;
    @ExcelProperty
    private Byte finished;

}
