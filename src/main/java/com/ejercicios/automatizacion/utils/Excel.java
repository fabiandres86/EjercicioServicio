package com.ejercicios.automatizacion.utils;

import com.ejercicios.automatizacion.models.Empleado;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Excel {

    private static XSSFWorkbook libroExcel = null;
    private static XSSFSheet hojaExcel = null;

    public static void abrir() {
        FileInputStream flujo = null;
        File archivo = null;
        if (hojaExcel == null) {
            archivo = new File(Constantes.RUTA_ARCHIVO);
            try {
                flujo = new FileInputStream(archivo);
                libroExcel = new XSSFWorkbook(flujo);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void abrirHoja(String nombreHoja) {
        if (libroExcel == null) {
            abrir();
        }
        hojaExcel = libroExcel.getSheet(nombreHoja);
    }

    public static void abrirHoja(int index) {
        if (libroExcel == null) {
            abrir();
        }
        if (index >= 0) {
            hojaExcel = libroExcel.getSheetAt(index);
        } else {
            hojaExcel = libroExcel.getSheetAt(0);
        }
    }

    public static List<Empleado> leerHoja(int index) {
        DataFormatter formato;
        ArrayList<Empleado> datosHoja = new ArrayList<>();
        Empleado empleado = new Empleado();
        Iterator<Row> iteradorFila = null;
        int numeroCeldas = 0;
        Row filaHoja = null;
        Cell celda;
        if (hojaExcel == null) {
            abrirHoja(index);
        }
        iteradorFila = hojaExcel.iterator();
        iteradorFila.next();
        formato = new DataFormatter();
        while (iteradorFila.hasNext()) {
            empleado = new Empleado();
            filaHoja = iteradorFila.next();

            empleado.setId(formato.formatCellValue(filaHoja.getCell(0)).trim());
            empleado.setEmployee_name(filaHoja.getCell(1).getStringCellValue().trim());
            empleado.setEmployee_salary(formato.formatCellValue(filaHoja.getCell(2)).trim());
            empleado.setEmployee_age(formato.formatCellValue(filaHoja.getCell(3)).trim());
            datosHoja.add(empleado);
            empleado = null;
        }
        return datosHoja;
    }

}
