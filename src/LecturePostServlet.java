import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import web.Lecture;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LecturePostServlet")
public class LecturePostServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public LecturePostServlet() {
      super();
      // TODO Auto-generated constructor stub
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub

      String q1 = request.getParameter("major");
      String q2 = request.getParameter("lectureName");
      String q3 = request.getParameter("lectureType");
      String q4 = request.getParameter("teacherName");
      String q5 = request.getParameter("grade");
      if (q1 != null) {
         if (!q1.equals("전체")) {
            q1 = " and major = '" + request.getParameter("major") + "'";
         } else {
            q1 = "";
         }
         if (!q2.equals("")) {
            q2 = " and lectureName = '" + request.getParameter("lectureName") + "'";
         } else {
            q2 = "";
         }
         if (!q3.equals("전체")) {
            q3 = " and lectureType = '" + request.getParameter("lectureType") + "'";
         } else {
            q3 = "";
         }
         if (!q4.equals("전체")) {
            q4 = " and teacherName like '%" + request.getParameter("teacherName") + "%'";
         } else {
            q4 = "";
         }
         if (!q5.equals("전체")) {
            q5 = " and grade = '" + request.getParameter("grade") + "'";
         } else {
            q5 = "";
         }
      }
      //String strUpperSeqNo = request.getParameter("LAST_SEQ_NO");
      String strLowerSeqNo = request.getParameter("FIRST_SEQ_NO");
      int upperSeqNo;
      int lowerSeqNo;
         upperSeqNo = Integer.MAX_VALUE;

      // int upperSeqNo=1134;

      if (strLowerSeqNo == null)
         lowerSeqNo = 0;
      else
         lowerSeqNo = Integer.parseInt(strLowerSeqNo);
      
      Lecture list = readDB(upperSeqNo, lowerSeqNo, q1, q2, q3, q4, q5, request, response);
      request.setAttribute("LECTURE_LIST", list);
      RequestDispatcher dispatcher = request.getRequestDispatcher("ClassTable.jsp");
      dispatcher.forward(request, response);
   }

   private Lecture readDB(int upperSeqNo, int lowerSeqNo, String q1, String q2, String q3, String q4, String q5,
         HttpServletRequest request, HttpServletResponse response) throws ServletException {
      Lecture list = new Lecture();
      list.setQ1(request.getParameter("major"));
      list.setQ2(request.getParameter("lectureName"));
      list.setQ3(request.getParameter("lectureType"));
      list.setQ4(request.getParameter("teacherName"));
      list.setQ5(request.getParameter("grade"));
      
      Connection conn = null;
      Statement stmt = null;
      try {
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "student");
         if (conn == null)
            throw new Exception("데이터베이스에 연결할 수 없습니다.");
         stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("select * from lectureinfo where seqNo < " + upperSeqNo + " and seqNo >= " + lowerSeqNo + q1 + q2 + q3 + q4
               + q5 + " order by seqNo;");
         for (int cnt = 0; cnt < 10; cnt++) {
            if (!rs.next())
               break;

            list.setLectureName(cnt, rs.getString("lectureName"));
            list.setLectureType(cnt, rs.getString("lectureType"));
            list.setMajor(cnt, rs.getString("major"));
            list.setTeacherName(cnt, rs.getString("teacherName"));
            list.setGrade(cnt, rs.getString("grade"));
            list.setSeqNo(cnt, rs.getInt("SeqNo"));
            list.setLectureTime(cnt, rs.getString("lectureTime"));
         }
         if (!rs.next())
            list.setLastPage(true);
      } catch (Exception e) {
         throw new ServletException(e);
      } finally {
         try {
            stmt.close();
         } catch (Exception ignored) {
         }
         try {
            conn.close();
         } catch (Exception ignored) {
         }
      }
      return list;
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }
}

