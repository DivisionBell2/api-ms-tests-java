package ru.projects.providers.controller.uni;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.projects.dictionary.Service;
import ru.projects.providers.controller.BaseController;

public class OrbController extends BaseController {
    private static OrbController instance;

    private OrbController(Service service) {
        super(service);
    }

    public static OrbController getInstance() {
        if (instance == null) {
            instance = new OrbController(Service.OBR);
        }
        return instance;
    }

    public void updateActiveCode(String hash, Long id) {
        Transaction txn = getClearSession().beginTransaction();
        Query query = getClearSession()
                .createQuery("UPDATE DTO SET activationCode = '"
                        + hash + "' WHERE id = " + id);
        query.executeUpdate();
        txn.commit();
    }

    public void updateAuthenticationCode(String hash, Long id) {
        Transaction txn = getClearSession().beginTransaction();
        Query query = getClearSession()
                .createQuery("UPDATE DTO SET authenticationCode = '"
                        + hash + "' WHERE id = " + id);
        query.executeUpdate();
        txn.commit();
    }

    public void deleteByAuthenticationCode(String hash) {
        Transaction txn = getClearSession().beginTransaction();
        Query query = getClearSession().createQuery("DELETE FROM DTO WHERE authenticationCode = '" + hash + "'");
        query.executeUpdate();
        txn.commit();
    }
}
