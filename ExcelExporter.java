/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proiect_ISI;

import java.io.*;
import java.sql.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

/**
 * A simple Java program that exports data from database to Excel file.
 *
 * @author Nam Ha Minh
 * (C) Copyright codejava.net
 */
public class ExcelExporter
{

    public static void main(String[] args)
    {
        new ExcelExporter().export();
    }

    public static HSSFWorkbook export()
    {
        HSSFWorkbook workbook = new HSSFWorkbook();
        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/magazin_incaltaminte";
        String username = "root";
        String password = "oracle";
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password))
        {
            String sql = "SELECT * FROM incaltaminte";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Incaltaminte");
            writeHeaderLine(sheet);
            writeDataLines(result, workbook, sheet);
            statement.close();
        }
        catch (SQLException e)
        {
            System.out.println("Datababse error:");
            e.printStackTrace();
        }
        return workbook;
    }

    private static void writeHeaderLine(HSSFSheet sheet)
    {
        Row headerRow = sheet.createRow(0);
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Cod produs");
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Categorie");
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Marca");
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Model");
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("Culoare");
        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("Tesatura");
        headerCell = headerRow.createCell(6);
        headerCell.setCellValue("Marime");
        headerCell = headerRow.createCell(7);
        headerCell.setCellValue("Sezon");
        headerCell = headerRow.createCell(8);
        headerCell.setCellValue("Inaltime totala");
        headerCell = headerRow.createCell(9);
        headerCell.setCellValue("Greutate");
        headerCell = headerRow.createCell(10);
        headerCell.setCellValue("Pret");
        headerCell = headerRow.createCell(11);
        headerCell.setCellValue("Cantitate");
    }

    private static void writeDataLines(ResultSet result, HSSFWorkbook workbook,
            HSSFSheet sheet)
            throws SQLException
    {
        int rowCount = 1;
        while (result.next())
        {
            int cod = result.getInt("codProdus");
            String categ = result.getString("categorie");
            String marca = result.getString("marca");
            String model = result.getString("model");
            String culoare = result.getString("culoare");
            String tesatura = result.getString("tesatura");
            int marime = result.getInt("marime");
            String sezon = result.getString("sezon");
            int inaltime = result.getInt("inaltimeTotala");
            int greutate = result.getInt("greutate");
            int pret = result.getInt("pret");
            int cantitate = result.getInt("cantitate");
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(cod);
            cell = row.createCell(columnCount++);
            cell.setCellValue(categ);
            cell = row.createCell(columnCount++);
            cell.setCellValue(marca);
            cell = row.createCell(columnCount++);
            cell.setCellValue(model);
            cell = row.createCell(columnCount++);
            cell.setCellValue(culoare);
            cell = row.createCell(columnCount++);
            cell.setCellValue(tesatura);
            cell = row.createCell(columnCount++);
            cell.setCellValue(marime);
            cell = row.createCell(columnCount++);
            cell.setCellValue(sezon);
            cell = row.createCell(columnCount++);
            cell.setCellValue(inaltime);
            cell = row.createCell(columnCount++);
            cell.setCellValue(greutate);
            cell = row.createCell(columnCount++);
            cell.setCellValue(pret);
            cell = row.createCell(columnCount++);
            cell.setCellValue(cantitate);
        }
    }
}
