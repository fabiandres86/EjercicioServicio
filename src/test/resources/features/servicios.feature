#language:es

Característica: Gestionar la informacion de los empleados

  Antecedentes:
    Dado que carolina tiena acceso al servicio

  @Escenario1
  Escenario: Carolina quiere consultar la informacion de los empleados
    Cuando consulta la informacion de los empleados
    Entonces el sistemas muestra la lista empleados consultada

  @Escenario2
  Escenario: Consultar la informacion de un empleado con su identificacion
    Cuando consulta la informacion del empleado con identificacion 2
    Entonces el sistemas muestra la informacion:
      | id | nombre          | salario | edad |
      | 2  | Garrett Winters | 170750  | 63   |

  @Escenario3
  Escenario: Crear un empleado  en el sistema con la informacion
    Cuando se ingresa la informacion del empleado
      | id | nombre | salario | edad |
      | 2 | fabian | 320800  | 36   |
    Entonces El sistema debe mostrar la creacion exitosa del empleado

  @Escenario4
  Escenario: Eliminar un empleado del sistema
    Cuando se elimina el usuario con  identificacion 2
    Entonces el sistema debe mostrar el proceso exitoso
