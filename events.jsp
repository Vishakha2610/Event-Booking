<%@ page import="java.util.*, model.Event" %>
<html>
<head>
    <title>Event Booking</title>
    <style>
        body { font-family: Arial; }
        table { border-collapse: collapse; width: 60%; margin: auto; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: center; }
    </style>
</head>
<body>
    <h2 align="center">Available Events</h2>
    <table>
        <tr><th>Name</th><th>Location</th><th>Date</th><th>Action</th></tr>
        <%
            List<Event> events = (List<Event>) request.getAttribute("events");
            for (Event e : events) {
        %>
        <tr>
            <td><%= e.getName() %></td>
            <td><%= e.getLocation() %></td>
            <td><%= e.getDate() %></td>
            <td>
                <form action="book" method="post">
                    <input type="hidden" name="event_id" value="<%= e.getId() %>" />
                    Name: <input type="text" name="name" required />
                    Email: <input type="email" name="email" required />
                    <input type="submit" value="Book" />
                </form>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
