/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import java.sql.SQLException;
import java.util.List;
import model.Stock;
import service.DatabaseService;
/**
 *
 * @author ADMIN
 */

public class DisplayDataCommand
        implements DatabaseCommand<List<Stock>> {

    private final DatabaseService service;

    public DisplayDataCommand(DatabaseService service) {
        this.service = service;
    }

    @Override
    public List<Stock> execute() throws SQLException {
        return service.getAllStocks();
    }
}
