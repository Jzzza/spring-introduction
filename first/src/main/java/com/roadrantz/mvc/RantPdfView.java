package com.roadrantz.mvc;

import com.lowagie.text.Table;
import com.roadrantz.dao.Rant;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

public class RantPdfView extends AbstractPdfView {
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document,
                                    PdfWriter pdfWriter,
                                    HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse) throws Exception {
        List rants = (List) model.get("rants");
        Table rantTable = new Table(4); // Создание таблицы
        rantTable.setWidth(90);;
        rantTable.setBorderWidth(1);

        rantTable.addCell("State");
        rantTable.addCell("Plate");
        rantTable.addCell("Date Posted");
        rantTable.addCell("Text");

        for (Iterator iter = rants.iterator(); iter.hasNext();) {
            Rant rant = (Rant) iter.next();

            rantTable.addCell(rant.getVehicle().getState());
            rantTable.addCell((String) rant.getVehicle().getPlateNumber());
            rantTable.addCell(rant.getPostedDate().toString());
            rantTable.addCell(rant.getRantText());
        }
        document.add(rantTable);
    }
}
