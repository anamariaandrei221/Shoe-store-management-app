
import  java.io.*;  
import  java.sql.*;
import  org.apache.poi.hssf.usermodel.HSSFSheet;  
import  org.apache.poi.hssf.usermodel.HSSFWorkbook; 
import  org.apache.poi.hssf.usermodel.HSSFRow;
import  org.apache.poi.hssf.usermodel.HSSFCell;  

public class CreateExcelFile{
    public static void main(String[]args){
try{
String filename="c:/data.xls" ;
HSSFWorkbook hwb=new HSSFWorkbook();
HSSFSheet sheet =  hwb.createSheet("new sheet");

HSSFRow rowhead=   sheet.createRow((short)0);
rowhead.createCell((short) 0).setCellValue("codProdus");
rowhead.createCell((short) 1).setCellValue("categorie");
rowhead.createCell((short) 2).setCellValue("marca");
rowhead.createCell((short) 3).setCellValue("model");
rowhead.createCell((short) 4).setCellValue("culoare");
rowhead.createCell((short) 5).setCellValue("tesatura");
rowhead.createCell((short) 6).setCellValue("marime");
rowhead.createCell((short) 7).setCellValue("sezon");
rowhead.createCell((short) 8).setCellValue("inaltime totala");
rowhead.createCell((short) 9).setCellValue("greutate");
rowhead.createCell((short) 10).setCellValue("pret");
rowhead.createCell((short) 11).setCellValue("cantitate");

Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/magazin_incaltaminte", "root", "oracle");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("Select * from incaltaminte");
int i=1;
while(rs.next()){
HSSFRow row=   sheet.createRow((short)i);
row.createCell((short) 0).setCellValue(Integer.toString(rs.getInt("codProdus")));
row.createCell((short) 1).setCellValue(rs.getString("categorie"));
row.createCell((short) 2).setCellValue(rs.getString("marca"));
row.createCell((short) 3).setCellValue(rs.getString("model"));
row.createCell((short) 4).setCellValue(rs.getString("culoare"));
row.createCell((short) 5).setCellValue(rs.getString("tesatura"));
row.createCell((short) 6).setCellValue(Integer.toString(rs.getInt("marime")));
row.createCell((short) 7).setCellValue(rs.getString("sezon"));
row.createCell((short) 8).setCellValue(Integer.toString(rs.getInt("inaltimeTotala")));
row.createCell((short) 9).setCellValue(Integer.toString(rs.getInt("greutate")));
row.createCell((short) 10).setCellValue(Integer.toString(rs.getInt("pret")));
row.createCell((short) 11).setCellValue(Integer.toString(rs.getInt("cantitate")));

i++;
}
FileOutputStream fileOut =  new FileOutputStream(filename);
hwb.write(fileOut);
fileOut.close();
System.out.println("Your excel file has been generated!");

} catch ( Exception ex ) {
    System.out.println(ex);

}
    }
}


