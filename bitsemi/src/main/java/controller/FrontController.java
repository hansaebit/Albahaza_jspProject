package controller;

import action.Action;
import action.ActionFactory;
import action.ActionForward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//member controller  // /controller/카테고리/명령어..
@WebServlet(name = "FrontController", urlPatterns = "/controller/*")
public class FrontController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //post method 로 들어온 한글 인코딩.
        request.setCharacterEncoding("utf-8");

        System.out.println(FrontController.class + " doPost()");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, IllegalArgumentException {
        System.out.println(FrontController.class + " doGet()");

        String requestURI = request.getRequestURI().toLowerCase();
        System.out.println("requestURI : " + requestURI);
        //requestURI : /bitsemi_war_exploded/controller/resume/getall
        request.getSession().setAttribute("requestURI", requestURI);

        String contextPath = request.getContextPath().toLowerCase();
        System.out.println("contextPath : " + contextPath);
        //contextPath : /bitsemi_war_exploded
        request.getSession().setAttribute("contextPath", contextPath);

        // controller/카테고리/명령어 분할. /controller/이후 command.
        String strIdxStart = "controller/";
        int tempIdx = requestURI.indexOf(strIdxStart) + strIdxStart.length();//controller 이후 인덱스
        System.out.println("tempIdx : " + tempIdx);

        String api = requestURI.substring(tempIdx, requestURI.length());
        System.out.println("api : " + api);

        String[] tempArr = api.split("/");
        String category = tempArr[0];
        String command = tempArr[1];
        System.out.println("category : " + category);
        System.out.println("command : " + command);

        Action action = null;
        ActionForward forward = null;

        action = ActionFactory.getAction(category, command);
        if (action != null) {
            forward = action.execute(request, response);

            if (forward == null) {
                throw new IllegalArgumentException("#############forward is null.#############");
            }
        } else {
            throw new NullPointerException("action is null.");
        }

        try {
            if (forward.isChangePage()) {
                if (forward.isRedirect()) {
                    System.out.println("forward.isRedirect() true : " + forward.getPath());
                    String path = "";
                    //  contextPath is "/bitsemi_war_exploded"
                    path = contextPath + "/" + forward.getPath();
                    System.out.println("path : " + path);
                    response.sendRedirect(path); //해당 경로의 html 결과 코드가 ajax 결과값으로 나온다?

                } else {
                    // forward 하기위한 url 세팅.
                    // 만약 해당 아이피로 들어왔다면? "/bitsemi_war_exploded/controller/member/getall?변수=값",
                    // 기본 주소는 세팅되어있으며, -> "/bitsemi_war_exploded/controller/member"
                    // path만 더해주면 됩니다. "/bitsemi_war_exploded/controller/member/" + path.
                    String path = forward.getPath();
                    System.out.println("else : " + path);
                    RequestDispatcher dispatcher = request.getRequestDispatcher(path);
                    dispatcher.forward(request, response);
                }
            }

            printJsonData(response, forward);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    void printJsonData(HttpServletResponse response, ActionForward forward)
            throws IOException {
        response.setContentType("text/html;charset=utf-8"); //출력 인코딩 세팅.
        //Action 구현체에서 가져온 forward 안에 담겨진 printData를 출력.
        System.out.println("print Data : " + forward.getPrintData());
        PrintWriter out = response.getWriter(); //웹페이지에 데이터를 출력하기위한 객체.
        out.print(forward.getPrintData());
    }
}
