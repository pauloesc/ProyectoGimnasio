package controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerarPDF extends HttpServlet {
 private static final long serialVersionUID = 1L;

 public GenerarPDF() {
  super();
 }

 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request, response);
 }

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  //get the output stream for writing binary data in the response.
  ServletOutputStream os = response.getOutputStream();
  //set the response content type to PDF
  response.setContentType("application/pdf"); 
  //create a new document
  Document doc = new Document();

  //create some special styles and font sizes
  Font bfBold18 = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD, new BaseColor(0, 0, 0)); 
  Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLDITALIC, new BaseColor(0, 0, 0)); 
  Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12); 

  String nombreSocio = (String) request.getAttribute("nombreSocio");
  String nombreProfe = (String) request.getAttribute("nombreProfe");
  String clase = (String) request.getAttribute("nombreClase");
  String actividad = (String) request.getAttribute("nombreActividad");
  String descrPremio = (String) request.getAttribute("fechaPremio");
  String fechaClase = (String) request.getAttribute("fechaClase");
  String fechaCertificado = "02/02/2021";
  
  
  try{
   
   //create an instance of the PdfWriter using the output stream
   PdfWriter.getInstance(doc, os); 

   //document header properties
   doc.addAuthor("entrenamos.uy");
   doc.addCreationDate();
   doc.addProducer();
   doc.addCreator("entrenamos.uy");
   doc.addTitle("Premio");
   doc.setPageSize(PageSize.A6);
   doc.open();

   //add a new paragraph
   Paragraph titulo = new Paragraph("Entrenamos.UY", bfBold18);
   titulo.setAlignment(Paragraph.ALIGN_CENTER);
   doc.add(titulo);
   Paragraph subtitulo = new Paragraph("Certificado de Premio", bfBold18);
   subtitulo.setAlignment(Paragraph.ALIGN_CENTER);
   subtitulo.setSpacingAfter(50);
   doc.add(subtitulo);
   
   
   Paragraph centro = new Paragraph("Este documento certifica que el usuario " + nombreSocio + " de la plataforma Entrenamos.UY recibio el premio " + descrPremio + " por participar de la clase " + clase + " de la actividad deportiva " + actividad + ".", bfBold12);
   centro.setAlignment(Paragraph.ALIGN_JUSTIFIED);
   doc.add(centro);
   
   Paragraph footer = new Paragraph("La clase fue dictada el " + fechaClase + " por el profesor " + nombreProfe + ".", bf12);
   footer.setSpacingBefore(50);
   footer.setSpacingAfter(20);
   doc.add(footer);
   
   doc.add( new Paragraph("Este certificado fue generado el " + fechaCertificado +".", bf12));
   doc.close(); 

  }catch(DocumentException e){
   e.printStackTrace();
  }
  catch(Exception e){
   e.printStackTrace();
  }

 }

}
