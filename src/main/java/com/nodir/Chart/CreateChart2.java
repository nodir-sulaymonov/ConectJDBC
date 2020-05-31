package com.nodir.Chart;

import com.nodir.entityQuery.SolutionQuery2;
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

public class CreateChart2 {


    public void ChartPng2() throws IOException {
        CategoryDataset dataset = createDataset();


        JFreeChart barChart = ChartFactory.createBarChart(
                "Query City, Counts",
                "City",
                "Count",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        ChartUtilities.saveChartAsPNG(new File("ChartQuery\\Query2.png"), barChart, 2000, 600);
    }
    private static CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<SolutionQuery2> list = QueryExecutor.selectQuery2();

        for (SolutionQuery2 solut: list) {
            dataset.addValue(solut.getCount(), "City", solut.getCity());
        }

        return dataset;
    }
}