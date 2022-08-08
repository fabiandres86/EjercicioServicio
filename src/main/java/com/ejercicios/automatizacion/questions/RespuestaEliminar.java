package com.ejercicios.automatizacion.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RespuestaEliminar implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getStatusCode();
    }

    public static RespuestaEliminar empleado() {
        return new RespuestaEliminar();
    }
}
