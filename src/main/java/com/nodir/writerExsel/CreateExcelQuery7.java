package com.nodir.writerExsel;

import com.nodir.entityQuery.SolutionQuery1;
import com.nodir.entityQuery.SolutionQuery5;
import com.nodir.entityQuery.SolutionQuery7;
import com.nodir.query.QueryExecutor;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.List;

public class CreateExcelQuery7 {

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook hssfWorkbook) {
        HSSFFont font = hssfWorkbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = hssfWorkbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public void excelQuery7() throws IOException {

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet("List1");

        List<SolutionQuery7> list = QueryExecutor.selectQuery7();

        int rowNum = 0;
        Cell cell;
        Row row;

        HSSFCellStyle style =  createStyleForTitle(hssfWorkbook);
        row = sheet.createRow(rowNum);

        //Sum lesion
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("sum_lesion");
        cell.setCellStyle(style);

        //Count day

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("day_count");

        cell.setCellStyle(style);

        for (SolutionQuery7 solut: list){
            rowNum++;
            row = sheet.createRow(rowNum);

            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(solut.getSumLesion());

            cell = row.createCell(1, CellType.NUMERIC);
            cell.setCellValue(solut.getCountDay());

        }

        File file = new File("QueryExcel\\Query7.xls");
        file.getParentFile().mkdirs();

        FileOutputStream fileOutput = new FileOutputStream(file);
        hssfWorkbook.write(fileOutput);

        System.out.println("Create file" + file.getAbsolutePath());
    }
}