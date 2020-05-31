package com.nodir.writerExsel;

import com.nodir.entityQuery.SolutionQuery2;
import com.nodir.query.QueryExecutor;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class CreateExcelQuery2 {

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook hssfWorkbook) {
        HSSFFont font = hssfWorkbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = hssfWorkbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public void excelQuery2() throws IOException {

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet("List2");

        List<SolutionQuery2> list = QueryExecutor.selectQuery2();

        int rowNum = 0;
        Cell cell;
        Row row;

        HSSFCellStyle style =  createStyleForTitle(hssfWorkbook);
        row = sheet.createRow(rowNum);

        //City
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("city");
        cell.setCellStyle(style);
        //Count canceled flights
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("count");
        cell.setCellStyle(style);

        for (SolutionQuery2 solut: list){
            rowNum++;
            row = sheet.createRow(rowNum);

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(solut.getCity());

            cell = row.createCell(1, CellType.NUMERIC);
            cell.setCellValue(solut.getCount());
        }

        File file = new File("QueryExcel\\Query2.xls");
        file.getParentFile().mkdirs();

        FileOutputStream fileOutput = new FileOutputStream(file);
        hssfWorkbook.write(fileOutput);

        System.out.println("Create file" + file.getAbsolutePath());
    }
}
