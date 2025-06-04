package com.Main.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository
public class RepositoryDataBase1 {

    private final DataSource dataSource;

    //=== INYECTING THE BEAN DATABASE CONFIGURATION
    @Autowired
    public RepositoryDataBase1(
            @Qualifier("BeanDB1")DataSource dataSource){
        this.dataSource = dataSource;
    }
    //=====================================

    public void testConnection(){
        try
                (Connection conn = dataSource.getConnection();
                 Statement stmt= conn.createStatement()){

            ResultSet rs = stmt.executeQuery("SELECT NOW()");
            if(rs.next()){
                System.out.println("DB Time:" + rs.getString(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
