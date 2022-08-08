package com.ejercicios.automatizacion.models;

public class Empleado {

    private String id;
    private String employee_name;
    private String employee_salary;
    private String employee_age;

    public Empleado() {
    }

    public Empleado(String id, String employee_name, String employee_salary, String employee_age) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(String employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(String employee_age) {
        this.employee_age = employee_age;
    }

    @Override
    public boolean equals(Object obj) {
        Empleado emp = null;
        if (obj instanceof Empleado && obj != null) {
            emp = (Empleado) obj;

            if (id.equals(emp.getId()) && employee_name.equals(emp.getEmployee_name()) && employee_salary.equals(emp.getEmployee_salary()) && employee_age.equals(emp.getEmployee_age())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id='" + id + '\'' +
                ", employee_name='" + employee_name + '\'' +
                ", employee_salary='" + employee_salary + '\'' +
                ", employee_age='" + employee_age + '\'' +
                '}';
    }


}
