package com.yjr.config;

import cn.afterturn.easypoi.excel.export.styler.ExcelExportStylerDefaultImpl;
import org.apache.poi.ss.usermodel.*;
import org.springframework.context.annotation.Bean;

/**
 * @author yangjiuran
 * @Date 2020/5/18
 */

public class MyIExcelExportStyler extends ExcelExportStylerDefaultImpl {
    public MyIExcelExportStyler(Workbook workbook) {
        super(workbook);
    }

    public CellStyle getTitleStyle(short color) {
        CellStyle titleStyle = this.workbook.createCellStyle();
        titleStyle.setAlignment(HorizontalAlignment.RIGHT);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        Font font = workbook.createFont();
        font.setColor(Font.COLOR_RED);
        titleStyle.setFont(font);
        titleStyle.setWrapText(true);
        return titleStyle;
    }

    public CellStyle getHeaderStyle(short color) {
        CellStyle titleStyle = this.workbook.createCellStyle();
        Font font = this.workbook.createFont();
        font.setFontHeightInPoints((short)15);
        titleStyle.setFont(font);
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return titleStyle;
    }
}
