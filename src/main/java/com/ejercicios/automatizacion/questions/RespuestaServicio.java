package com.ejercicios.automatizacion.questions;

import com.ejercicios.automatizacion.models.Empleado;
import com.ejercicios.automatizacion.utils.Excel;
import com.ejercicios.automatizacion.utils.UtilArchivo;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class RespuestaServicio implements Question<Boolean> {

    public static Question<Boolean> verlaLista() {
        return new RespuestaServicio();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<Empleado> listaEmpleados = SerenityRest.lastResponse().jsonPath().getList("data", Empleado.class);

        return UtilArchivo.comparar(Excel.leerHoja(0), listaEmpleados);
    }
}
