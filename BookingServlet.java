@WebServlet("/book")
public class BookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int eventId = Integer.parseInt(request.getParameter("event_id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/event_booking", "root", "password");
            PreparedStatement pst = con.prepareStatement("INSERT INTO bookings (event_id, name, email) VALUES (?, ?, ?)");
            pst.setInt(1, eventId);
            pst.setString(2, name);
            pst.setString(3, email);
            pst.executeUpdate();

            response.sendRedirect("events");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
