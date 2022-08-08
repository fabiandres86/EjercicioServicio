package com.ejercicios.automatizacion.questions;

import com.ejercicios.automatizacion.models.Empleado;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RespuestaConsulta implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        Empleado myEmpleado = SerenityRest.lastResponse().jsonPath().getObject("data", Empleado.class);
        return myEmpleado.toString();
    }

    public static RespuestaConsulta informacionEmpleado() {
        return new RespuestaConsulta();
    }
}
