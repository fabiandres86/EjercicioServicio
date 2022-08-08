package com.ejercicios.automatizacion.utils;

public class Constantes {
    public static final String URL_DEFAULT = "http://dummy.restapiexample.com/api/v1";
    public static final String RUTA_ARCHIVO = "src/test/resources/archivos/empleados.xlsx";
    public static final String RECURSO_EMPLEADO = "/employee/{id}";
    public static final String RECURSO_LISTA_EMPLEADOS = "/employees";
    public static final String ElIMINAR_EMPLEADO = "/delete/{id}";
    public static final String CREAR_EMPLEADO = "/create";
    public static final int ESTADO_ESPERADO = 200;

    private Constantes() {
    }
}
