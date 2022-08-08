package com.ejercicios.automatizacion.utils;

import com.ejercicios.automatizacion.models.Empleado;

import java.util.List;

public class TablaEmpleado {
    private static Empleado empleado;

    public static Empleado obtenerEmpleados(List<List<String>> datos) {
        empleado = new Empleado();
        for (List<String> row : datos) {
            for (int i = 1; i < row.size(); i++) {
                empleado.setId(row.get(0));
                empleado.setEmployee_name(row.get(1));
                empleado.setEmployee_salary(row.get(2));
                empleado.setEmployee_age(row.get(3));

            }
        }
        return empleado;

    }

    public static Empleado obtenerEmpleado(List<String> datosEmpledo) {
        empleado = new Empleado();
        for (int i = 0; i < datosEmpledo.size(); i++) {
            empleado.setId(datosEmpledo.get(0));
            empleado.setEmployee_name(datosEmpledo.get(1));
            empleado.setEmployee_salary(datosEmpledo.get(2));
            empleado.setEmployee_age(datosEmpledo.get(3));
        }
        return empleado;
    }

}
