package com.ejercicios.automatizacion.tasks;

import com.ejercicios.automatizacion.utils.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsultarEmpleado implements Task {
    private int identificacion;

    public ConsultarEmpleado(int identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(Constantes.RECURSO_EMPLEADO)
                .with(request -> request.pathParam("id", identificacion)));
    }

    public static ConsultarEmpleado porSu(int identificacion) {
        return Tasks.instrumented(ConsultarEmpleado.class, identificacion);

    }
}
