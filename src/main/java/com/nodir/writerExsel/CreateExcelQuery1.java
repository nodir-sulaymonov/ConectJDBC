package com.nodir.writerExsel;

import com.nodir.entityQuery.SolutionQuery1;
import com.nodir.query.QueryExecutor;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jfree.data.*;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.jfree.data.category.DefaultCategoryDataset;


import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.List;

public class CreateExcelQuery1 {

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook hssfWorkbook) {
        HSSFFont font = hssfWorkbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = hssfWorkbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public void excelQuery1() throws IOException {

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet("List1");

        List<SolutionQuery1> list = QueryExecutor.query1();

        int rownum = 0;
        Cell cell;
        Row row;

        HSSFCellStyle style =  createStyleForTitle(hssfWorkbook);
        row = sheet.createRow(rownum);

        //City
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("city");
        cell.setCellStyle(style);
        //ListAirports
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("airports_list");
        cell.setCellStyle(style);

        for (SolutionQuery1 solut: list){
            rownum++;
            row = sheet.createRow(rownum);

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(solut.getCity());

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(solut.getListAirports());
        }

        File file = new File("QueryExcel\\Query1.xls");
        file.getParentFile().mkdirs();

        FileOutputStream fileOutput = new FileOutputStream(file);
        hssfWorkbook.write(fileOutput);

        System.out.println("Create file" + file.getAbsolutePath());
    }
}
