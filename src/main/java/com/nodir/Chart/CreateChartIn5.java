package com.nodir.Chart;

import com.nodir.entityQuery.SolutionQuery5;
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

public class CreateChartIn5 {


    public void ChartPngIn5() throws IOException {
        CategoryDataset dataset = createDataset();


        JFreeChart barChart = ChartFactory.createBarChart(
                "Query Count day, flight in Moskow",
                "Days(count)",
                "Flights(count)",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        ChartUtilities.saveChartAsPNG(new File("ChartQuery\\QueryIn5.png"), barChart, 1500, 600);
    }
    private static CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<SolutionQuery5> list = QueryExecutor.selectQueryIn5();

        for (SolutionQuery5 solut: list) {
            dataset.addValue(solut.getCountFlights(), "", solut.getCountDay() +"");
        }

        return dataset;
    }
}