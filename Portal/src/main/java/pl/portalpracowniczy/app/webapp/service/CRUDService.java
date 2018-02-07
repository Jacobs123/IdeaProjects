package pl.portalpracowniczy.app.webapp.service;

public interface CRUDService<E> {

    /**
     * CRUD function definition's
     */
    public E createEployee(E e);

    public void readEmployee();
    public void updateEmployee();
    public void delateEmployee();

}
