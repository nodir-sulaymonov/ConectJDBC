package com.nodir.solution;


import com.nodir.writerExsel.*;

import java.io.IOException;

/**
 * Записываем все запросы в таблицу Excel;
 */
public class SolutionB {

    public void solute() throws IOException {

        CreateExcelQuery1 createExcelQuery1 = new CreateExcelQuery1();
        createExcelQuery1.excelQuery1();

        CreateExcelQuery2 createExcelQuery2 = new CreateExcelQuery2();
        createExcelQuery2.excelQuery2();

        CreateExcelQuery3 createExcelQuery3 = new CreateExcelQuery3();
        createExcelQuery3.excelQuery3();

        CreateExcelQuery4 createExcelQuery4 = new CreateExcelQuery4();
        createExcelQuery4.excelQuery4();

        CreateExcelQueryIn5 createExcelQueryIn5 = new CreateExcelQueryIn5();
        createExcelQueryIn5.excelQueryIn5();

        CreateExcelQueryOut5 createExcelQueryOut5 =  new CreateExcelQueryOut5();
        createExcelQueryOut5.excelQueryOut5();

        CreateExcelQuery7 createExcelQuery7 = new CreateExcelQuery7();
        createExcelQuery7.excelQuery7();
//        System.out.println("Запрос 1");
//
//
//        List<SolutionQuery1> list = QueryExecutor.query1();
//       list.forEach(a -> System.out.println(a.getCity() + a.getListAirports()));
//
//        System.out.println("Запрос 2");
//        queryExecutor.selectQuery2();
//
//        System.out.println("Запрос 3");
//        queryExecutor.selectQuery3();
//
//        System.out.println("Запрос 4");
//        queryExecutor.selectQuery4();

//        List<SolutionQuery4> list = QueryExecutor.selectQuery4();
//        System.out.println("month" + " || " + "count");
//        list.forEach(a -> System.out.println(a.getCountMonth() + " || " + a.getCountCanceled()));

    }

}
