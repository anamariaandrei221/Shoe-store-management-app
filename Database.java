package Proiect_ISI;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ana
 */
public class Database
{

    String dbURL = "jdbc:mysql://127.0.0.1:3306/magazin_incaltaminte";
    String dbusername = "root";    //username de logare la baza de date
    String dbpassword = "oracle";    //parola de logare la baza de date

    public boolean loginCheck(String loginUsername, String loginPassword)
    {
        boolean check = false;
        try (Connection conn = DriverManager.getConnection(dbURL, dbusername, dbpassword))
        {
            String sql = "SELECT username,password FROM angajat where username=? and password=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, loginUsername);
            statement.setString(2, loginPassword);
            ResultSet result = statement.executeQuery();
            if (result.next())
            {
                check = true;
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return check;
    }

    public int getNivel(String loginUsername)
    {
        int nivel = 0;
        try (Connection conn = DriverManager.getConnection(dbURL, dbusername, dbpassword))
        {
            String sql = "SELECT nivelAccess FROM angajat where username=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, loginUsername);
            ResultSet result = statement.executeQuery();
            result.next();
            nivel = result.getInt(1);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return nivel;
    }

    public void adaugaAngajat(String nume, String username, String password)
    {
        try (Connection conn = DriverManager.getConnection(dbURL, dbusername, dbpassword))
        {
            String sql = "INSERT INTO angajat (nume, nivelAccess, password, username) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nume);
            statement.setInt(2, 1);
            statement.setString(3, password);
            statement.setString(4, username);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
            {
                System.out.println("Un nou angajat a fost adaugat!");
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    public ArrayList<String> coloane;

    public ArrayList<ArrayList<Object>> afisareIncaltaminte()
    {
        try (Connection conn = DriverManager.getConnection(dbURL, dbusername, dbpassword))
        {
            ArrayList<ArrayList<Object>> incaltaminte = new ArrayList<>();
            String sql = "SELECT * FROM incaltaminte";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
//            return DbUtils.resultSetToTableModel(result);
            int nrCol = result.getMetaData().getColumnCount();
            coloane = new ArrayList<>();
            for (int i = 0; i < nrCol; i++)
            {
                coloane.add(result.getMetaData().getColumnLabel(i + 1));
            }
            while (result.next())
            {
                ArrayList<Object> rand = new ArrayList<>();
                for (int i = 1; i <= nrCol; i++)
                {
                    rand.add(result.getObject(i));
                }
                incaltaminte.add(rand);
            }
            return incaltaminte;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    public ArrayList<String> coloane1;

    public ArrayList<ArrayList<Object>> afisareIstoric()
    {
        try (Connection conn = DriverManager.getConnection(dbURL, dbusername, dbpassword))
        {
            ArrayList<ArrayList<Object>> incaltaminte = new ArrayList<>();
            String sql = "SELECT * FROM istoric";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
//            return DbUtils.resultSetToTableModel(result);
            int nrCol = result.getMetaData().getColumnCount();
            coloane1 = new ArrayList<>();
            for (int i = 0; i < nrCol; i++)
            {
                coloane1.add(result.getMetaData().getColumnLabel(i + 1));
            }
            while (result.next())
            {
                ArrayList<Object> rand = new ArrayList<>();
                for (int i = 1; i <= nrCol; i++)
                {
                    rand.add(result.getObject(i));
                }
                incaltaminte.add(rand);
            }
            return incaltaminte;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<ArrayList<Object>> ordonareaC()
    {
        try (Connection conn = DriverManager.getConnection(dbURL, dbusername, dbpassword))
        {
            ArrayList<ArrayList<Object>> incaltaminte = new ArrayList<>();
            String sql = "SELECT * FROM incaltaminte ORDER BY pret ASC";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
//            return DbUtils.resultSetToTableModel(result);
            int nrCol = result.getMetaData().getColumnCount();
            coloane = new ArrayList<>();
            for (int i = 0; i < nrCol; i++)
            {
                coloane.add(result.getMetaData().getColumnLabel(i + 1));
            }
            while (result.next())
            {
                ArrayList<Object> rand = new ArrayList<>();
                for (int i = 1; i <= nrCol; i++)
                {
                    rand.add(result.getObject(i));
                }
                incaltaminte.add(rand);
            }
            return incaltaminte;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public void istoricul(String user, String comanda)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        try (Connection conn = DriverManager.getConnection(dbURL, dbusername, dbpassword))
        {
            String sql = "INSERT INTO istoric VALUES (null,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user);
            statement.setString(2, dtf.format(now));
            statement.setString(3, comanda);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
            {
                System.out.println("O noua pereche de incaltaminte a fost adaugata!");
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public String grafic()
    {
        try (Connection conn = DriverManager.getConnection(dbURL, dbusername, dbpassword))
        {
            String sql = "select SUM(cantitate),categorie as numar from incaltaminte where categorie in (Select categorie from incaltaminte) GROUP BY categorie";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            String jasondata = "";
            while (result.next())
            {
                jasondata = jasondata + "{\"y\":" + result.getInt(1) + ", \"label\":\"" + result.getString(2) + "\"}" + ",";
            }
            return "[" + jasondata + "]";
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<ArrayList<Object>> ordonareaD()
    {
        try (Connection conn = DriverManager.getConnection(dbURL, dbusername, dbpassword))
        {
            ArrayList<ArrayList<Object>> incaltaminte = new ArrayList<>();
            String sql = "SELECT * FROM incaltaminte ORDER BY pret DESC";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
//            return DbUtils.resultSetToTableModel(result);
            int nrCol = result.getMetaData().getColumnCount();
            coloane = new ArrayList<>();
            for (int i = 0; i < nrCol; i++)
            {
                coloane.add(result.getMetaData().getColumnLabel(i + 1));
            }
            while (result.next())
            {
                ArrayList<Object> rand = new ArrayList<>();
                for (int i = 1; i <= nrCol; i++)
                {
                    rand.add(result.getObject(i));
                }
                incaltaminte.add(rand);
            }
            return incaltaminte;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<ArrayList<Object>> afisareFiltrare(int pretul1, String marcaI)
    {
        marcaI = "%" + marcaI + "%";
        try (Connection conn = DriverManager.getConnection(dbURL, dbusername, dbpassword))
        {
            ArrayList<ArrayList<Object>> incaltaminte = new ArrayList<>();
            String sql = "SELECT * FROM incaltaminte WHERE pret>=? AND marca LIKE ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, pretul1);
            statement.setString(2, marcaI);
            ResultSet result = statement.executeQuery();
            int nrCol = result.getMetaData().getColumnCount();
            coloane = new ArrayList<>();
            for (int i = 0; i < nrCol; i++)
            {
                coloane.add(result.getMetaData().getColumnLabel(i + 1));
            }
            while (result.next())
            {
                ArrayList<Object> rand = new ArrayList<>();
                for (int i = 1; i <= nrCol; i++)
                {
                    rand.add(result.getObject(i));
                }
                incaltaminte.add(rand);
            }
            return incaltaminte;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<ArrayList<Object>> cautare(String categoria)
    {
        try (Connection conn = DriverManager.getConnection(dbURL, dbusername, dbpassword))
        {
            ArrayList<ArrayList<Object>> incaltaminte = new ArrayList<>();
            String sql = "SELECT * FROM incaltaminte WHERE categorie=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, categoria);
            ResultSet result = statement.executeQuery();
            int nrCol = result.getMetaData().getColumnCount();
            coloane = new ArrayList<>();
            for (int i = 0; i < nrCol; i++)
            {
                coloane.add(result.getMetaData().getColumnLabel(i + 1));
            }
            while (result.next())
            {
                ArrayList<Object> rand = new ArrayList<>();
                for (int i = 1; i <= nrCol; i++)
                {
                    rand.add(result.getObject(i));
                }
                incaltaminte.add(rand);
            }
            return incaltaminte;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public HashMap<String, Object> afisarePereche(String codProd)
    {
        try (Connection conn = DriverManager.getConnection(dbURL, dbusername, dbpassword))
        {
            HashMap<String, Object> incaltaminte = new HashMap<>();
            String sql = "SELECT * FROM incaltaminte WHERE codProdus=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(codProd));
            ResultSet result = statement.executeQuery();
            result.next();
            int nrCol = result.getMetaData().getColumnCount();
            for (int i = 0; i < nrCol; i++)
            {
                final String columnLabel = result.getMetaData().getColumnLabel(i + 1);
                incaltaminte.put(columnLabel, result.getObject(columnLabel));
            }
            return incaltaminte;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public void adaugaIncaltaminte(String categorie, String marca, String model, String culoare, String tesatura, int marime, String sezon, int inaltimeTotala, int greutate, int pret, int cantitate)
    {
        try (Connection conn = DriverManager.getConnection(dbURL, dbusername, dbpassword))
        {
            // String sql = "INSERT INTO incaltaminte(categorie, marca, model, culoare, tesatura, marime, sezon, inaltimeTotala, greutate, pret, cantitate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            String sql = "INSERT INTO incaltaminte VALUES (null,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, categorie);
            statement.setString(2, marca);
            statement.setString(3, model);
            statement.setString(4, culoare);
            statement.setString(5, tesatura);
            statement.setInt(6, marime);
            statement.setString(7, sezon);
            statement.setInt(8, inaltimeTotala);
            statement.setInt(9, greutate);
            statement.setInt(10, pret);
            statement.setInt(11, cantitate);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
            {
                System.out.println("O noua pereche de incaltaminte a fost adaugata!");
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public void modificaIncaltaminte(int codProdus, String categorie, String marca, String model, String culoare, String tesatura, int marime, String sezon, int inaltimeTotala, int greutate, int pret, int cantitate)
    {
        try (Connection conn = DriverManager.getConnection(dbURL, dbusername, dbpassword))
        {
            String sql = "UPDATE incaltaminte SET categorie=?, marca=?, model=?, culoare=?, tesatura=?, marime=?, sezon=?, inaltimeTotala=?, greutate=?, pret=?, cantitate=? WHERE codProdus=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(12, codProdus);
            statement.setString(1, categorie);
            statement.setString(2, marca);
            statement.setString(3, model);
            statement.setString(4, culoare);
            statement.setString(5, tesatura);
            statement.setInt(6, marime);
            statement.setString(7, sezon);
            statement.setInt(8, inaltimeTotala);
            statement.setInt(9, greutate);
            statement.setInt(10, pret);
            statement.setInt(11, cantitate);
            statement.executeUpdate();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public void eliminaIncaltaminte(int codp)
    {
        try (Connection conn = DriverManager.getConnection(dbURL, dbusername, dbpassword))
        {
            String sql = "DELETE FROM incaltaminte WHERE codProdus=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, codp);
            statement.executeUpdate();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
