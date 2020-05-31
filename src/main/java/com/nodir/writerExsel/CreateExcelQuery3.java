package com.nodir.writerExsel;

import com.nodir.entityQuery.SolutionQuery3;
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

public class CreateExcelQuery3 {

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook hssfWorkbook) {
        HSSFFont font = hssfWorkbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = hssfWorkbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public void excelQuery3() throws IOException {

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet("List1");

        List<SolutionQuery3> list = QueryExecutor.selectQuery3();

        int rowNum = 0;
        Cell cell;
        Row row;

        HSSFCellStyle style =  createStyleForTitle(hssfWorkbook);
        row = sheet.createRow(rowNum);

        //City
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("city");
        cell.setCellStyle(style);

        //Arrival Point
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("arrival_point");
        cell.setCellStyle(style);

        //Duration
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("duration");
        cell.setCellStyle(style);

        for (SolutionQuery3 solut: list){
            rowNum++;
            row = sheet.createRow(rowNum);

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(solut.getCity());

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(solut.getArrivalPoint());

            cell = row.createCell(2, CellType.NUMERIC);
            cell.setCellValue(solut.getDuration());
        }

        File file = new File("QueryExcel\\Query3.xls");
        file.getParentFile().mkdirs();

        FileOutputStream fileOutput = new FileOutputStream(file);
        hssfWorkbook.write(fileOutput);

        System.out.println("Create file" + file.getAbsolutePath());
    }
}
