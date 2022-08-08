package com.ejercicios.automatizacion.utils;

import com.ejercicios.automatizacion.models.Empleado;

import java.util.List;

public class UtilArchivo {

    public static boolean comparar(List<Empleado> listaEmpleados, List<Empleado> listaEmpleados2) {
        if (listaEmpleados.size() > listaEmpleados2.size()) {
            return false;
        }
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (!listaEmpleados.get(i).equals(listaEmpleados2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
