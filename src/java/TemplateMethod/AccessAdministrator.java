package TemplateMethod;

import Class.Person;
import DAO.PersonDAO;

public class AccessAdministrator extends AccessPlataform {
    
    @Override
    public boolean showPage() {
        if (authenticate()) {
            PersonDAO personDao = PersonDAO.getInstance();
            super.setPerson(new Person());
            super.setPerson(personDao.readID(super.getUser().getPersonId()));
            if (super.getPerson().getType().equals("administrador"))
                return true;
        }
        return false;
    }
    
}
