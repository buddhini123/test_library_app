package com.library.ws;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;












import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.json.JSONArray;
import org.json.JSONObject;

import com.library.domain.Book;
import com.library.domain.Member;
import com.library.domain.LibraryDAO;;


@Path("/library")
public class LibraryService {

	
	@GET
	@Path("/getmembers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Member> getMemberList() {
		LibraryDAO dao = new LibraryDAO();
		
		return dao.listMembers();
	}
	
	@GET
	@Path("/getlastmember")
	@Produces(MediaType.APPLICATION_JSON)
	public Member getLastMember() {
		LibraryDAO dao = new LibraryDAO();
		
		return dao.getLastRegisteredMember();
	}
	
	@GET
	@Path("/getbooks")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBookList() {
		LibraryDAO dao = new LibraryDAO();
		
		return dao.listBooks();
	}
	
	@POST
	@Path("/createmember")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createMember(String memberData) {
		
		String returnString = null;
		
		try {
		JSONObject memberObject = new JSONObject(memberData);
		JSONObject messageObject = new JSONObject();
		JSONArray messageArray = new JSONArray();
		
		LibraryDAO dao = new LibraryDAO();
		
		dao.createNewMember(memberObject.optString("regNo"),memberObject.optString("firstName"),memberObject.optString("lastName"),memberObject.optString("nic"));
		
		messageObject.put("msg", "New Member Registered !!!");
		returnString = messageObject.toString();
		
		return Response.status(Response.Status.OK).entity(returnString).build();
		
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Unable to register member!").build();
		}
	}
	
	@POST
	@Path("/lendBook")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response lendBook(String lendData) {
		
		String returnString = null;
		
		try {
		JSONObject lendObject = new JSONObject(lendData);
		JSONObject messageObject = new JSONObject();
		JSONArray messageArray = new JSONArray();
		
		LibraryDAO dao = new LibraryDAO();
		
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date dueReturnDate = formatter.parse(lendObject.optString("dueReturnDate"));

		dao.lendBook(lendObject.optString("memberId"),lendObject.optString("bookId"),dueReturnDate,lendObject.optString("comments"));
		
		messageObject.put("msg", "Lending Successful !!!");
		returnString = messageObject.toString();
		
		return Response.status(Response.Status.OK).entity(returnString).build();
		
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Unable to lend Book!").build();
		}
	}

}
