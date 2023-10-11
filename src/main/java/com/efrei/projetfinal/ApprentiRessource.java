package com.efrei.projetfinal;

import com.efrei.projetfinal.model.ApprentiEntity;
import com.efrei.projetfinal.model.ApprentiSB;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/apprenti/{id}")
@Stateless
public class ApprentiRessource {
    @EJB
    private ApprentiSB apprentiSB;

    @PathParam("id")
    private int id;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ApprentiEntity getApprenti(){
        return apprentiSB.getApprenti(id);
    }
}
