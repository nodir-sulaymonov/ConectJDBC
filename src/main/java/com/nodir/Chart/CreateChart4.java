package com.nodir.Chart;

import com.nodir.entityQuery.SolutionQuery4;
import com.nodir.query.QueryExecutor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


import java.io.File;
import java.io.IOException;

import java.util.List;

public class CreateChart4 {


    public void ChartPng4() throws IOException  {
        CategoryDataset dataset = createDataset();


        JFreeChart barChart = ChartFactory.createBarChart(
                "Query Count month, Arrival point canceled",
                "Arrival point (cancel)",
                "Month(count)",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        ChartUtilities.saveChartAsPNG(new File("ChartQuery\\Query4.png"), barChart, 1500, 600);
    }
    private static CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<SolutionQuery4> list = QueryExecutor.selectQuery4();

        for (SolutionQuery4 solut: list) {
            dataset.addValue(solut.getCountMonth(), "", solut.getCountCanceled()+"");
        }

        return dataset;
    }
}