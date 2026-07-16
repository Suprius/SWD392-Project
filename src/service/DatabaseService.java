/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import model.Stock;
import repository.DatabaseRepository;
/**
 *
 * @author ADMIN
 */
public class DatabaseService {
    private final DatabaseRepository repository;

    public DatabaseService(DatabaseRepository repository) {
        this.repository = repository;
    }

    public void createDatabase() throws SQLException {
        repository.createDatabase();
    }

    public void createTable() throws SQLException {
        repository.createTable();
    }

    public void insertFiveStocks() throws SQLException {
        repository.insertAll(createDefaultStocks());
    }

    public List<Stock> getAllStocks() throws SQLException {
        return repository.findAll();
    }

    private List<Stock> createDefaultStocks() {
        return Arrays.asList(
                new Stock(
                        1,
                        "Stock one",
                        "No1 - Washington street",
                        LocalDate.of(2010, 5, 11),
                        ""
                ),
                new Stock(
                        2,
                        "Stock two",
                        "372 Cave town - 001 Banks",
                        LocalDate.of(2011, 7, 9),
                        ""
                ),
                new Stock(
                        3,
                        "Stock three",
                        "Nary angel - 890 Number one",
                        LocalDate.of(2010, 5, 13),
                        ""
                ),
                new Stock(
                        4,
                        "Stock four",
                        "Twin tower - 01 Main street",
                        LocalDate.of(2015, 7, 4),
                        ""
                ),
                new Stock(
                        5,
                        "Stock five",
                        "Victory anniversary district",
                        LocalDate.of(2014, 12, 8),
                        ""
                )
        );
    }
}
