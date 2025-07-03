@WebServlet("/events")
public class EventServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Event> eventList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/event_booking", "root", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM events");

            while (rs.next()) {
                eventList.add(new Event(rs.getInt("id"), rs.getString("name"),
                        rs.getString("location"), rs.getDate("date")));
            }

            request.setAttribute("events", eventList);
            RequestDispatcher rd = request.getRequestDispatcher("events.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
