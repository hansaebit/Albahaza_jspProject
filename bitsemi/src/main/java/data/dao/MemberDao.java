package data.dao;

import config.ServerConfig;
import data.dto.MemberDto;
import db.connect.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
    MysqlConnect db = new MysqlConnect();

    //중복 아이디 체크-아이디 없으면 false반환
    public boolean isIdCheck(String id) {
        //
        boolean find = false;
        String sql = "select * from member where id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        //mysql connect
        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next())
                find = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt, rs);
        }
        return find;
    }

    //insert
    public void insertMember(MemberDto dto) {
        String sql = "insert into" +
                " member (id, pass, name, age, gender, phonenum, email, ishire, likes, matchpoint, createday )" +
                " values (?, ?, ?, ?, ?, ?, ?, ?, 0, ?, now())";
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = db.getMyConnection();

        //System.out.println(dto.getLikes());

        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, dto.getId());
            pstmt.setString(2, dto.getPass());
            pstmt.setString(3, dto.getName());
            pstmt.setString(4, dto.getAge());
            pstmt.setString(5, dto.getGender());
            pstmt.setString(6, dto.getPhonenum());
            pstmt.setString(7, dto.getEmail());
            pstmt.setString(8, dto.getIshire());
//            pstmt.setString(9, dto.getLikes());
            pstmt.setString(9, dto.getMatchpoint());
            //실행
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt);
        }
    }

    //mypage에 보이는 내용
    public MemberDto getData(String id) {
        MemberDto dto = new MemberDto();
        String sql = "select * from member where id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto.setNum(rs.getString("num"));
                dto.setId(rs.getString("id"));
                dto.setName(rs.getString("name"));
                dto.setAge(rs.getString("age"));
                dto.setGender(rs.getString("gender"));

                dto.setPhonenum(rs.getString("phonenum"));
                dto.setEmail(rs.getString("email"));
                dto.setIshire(rs.getString("ishire"));
                dto.setLikes(rs.getString("likes"));
                dto.setMatchpoint(rs.getString("matchpoint"));

                dto.setCreateday(rs.getString("createday"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt, rs);
        }
        return dto;
    }

    public List<MemberDto> getAllData() {
        List<MemberDto> list = new ArrayList<>();
        String sql = "select * from member order by num asc";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                if (ServerConfig.isTestMode()) {
//                    System.out.println(rs.getRow());  //현재 행 넘버 20번쨰에 20.
                }

                MemberDto dto = new MemberDto();
                dto.setId(rs.getString("id"));
                dto.setName(rs.getString("name"));
                dto.setAge(rs.getString("age"));
                dto.setGender(rs.getString("gender"));
                dto.setPhonenum(rs.getString("phonenum"));
                dto.setEmail(rs.getString("email"));
                dto.setIshire(rs.getString("ishire"));
                dto.setMatchpoint(rs.getString("matchpoint"));
                dto.setLikes(rs.getString("likes"));
                list.add(dto);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt, rs);
        }

        return list;
    }

    public boolean updateMember(MemberDto dto) {
        boolean result = false;
        String sql = "update member set name=?,age=?,gender=?,phonenum=?,email=?,ishire=? where num=?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getAge());
            pstmt.setString(3, dto.getGender());
            pstmt.setString(4, dto.getPhonenum());
            pstmt.setString(5, dto.getEmail());
            pstmt.setString(6, dto.getIshire());
            pstmt.setString(7, dto.getNum());

            //실행
            pstmt.execute();
            result = true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            result = false;
        } finally {
            db.dbClose(conn, pstmt);
            return result;
        }
    }

    public void deleteMember(String id) {
        String sql = "delete from member where id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, id);
            //실행
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt);
        }
    }

    //login-id/pass check -> 아이디에 해당하는 비밀번호가 맞으면 true, 틀리면 false
    public boolean isIdPassCheck(String id, String pass) {
        boolean find = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from member where id=? and pass=?";

        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, id);
            pstmt.setString(2, pass);
            rs = pstmt.executeQuery();
            if (rs.next())
                find = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt, rs);
        }
        return find;
    }

    //로그인 메서드
    //DB에 id가 없을경우 1, id는 있지만 pass가 안맞을 경우 2, 둘다 맞으면 3반환
    public int loginProcess(String id, String pass) {
        int ans = 0;
        if (this.isIdCheck(id))//아이디가 존재하는경우
        {
            //비번체크
            if (this.isIdPassCheck(id, pass)) {
                ans = 3;
            } else {
                ans = 2;
            }
        } else {
            ans = 1;
        }
        return ans;
    }

    //비밀번호 변경
    public void updatePass(String id, String pass) {
        String sql = "update member set pass=? where id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, pass);
            pstmt.setString(2, id);
            //실행
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt);
        }
    }

    //비밀번호 변경 메서드
    //비밀번호가 일치하면 true, 일치하지 않으면 false
    public boolean passUpdateProcess(String id, String pass) {
        boolean result = false;
        //비번체크
        if (this.isIdPassCheck(id, pass)) {
            this.updatePass(id, pass);
            result = true;
        } else {
            result = false;
        }
        return result;
    }


    //MatchPoint 증가
    public void updateMatch(String id) {
        String sql = "update member set matchpoint=matchpoint+1 where id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, id);
            //실행
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt);
        }
    }

    //Likes 증가
    public void updateLikes(String id) {
        String sql = "update member set likes=likes+1 where id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, id);
            //실행
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt);
        }
    }

    public List<MemberDto> getSearchMember(String param) {
        List<MemberDto> list = new ArrayList<MemberDto>();
        String sql = "select * from member where id like '%" + param + "%'" +
                "or name like '%" + param + "%' or phonenum like '%" + param + "%'" +
                "or email like '%" + param + "%'";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
           while(rs.next()) {
                MemberDto dto = new MemberDto();

                dto.setNum(rs.getString("num"));
                dto.setId(rs.getString("id"));
                dto.setName(rs.getString("name"));
                dto.setPhonenum(rs.getString("phonenum"));
                dto.setEmail(rs.getString("email"));
                dto.setIshire(rs.getString("ishire"));
                dto.setLikes(rs.getString("likes"));

                list.add(dto);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt, rs);
        }
        return list;
    }

    public int getMemberCount(String param)
    {
        int total=0;
        String sql = "select count(*) from member where id like '%" + param + "%'" +
                "or name like '%" + param + "%' or phonenum like '%" + param + "%'" +
                "or email like '%" + param + "%'";

        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        conn=db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            rs=pstmt.executeQuery(sql);
            if(rs.next())
                total=rs.getInt(1);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            db.dbClose(conn, pstmt, rs);
        }
        return total;
    }

}
