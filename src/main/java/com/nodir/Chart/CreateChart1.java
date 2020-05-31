package com.nodir.Chart;

import com.nodir.entityQuery.SolutionQuery1;
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

public class CreateChart1 {




    public void ChartPng1() throws IOException {
        CategoryDataset dataset = createDataset();


        JFreeChart barChart = ChartFactory.createBarChart(
                "Query City, Airports",
                "City",
                "Airports",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        ChartUtilities.saveChartAsPNG(new File("ChartQuery\\Query1.png"), barChart, 1500, 600);
    }
    private static CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<SolutionQuery1> list = QueryExecutor.query1();

        for (SolutionQuery1 solut: list) {
            dataset.addValue(15, solut.getCity(), solut.getListAirports());
        }



        return dataset;
    }
}