/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Stock;

/**
 *
 * @author ADMIN
 */
public class SqlServerDatabaseRepository
        implements DatabaseRepository {

    private static final String CREATE_DATABASE_SQL =
            "IF DB_ID(N'FU_DB') IS NULL "
            + "CREATE DATABASE [FU_DB]";

    private static final String CREATE_TABLE_SQL =
            "IF OBJECT_ID(N'dbo.Stocks', N'U') IS NULL "
            + "BEGIN "
            + "CREATE TABLE dbo.Stocks ("
            + "StockID INT NOT NULL PRIMARY KEY, "
            + "StockName NVARCHAR(100) NOT NULL, "
            + "Address NVARCHAR(255) NOT NULL, "
            + "DateAvailable DATE NOT NULL, "
            + "Note NVARCHAR(255) NULL"
            + ") "
            + "END";

    private static final String INSERT_SQL =
            "IF NOT EXISTS ("
            + "SELECT 1 FROM dbo.Stocks WHERE StockID = ?"
            + ") "
            + "INSERT INTO dbo.Stocks "
            + "(StockID, StockName, Address, DateAvailable, Note) "
            + "VALUES (?, ?, ?, ?, ?)";

    private static final String SELECT_SQL =
            "SELECT StockID, StockName, Address, "
            + "DateAvailable, Note "
            + "FROM dbo.Stocks "
            + "ORDER BY StockID";

    @Override
    public void createDatabase() throws SQLException {
        try (Connection connection =
                     DBConnection.getMasterConnection();
             Statement statement =
                     connection.createStatement()) {

            statement.executeUpdate(CREATE_DATABASE_SQL);
        }
    }

    @Override
    public void createTable() throws SQLException {
        try (Connection connection =
                     DBConnection.getFUDBConnection();
             Statement statement =
                     connection.createStatement()) {

            statement.executeUpdate(CREATE_TABLE_SQL);
        }
    }

    @Override
    public void insertAll(List<Stock> stocks)
            throws SQLException {

        try (Connection connection =
                     DBConnection.getFUDBConnection();
             PreparedStatement statement =
                     connection.prepareStatement(INSERT_SQL)) {

            connection.setAutoCommit(false);

            try {
                for (Stock stock : stocks) {
                    statement.setInt(1, stock.getStockID());
                    statement.setInt(2, stock.getStockID());
                    statement.setString(3, stock.getStockName());
                    statement.setString(4, stock.getAddress());

                    statement.setDate(
                            5,
                            Date.valueOf(stock.getDateAvailable())
                    );

                    statement.setString(6, stock.getNote());
                    statement.addBatch();
                }

                statement.executeBatch();
                connection.commit();

            } catch (SQLException exception) {
                connection.rollback();
                throw exception;

            } finally {
                connection.setAutoCommit(true);
            }
        }
    }

    @Override
    public List<Stock> findAll() throws SQLException {
        List<Stock> stocks = new ArrayList<>();

        try (Connection connection =
                     DBConnection.getFUDBConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SELECT_SQL);
             ResultSet resultSet =
                     statement.executeQuery()) {

            while (resultSet.next()) {
                Stock stock = new Stock(
                        resultSet.getInt("StockID"),
                        resultSet.getString("StockName"),
                        resultSet.getString("Address"),
                        resultSet
                                .getDate("DateAvailable")
                                .toLocalDate(),
                        resultSet.getString("Note")
                );

                stocks.add(stock);
            }
        }

        return stocks;
    }
}
