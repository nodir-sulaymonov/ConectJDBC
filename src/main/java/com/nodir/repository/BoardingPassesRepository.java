package com.nodir.repository;

import com.nodir.dao.BoardingPassesDAO;
import com.nodir.entity.BoardingPasses;

public class BoardingPassesRepository {
    BoardingPassesDAO boardingPassesDAO = new BoardingPassesDAO();

    public boolean insert(BoardingPasses boardingPasses){
        return boardingPassesDAO.insert(boardingPasses);
    }
}
