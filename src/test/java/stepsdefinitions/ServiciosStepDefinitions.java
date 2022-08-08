package stepsdefinitions;

import com.ejercicios.automatizacion.models.Empleado;
import com.ejercicios.automatizacion.questions.RespuestaConsulta;
import com.ejercicios.automatizacion.questions.RespuestaCreacion;
import com.ejercicios.automatizacion.questions.RespuestaEliminar;
import com.ejercicios.automatizacion.questions.RespuestaServicio;
import com.ejercicios.automatizacion.tasks.ConsultarEmpleado;
import com.ejercicios.automatizacion.tasks.ConsultarEmpleados;
import com.ejercicios.automatizacion.tasks.CrearEmpleado;
import com.ejercicios.automatizacion.tasks.EliminarEmpleado;
import com.ejercicios.automatizacion.utils.Constantes;
import com.ejercicios.automatizacion.utils.TablaEmpleado;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

public class ServiciosStepDefinitions {
    private String theRestApiBaseUrl;
    private EnvironmentVariables environmentVariables;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que carolina tiena acceso al servicio")
    public void queCarolinaTienaAccesoAlServicio() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl").
                orElse(Constantes.URL_DEFAULT);
        theActorCalled("Carolina").whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @Cuando("consulta la informacion de los empleados")
    public void consultaLaInformacionDeLosEmpleados() {
        theActorInTheSpotlight().attemptsTo(ConsultarEmpleados.listaConInformacion());
    }


    @Entonces("el sistemas muestra la lista empleados consultada")
    public void elSistemasMuestraLaListaEmpleadosConsultada() {
        theActorInTheSpotlight().should(seeThat(RespuestaServicio.verlaLista(), is(true)));
    }

    @Cuando("consulta la informacion del empleado con identificacion {int}")
    public void consultaLaInformacionDelEmpleadoConIdentificacion(Integer identificacion) {
        theActorInTheSpotlight().attemptsTo(ConsultarEmpleado.porSu(identificacion));

    }

    @Entonces("el sistemas muestra la informacion:")
    public void elSistemasMuestraLaInformacion(DataTable informacionEmpleado) {
        Empleado emp = TablaEmpleado.obtenerEmpleado(informacionEmpleado.row(1));
        theActorInTheSpotlight().should(seeThat(RespuestaConsulta.informacionEmpleado(), equalTo(emp.toString())));


    }

    @Cuando("se ingresa la informacion del empleado")
    public void seIngresaLaInformacionDelEmpleado(DataTable informacionEmpleado) {
        theActorInTheSpotlight().attemptsTo(CrearEmpleado.conLosDatos(informacionEmpleado.row(1)));

    }

    @Entonces("El sistema debe mostrar la creacion exitosa del empleado")
    public void elSistemaDebeMostrarLaCreacionExitosaDelEmpleado() {
        theActorInTheSpotlight().should(seeThat(RespuestaCreacion.empleado(), equalTo(Constantes.ESTADO_ESPERADO)));
    }


    @Cuando("se elimina el usuario con  identificacion {int}")
    public void seEliminaElUsuarioConIdentificacion(Integer numeroIndetificacion) {
        theActorInTheSpotlight().attemptsTo(EliminarEmpleado.porSu(numeroIndetificacion));
    }

    @Entonces("el sistema debe mostrar el proceso exitoso")
    public void elSistemaDebeMostrarElProcesoExitoso() {
        theActorInTheSpotlight().should(seeThat(RespuestaEliminar.empleado(), equalTo(Constantes.ESTADO_ESPERADO)));
    }
}
