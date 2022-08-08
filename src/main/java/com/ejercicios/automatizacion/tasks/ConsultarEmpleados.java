package com.ejercicios.automatizacion.tasks;

import com.ejercicios.automatizacion.utils.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsultarEmpleados implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(Constantes.RECURSO_LISTA_EMPLEADOS));

    }

    public static ConsultarEmpleados listaConInformacion() {
        return Tasks.instrumented(ConsultarEmpleados.class);
    }

}
