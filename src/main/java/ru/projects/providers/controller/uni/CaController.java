package ru.projects.providers.controller.uni;

import ru.projects.dictionary.Service;
import ru.projects.entities.ca.dto.CaWorkflowDTO;
import ru.projects.providers.controller.BaseController;

public class CaController extends BaseController {
    private static CaController instance;

    private CaController(Service service) {
        super(service);
    }

    public static CaController getInstance() {
        if (instance == null) {
            instance = new CaController(Service.CA);
        }
        return instance;
    }

    public CaWorkflowDTO getByTypeWf(String typeWf) {
        return getClearSession()
                .createQuery("FROM  = '" + typeWf
                        + "' AND updated = null AND customerId IS NOT NULL ORDER BY id DESC", CaWorkflowDTO.class)
                .setMaxResults(1)
                .getSingleResult();
    }
}
