package com.nodir;


import com.nodir.solution.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

            /**Create Tables*/

       Solution0 solution0 = new Solution0();
       solution0.allTables();

           /**Read csv and write in Postgres*/

       SolutionA solutionA = new SolutionA();
       solutionA.solute();

            /**Read query and write in file(.xls)*/

        SolutionB solutionB = new SolutionB();
        solutionB.solute();


            /**Read query and create Chart*/

        SolutionD solutionD = new SolutionD();
        solutionD.creatCharts();

    }
}
