/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

@WebServlet("/nuevaPoliza")

/**
 *
 * @author C.V
 */
public class nuevaPoliza extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    public nuevaPoliza() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
                //String db_name = "SegurosGio", db_col_name = "Usuarios";
		String nombrePoliza, coberturaPoliza;
		nombrePoliza = request.getParameter("tipo_poliza").toString();
		coberturaPoliza = request.getParameter("cobertura").toString();
		/*try {*/
		//	MongoClient conn = gio.co.seguros.MongoConnectDB.connectMongo();
                //        MongoDatabase db = conn.getDatabase(db_name);
                //        MongoCollection<Document> coll = db.getCollection(db_col_name);
                    MongoCollection<Document> coll = gio.co.seguros.collPoliza.collpoliza();
                        try {
                        Document doc = new Document("tipo_poliza", nombrePoliza)
                            .append("cobertura", coberturaPoliza);
                        coll.insertOne(doc);
                        RequestDispatcher rd = request.getRequestDispatcher("administracionPolizas.jsp");
                        rd.forward(request, response);
                        //puesto = "Admin";
                        } catch(MongoException | ClassCastException e){
                            e.printStackTrace();
                            //log.error("Exception occurred while insert Value using **BasicDBObject** : " + e, e);
                        }
                        
                        //FindIterable<Document> fi = coll.find(eq ("nombre", "Mateo"));
                        //MongoCursor<Document> cursor = fi.iterator();
                        
                        
                        
			/*if(rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("page2_h1.jsp");
				rd.forward(request, response);
			}else {
				response.sendRedirect("index.jsp?val=0");
			}
		} /*catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

    
}




