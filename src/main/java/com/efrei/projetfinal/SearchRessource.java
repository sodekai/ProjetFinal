package com.efrei.projetfinal;

import com.efrei.projetfinal.model.ApprentiEntity;
import com.efrei.projetfinal.model.ApprentiSB;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Arrays;
import java.util.List;

@Path("/search")
@Stateless
public class SearchRessource {
    @EJB
    private ApprentiSB apprentiSB;

    @GET
    @Path("/apprentis/{field}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<ApprentiEntity> getTypeField(@PathParam("field") String field) {
        List<ApprentiEntity> apprentiEntityList = null;
        apprentiEntityList = apprentiSB.getApprentisByWord(field);
        if(apprentiEntityList != null){
           System.out.println(Arrays.toString(apprentiEntityList.toArray()));
        } else {
            System.out.println("vide");
        }
        return apprentiEntityList;
    }
}
