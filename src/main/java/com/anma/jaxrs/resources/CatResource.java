package com.anma.jaxrs.resources;

import com.anma.jaxrs.models.Cat;
import com.anma.jaxrs.services.CatService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/api/cats")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CatResource {

    private CatService catService = new CatService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cat> getCats() {
        return catService.getAllCats();
    }

    @GET
    @Path("/{catId}")
    public Cat getCat(@PathParam("catId") long id, @Context UriInfo uriInfo) {
//        return catService.getCat(catId);
        return new Cat(1L,"Murzik", 7);
    }

    @POST
    public Response addCat(Cat cat, @Context UriInfo uriInfo) {
        Cat newCat = catService.createCat(cat);
        String newId = String.valueOf(cat.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(uri)
                .entity(newCat)
                .build();
    }

}
