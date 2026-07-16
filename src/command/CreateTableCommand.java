/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import java.sql.SQLException;
import service.DatabaseService;
/**
 *
 * @author ADMIN
 */
public class CreateTableCommand
        implements DatabaseCommand<Void> {

    private final DatabaseService service;

    public CreateTableCommand(DatabaseService service) {
        this.service = service;
    }

    @Override
    public Void execute() throws SQLException {
        service.createTable();
        return null;
    }
}
