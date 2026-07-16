/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import command.DatabaseCommand;
import java.sql.SQLException;
import java.util.List;
import model.Stock;
/**
 *
 * @author ADMIN
 */
public class DatabaseController {

    private final DatabaseCommand<Void> createDatabaseCommand;
    private final DatabaseCommand<Void> createTableCommand;
    private final DatabaseCommand<Void> insertDataCommand;
    private final DatabaseCommand<List<Stock>> displayDataCommand;

    public DatabaseController(
            DatabaseCommand<Void> createDatabaseCommand,
            DatabaseCommand<Void> createTableCommand,
            DatabaseCommand<Void> insertDataCommand,
            DatabaseCommand<List<Stock>> displayDataCommand) {

        this.createDatabaseCommand = createDatabaseCommand;
        this.createTableCommand = createTableCommand;
        this.insertDataCommand = insertDataCommand;
        this.displayDataCommand = displayDataCommand;
    }

    public void createDatabase() throws SQLException {
        createDatabaseCommand.execute();
    }

    public void createTable() throws SQLException {
        createTableCommand.execute();
    }

    public void insertData() throws SQLException {
        insertDataCommand.execute();
    }

    public List<Stock> displayData() throws SQLException {
        return displayDataCommand.execute();
    }
}
