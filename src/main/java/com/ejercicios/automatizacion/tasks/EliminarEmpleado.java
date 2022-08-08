package com.ejercicios.automatizacion.tasks;

import com.ejercicios.automatizacion.utils.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class EliminarEmpleado implements Task {
    private int numeroIdentificacion;

    public EliminarEmpleado(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(Constantes.ElIMINAR_EMPLEADO)
                .with(request -> request.pathParam("id", numeroIdentificacion)));

    }

    public static EliminarEmpleado porSu(int numeroIdentificacion) {
        return Tasks.instrumented(EliminarEmpleado.class, numeroIdentificacion);

    }
}
