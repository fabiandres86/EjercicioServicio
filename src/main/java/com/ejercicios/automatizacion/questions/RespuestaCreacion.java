package com.ejercicios.automatizacion.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RespuestaCreacion implements Question {
    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }

    public static RespuestaCreacion empleado() {
        return new RespuestaCreacion();
    }
}
