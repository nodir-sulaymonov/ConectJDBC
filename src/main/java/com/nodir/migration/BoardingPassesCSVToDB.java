package com.nodir.migration;

import com.nodir.csv.BoardingPassesCSV;
import com.nodir.entity.BoardingPasses;
import com.nodir.repository.BoardingPassesRepository;

import java.util.List;

public class BoardingPassesCSVToDB {

    BoardingPassesRepository boardingPassesRepository = new BoardingPassesRepository();
    BoardingPassesCSV boardingPassesCSV = new BoardingPassesCSV();

    public  boolean migrate(){
        boolean result = true;
        List<BoardingPasses> boardingPasses = boardingPassesCSV.getBoardingPassesFromCSV();

        for (BoardingPasses boardingPasse : boardingPasses) {
            result = result && boardingPassesRepository.insert(boardingPasse);
        }

        return result;
    }
}
