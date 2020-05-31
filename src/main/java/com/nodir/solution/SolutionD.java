package com.nodir.solution;

import com.nodir.Chart.*;

import java.io.IOException;

/**
 * Считываем данные от запроса и создаём диграмму;
 */
public class SolutionD {
        public void creatCharts() throws IOException {
            CreateChart1 createChart1 = new CreateChart1();
            createChart1.ChartPng1();

            CreateChart2 createChart2 =  new CreateChart2();
            createChart2.ChartPng2();

            CreateChart3 createChart3 = new CreateChart3();
            createChart3.ChartPng3();

            CreateChart4 createChart4 = new CreateChart4();
            createChart4.ChartPng4();

            CreateChartIn5 createChartIn5 = new CreateChartIn5();
            createChartIn5.ChartPngIn5();

            CreateChartOut5 createChartOut5 = new CreateChartOut5();
            createChartOut5.ChartPngOut5();

            CreateChart7 createChart7 = new CreateChart7();
            createChart7.ChartPng7();
        }
}
