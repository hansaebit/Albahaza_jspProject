package action;

import action.favorites.FavoriteAddAction;
import action.joboffer.*;
import action.others.AllSearchAction;
import action.resume.*;
import action.auth.LoginAction;
import action.member.*;
import action.others.ZipcodeGetAction;
import data.dto.*;

import javax.servlet.http.HttpServletRequest;


public class ActionFactory {
    /**
     * controller/member/add 라 가정하였을 때, 아래처럼 들어가게 됩니다.
     *
     * @param category member
     * @param command  add
     * @return Action 으로 부터 상속받은 클래스
     */
    public static Action getAction(String category, String command) {
        Action action = null;

        //command 는 예를 들어 /member/add 또는 /member/isidcheck 등 url 뒤에 붙은 단어를 말합니다.
        if (category.equals("member")) {
            if (command.equals("add")) {
                action = new MemberAddAction();
            } else if (command.equals("getall")) {
                action = new MemberGetAction();
            } else if (command.equals("update")) {
                action = new MemberUpdateAction();
            } else if (command.equals("delete")) {
                action = new MemberDeleteAction();
            } else if (command.equals("isidcheck")) {
                action = new MemberIsExistAction();
            } else if (command.equals("mypage")) {
                action = new MemberMypageAction();
            } else if (command.equals("like")) {
                action = new MemberLikeAction();
            }
        } else if (category.equals("auth")) {
            if (command.equals("login")) {
                action = new LoginAction();
            }
        } else if (category.equals("joboffer")) {
            if (command.equals("add")) {
                action = new JobofferAddAction();
            } else if (command.equals("getall")) {
                action = new JobofferGetAllAction();
            } else if (command.equals("get")) {
                action = new JobofferGetAction();
            } else if (command.equals("delete")) {
                action = new JobofferDeleteAction();
            } else if (command.equals("update")) {
                action = new JobofferUpdateAction();
            } else if (command.equals("pick")) {
                action = new JobofferPickAction();
            }
        } else if (category.equals("resume")) {
            if (command.equals("add")) {
                action = new ResumeAddAction();
            } else if (command.equals("getall")) {
                action = new ResumeGetAllAction();
            } else if (command.equals("get")) {
                action = new ResumeGetAction();
            } else if (command.equals("delete")) {
                action = new ResumeDeleteAction();
            } else if (command.equals("update")) {
                action = new ResumeUpdateAction();
            }
        } else if (category.equals("zipcode")) {
            if (command.equals("getall")) {
                action = new ZipcodeGetAction();
            }
        } else if (category.equals("favorite")) {
            if (command.equals("add")) {
                action = new FavoriteAddAction();
            } else if (command.equals("update")) {
//                action = new FavoriteUpdateAction();
            }
        } else if (category.equals("others")) {
            if (command.equals("search")) {
                action = new AllSearchAction();
            }
        }
        return action;
    }

    /**
     * 모든 dto들은 Dto 인터페이스를 상속받게 됩니다.
     *
     * @param category
     * @param request
     * @return 받을 땐 ex : dto = (MemberDto)getDto(); 이런식으로 받습니다.
     */
    public static Dto getDto(Category category, HttpServletRequest request) {
        Dto dto = null;

        if (category.equals(Category.Member)) {

            String num = (String) request.getParameter("num");
            String id = (String) request.getParameter("id");
            String pass = (String) request.getParameter("pass");
            String name = (String) request.getParameter("name");
            String age = (String) request.getParameter("age");

            String gender = (String) request.getParameter("gender");
            String phonenum = (String) request.getParameter("phonenum");
            String email = (String) request.getParameter("email");
            String ishire = (String) request.getParameter("ishire");
            String likes = (String) request.getParameter("likes");

            String createday = (String) request.getParameter("createday");
            String matchpoint = (String) request.getParameter("matchpoint");

            dto = new MemberDto(
                    num, id, pass, name, age, gender, phonenum, email, ishire, likes, createday, matchpoint
            );

        } else if (category.equals(Category.Resume)) {
            String num = (String) request.getParameter("num");
            String id = (String) request.getParameter("id");
            String name = (String) request.getParameter("name");
            String phonenum = (String) request.getParameter("phonenum");
            String location = (String) request.getParameter("location");

            String jobtype = (String) request.getParameter("jobtype");
            String abletime = (String) request.getParameter("abletime");
            String introduce = (String) request.getParameter("introduce");
            String career = (String) request.getParameter("career");
            String isclose = (String) request.getParameter("isclose");

            String term = (String) request.getParameter("term");
            String writeday = (String) request.getParameter("writeday");

            dto = new ResumeDto(
                    num, id, name, phonenum, location, jobtype, abletime, introduce, career, isclose, term, writeday
            );
        } else if (category.equals(Category.Joboffer)) {
            String num = (String) request.getParameter("num");
            String id = (String) request.getParameter("id");
            String companyname = (String) request.getParameter("companyname");
            String phonenum = (String) request.getParameter("phonenum");
            String location = (String) request.getParameter("location");

            String jobtype = (String) request.getParameter("jobtype");
            String introduce = (String) request.getParameter("introduce");
            String abletime = (String) request.getParameter("abletime");
            String pay = (String) request.getParameter("pay");
            String writeday = (String) request.getParameter("writeday");

            String needpeople = (String) request.getParameter("needpeople");
            String applicant = (String) request.getParameter("applicant");
            String xpoint = (String) request.getParameter("xpoint");
            String ypoint = (String) request.getParameter("ypoint");
            String term = (String) request.getParameter("term");

            dto = new JobofferDto(
                    num, id, companyname, phonenum, location, jobtype, abletime, introduce, pay, writeday, needpeople, applicant, xpoint, ypoint, term
            );

        } else if (category.equals(Category.Favorites)) {
            String num = (String) request.getParameter("num");
            String employeeid = (String) request.getParameter("employeeid");
            String employerid = (String) request.getParameter("employerid");
            String employeenum = (String) request.getParameter("employeenum");
            String employernum = (String) request.getParameter("employernum");

            String matchday = (String) request.getParameter("matchday");
            String createday = (String) request.getParameter("createday");
            dto = new FavoritesDto(
                    num, employeeid, employerid, employeenum, employernum, matchday, createday
            );
        } else {
            dto = null;
        }

        return dto;
    }


}
