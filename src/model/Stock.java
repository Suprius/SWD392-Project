/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
/**
 *
 * @author ADMIN
 */
public class Stock {
     private final int stockID;
    private final String stockName;
    private final String address;
    private final LocalDate dateAvailable;
    private final String note;

    public Stock(
            int stockID,
            String stockName,
            String address,
            LocalDate dateAvailable,
            String note) {

        this.stockID = stockID;
        this.stockName = stockName;
        this.address = address;
        this.dateAvailable = dateAvailable;
        this.note = note;
    }

    public int getStockID() {
        return stockID;
    }

    public String getStockName() {
        return stockName;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDateAvailable() {
        return dateAvailable;
    }

    public String getNote() {
        return note;
    }
}
