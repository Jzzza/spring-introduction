package com.roadrantz.mvc;


import com.roadrantz.dao.Rant;
import com.roadrantz.dao.Vehicle;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class RantExcelView extends AbstractExcelView{
    protected void buildExcelDocument(Map model,
                                      HSSFWorkbook workbook,
                                      HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        Collection rants = (Collection) model.get("rants");
        Vehicle vehicle = (Vehicle) model.get("vehicle");

        HSSFSheet sheet = createSheet(workbook, vehicle.getPlateNumber());

        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));    // Установка формата даты

        int rowNum = 1;
        for (Iterator iter = rants.iterator(); iter.hasNext(); ) {  // Добавление
            Rant rant = (Rant) iter.next();                         // сообщений
            rowNum = addRantRow(sheet, cellStyle, rowNum, rant);    // в таблицу
        }
    }

        private int addRantRow(HSSFSheet sheet, HSSFCellStyle cellStyle, int rowNum, Rant rant) {
            HSSFRow row = sheet.createRow(rowNum++);
            row.createCell((short)0).setCellValue(rant.getPostedDate());
            row.createCell((short)0).setCellValue(rant.getRantText());
            row.getCell((short)1).setCellStyle(cellStyle);
            return rowNum;
        }

        private HSSFSheet createSheet(HSSFWorkbook workbook, Object plateNumber) {
            HSSFSheet sheet = workbook.createSheet("Rants for " + plateNumber);

            HSSFRow header = sheet.createRow(0);        // Добавление строки
            header.createCell((short)0).setCellValue("Date");
            header.createCell((short)1).setCellValue("Text");
            return sheet;
        }
}
