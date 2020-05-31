package com.nodir.Chart;

import com.nodir.entityQuery.SolutionQuery3;
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

public class CreateChart3 {


    public void ChartPng3() throws IOException {
        CategoryDataset dataset = createDataset();


        JFreeChart barChart = ChartFactory.createBarChart(
                "Query Duration, Airports",
                "Airports",
                "Duration",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        ChartUtilities.saveChartAsPNG(new File("ChartQuery\\Query3.png"), barChart, 1500, 600);
    }
    private static CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<SolutionQuery3> list = QueryExecutor.selectQuery3();

        for (SolutionQuery3 solut: list) {
            dataset.addValue(solut.getDuration(), "City", solut.getArrivalPoint());
        }

        return dataset;
    }
}