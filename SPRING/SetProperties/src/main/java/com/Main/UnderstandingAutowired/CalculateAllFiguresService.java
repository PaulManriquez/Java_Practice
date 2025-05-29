package com.Main.UnderstandingAutowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculateAllFiguresService {

    // All classes that implement the Figure interface are now Spring beans (@Component).
    // Because they are managed by the Spring container, there's no need to manually
    // add them to a list. Spring automatically injects all beans implementing the Figure
    // interface into this list using dependency injection.
    @Autowired
    private List<Figure> implementFigureList;
    //=======================================================================
    public void runFiguresCalculation(){
        for(Figure ptrF:implementFigureList){
            System.out.println(
                    ptrF.getName() + " Area:" +
                    ptrF.calculateArea());
        }
    }
}
