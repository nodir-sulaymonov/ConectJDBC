package com.nodir.Chart;

import com.nodir.entityQuery.SolutionQuery7;
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

public class CreateChart7 {

    public void ChartPng7() throws IOException {
        CategoryDataset dataset = createDataset();

        JFreeChart barChart = ChartFactory.createBarChart(
                "Query Sum lesion, day count",
                "Flights(count)",
                "Lesion money(count)",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        ChartUtilities.saveChartAsPNG(new File("ChartQuery\\Query7.png"), barChart, 1500, 600);
    }
    private static CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<SolutionQuery7> list = QueryExecutor.selectQuery7();

        for (SolutionQuery7 solut: list) {
            dataset.addValue(solut.getCountDay(), "",solut.getSumLesion()+"");
        }

        return dataset;
    }
}