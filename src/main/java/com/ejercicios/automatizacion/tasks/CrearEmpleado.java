package com.ejercicios.automatizacion.tasks;

import com.ejercicios.automatizacion.models.Empleado;
import com.ejercicios.automatizacion.utils.Constantes;
import com.ejercicios.automatizacion.utils.TablaEmpleado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.List;

public class CrearEmpleado implements Task {
    private List<String> datosEmpledo;

    public CrearEmpleado(List<String> datosEmpledo) {
        this.datosEmpledo = datosEmpledo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Empleado empleado = TablaEmpleado.obtenerEmpleado(datosEmpledo);
        actor.attemptsTo(Post.to(Constantes.CREAR_EMPLEADO).
                with(request -> request.header("Content-Type", "application/json").body(empleado)));

    }

    public static CrearEmpleado conLosDatos(List<String> datosEmpleado) {
        return Tasks.instrumented(CrearEmpleado.class, datosEmpleado);
    }
}
