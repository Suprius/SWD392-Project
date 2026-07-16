/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.SQLException;
import java.util.List;
import model.Stock;
/**
 *
 * @author ADMIN
 */
public interface DatabaseRepository {

    void createDatabase() throws SQLException;

    void createTable() throws SQLException;

    void insertAll(List<Stock> stocks) throws SQLException;

    List<Stock> findAll() throws SQLException;
}