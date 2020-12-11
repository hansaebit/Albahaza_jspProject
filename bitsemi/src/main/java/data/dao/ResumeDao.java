package data.dao;

import data.dto.ResumeDto;
import db.connect.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResumeDao {
    MysqlConnect db = new MysqlConnect();

    //insert
    public void insertResume(ResumeDto dto) {
        String sql = "insert into resume " +
                "(id, location, jobtype, abletime, introduce, career, writeday, name, phonenum, isclose, term) " +
                " values (?,?,?,?,?,?,now(),?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, dto.getId());
            pstmt.setString(2, dto.getLocation());
            pstmt.setString(3, dto.getJobtype());
            pstmt.setString(4, dto.getAbletime());
            pstmt.setString(5, dto.getIntroduce());
            pstmt.setString(6, dto.getCareer());
            pstmt.setString(7, dto.getName());
            pstmt.setString(8, dto.getPhonenum());
            pstmt.setString(9, dto.getIsclose());
            pstmt.setString(10, dto.getTerm());


            //실행
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt);
        }
    }

    //내용보기 - num에 해당하는 dto가져오기
    public ResumeDto getResumeData(String num) {
        ResumeDto dto = new ResumeDto();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from resume where num=?";

        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                dto.setNum(rs.getString("num"));
                dto.setId(rs.getString("id"));
                dto.setName(rs.getString("name"));
                dto.setPhonenum(rs.getString("phonenum"));
                dto.setLocation(rs.getString("location"));
                dto.setJobtype(rs.getString("jobtype"));
                dto.setAbletime(rs.getString("abletime"));
                dto.setIntroduce(rs.getString("introduce"));
                dto.setCareer(rs.getString("career"));
                dto.setIsclose(rs.getString("isclose"));
                dto.setWriteday(rs.getString("writeday"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt, rs);
        }
        return dto;
    }

    //내용보기 - id 해당하는 dto가져오기
    public ResumeDto getResumeDataById(String id) {
        ResumeDto dto = new ResumeDto();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from resume where id=?";

        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                dto.setNum(rs.getString("num"));
                dto.setId(rs.getString("id"));
                dto.setName(rs.getString("name"));
                dto.setPhonenum(rs.getString("phonenum"));
                dto.setLocation(rs.getString("location"));
                dto.setJobtype(rs.getString("jobtype"));
                dto.setAbletime(rs.getString("abletime"));
                dto.setIntroduce(rs.getString("introduce"));
                dto.setCareer(rs.getString("career"));
                dto.setIsclose(rs.getString("isclose"));
                dto.setWriteday(rs.getString("writeday"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt, rs);
        }
        return dto;
    }


    //게시글 목록 + 페이징처리
    public List<ResumeDto> getAllResume(int start, int perpage) {
        List<ResumeDto> list = new ArrayList<ResumeDto>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from resume order by num desc limit ?,?";
        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setInt(1, start);
            pstmt.setInt(2, perpage);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ResumeDto dto = new ResumeDto();

                dto.setNum(rs.getString("num"));
                dto.setId(rs.getString("id"));
                dto.setLocation(rs.getString("location"));
                dto.setJobtype(rs.getString("jobtype"));
                dto.setAbletime(rs.getString("abletime"));

                dto.setIntroduce(rs.getString("introduce"));
                dto.setCareer(rs.getString("career"));
                dto.setWriteday(rs.getString("writeday"));
                dto.setName(rs.getString("name"));
                dto.setPhonenum(rs.getString("phonenum"));

                dto.setIsclose(rs.getString("isclose"));
                dto.setTerm(rs.getString("term"));

                list.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("sql 오류:" + e.getMessage());
        } finally {
            db.dbClose(conn, pstmt, rs);
        }
        return list;
    }

    //게시글 목록 + 페이징처리
    public List<ResumeDto> getAllResume(
            int start, int perpage,
            String jobtype, String term, String abletime, String location) {
        List<ResumeDto> list = new ArrayList<ResumeDto>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from resume";
        conn = db.getMyConnection();
        int whereCount = 0;

        if ((jobtype != null || term != null || abletime != null || location != null)
                && jobtype.length() > 0 || term.length() > 0 || abletime.length() > 0 || location.length() > 0) {
            sql += " where ";
            if (jobtype != null && jobtype.length() > 0) {
                sql += String.format("jobtype='%s' ", jobtype);
                whereCount++;
            }
            if (term != null && term.length() > 0) {
                if (whereCount > 0) {
                    sql += "and ";
                }
                sql += String.format("term='%s' ", term);
                whereCount++;
            }
            if (abletime != null && abletime.length() > 0) {
                if (whereCount > 0) {
                    sql += "and ";
                }
                sql += String.format("abletime='%s' ", abletime);
            }
            if (location != null && location.length() > 0) {
                if (whereCount > 0) {
                    sql += "and ";
                }
                sql += String.format("location='%s' ", location);
            }
        }

        sql += " order by num desc limit ?,?";

        System.out.println("getAllResume sql : " + sql);
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setInt(1, start);
            pstmt.setInt(2, perpage);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ResumeDto dto = new ResumeDto();

                dto.setNum(rs.getString("num"));
                dto.setId(rs.getString("id"));
                dto.setLocation(rs.getString("location"));
                dto.setJobtype(rs.getString("jobtype"));
                dto.setAbletime(rs.getString("abletime"));

                dto.setIntroduce(rs.getString("introduce"));
                dto.setCareer(rs.getString("career"));
                dto.setWriteday(rs.getString("writeday"));
                dto.setName(rs.getString("name"));
                dto.setPhonenum(rs.getString("phonenum"));

                dto.setIsclose(rs.getString("isclose"));
                dto.setTerm(rs.getString("term"));

                list.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("sql 오류:" + e.getMessage());
        } finally {
            db.dbClose(conn, pstmt, rs);
        }
        return list;
    }

    //id 에 따른 이력서 리스트.
    public List<ResumeDto> getAllResume(String id) {
        List<ResumeDto> list = new ArrayList<ResumeDto>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from resume where id=? order by num desc";
        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ResumeDto dto = new ResumeDto();

                dto.setNum(rs.getString("num"));
                dto.setId(rs.getString("id"));
                dto.setName(rs.getString("name"));
                dto.setPhonenum(rs.getString("phonenum"));
                dto.setLocation(rs.getString("location"));
                dto.setJobtype(rs.getString("jobtype"));
                dto.setAbletime(rs.getString("abletime"));
                dto.setIntroduce(rs.getString("introduce"));
                dto.setCareer(rs.getString("career"));
                dto.setWriteday(rs.getString("writeday"));
                dto.setTerm(rs.getString("term"));

                list.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("sql 오류:" + e.getMessage());
        } finally {
            db.dbClose(conn, pstmt, rs);
        }
        return list;
    }

    //update
    public void updateResume(ResumeDto dto) {
        String sql = "update resume set name=?, phonenum=?, location=?, jobtype=?, " +
                "abletime=?, introduce=?, career=? ,isclose=?, term=? where num=?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getPhonenum());
            pstmt.setString(3, dto.getLocation());
            pstmt.setString(4, dto.getJobtype());
            pstmt.setString(5, dto.getAbletime());
            pstmt.setString(6, dto.getIntroduce());
            pstmt.setString(7, dto.getCareer());
            pstmt.setString(8, dto.getIsclose());
            pstmt.setString(9, dto.getTerm());
            pstmt.setString(10, dto.getNum());

            //실행
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt);
        }
    }

    //delete
    public void deleteResume(String num) {
        String sql = "delete from resume where num=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, num);
            //실행
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt);
        }
    }

    //글 전체개수 출력하기
    public int getTotalCount() {
        int tot = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select count(*) from resume";
        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next())
                tot = rs.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt, rs);
        }
        return tot;
    }

    //글 전체개수 출력하기
    public int getTotalCount(String jobtype, String term, String abletime, String location) {
        int tot = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select count(*) from resume";
        conn = db.getMyConnection();
        int whereCount = 0;

        if ((jobtype != null || term != null || abletime != null || location != null)
                && jobtype.length() > 0 || term.length() > 0 || abletime.length() > 0 || location.length() > 0) {
            sql += " where ";
            if (jobtype != null && jobtype.length() > 0) {
                sql += String.format("jobtype='%s' ", jobtype);
                whereCount++;
            }
            if (term != null && term.length() > 0) {
                if (whereCount > 0) {
                    sql += "and ";
                }
                sql += String.format("term='%s' ", term);
                whereCount++;
            }
            if (abletime != null && abletime.length() > 0) {
                if (whereCount > 0) {
                    sql += "and ";
                }
                sql += String.format("abletime='%s' ", abletime);
            }
            if (location != null && location.length() > 0) {
                if (whereCount > 0) {
                    sql += "and ";
                }
                sql += String.format("location='%s' ", location);
            }
        }

//        sql += " order by num desc limit ?,?";

        System.out.println("getTotalCount sql : " + sql);

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next())
                tot = rs.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt, rs);
        }
        return tot;
    }

    public List<ResumeDto> getSearchResume(String param) {
        List<ResumeDto> list = new ArrayList<ResumeDto>();
        String sql = "select * from resume where id like '%" + param + "%'" +
                "or location like '%" + param + "%' or jobtype like '%" + param + "%'" +
                "or abletime like '%" + param + "%' or name like '%" + param + "%'" +
                "or phonenum like '%" + param + "%' or term like '%" + param + "%'";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ResumeDto dto = new ResumeDto();

                dto.setNum(rs.getString("num"));
                dto.setId(rs.getString("id"));
                dto.setName(rs.getString("name"));
                dto.setPhonenum(rs.getString("phonenum"));
                dto.setLocation(rs.getString("location"));
                dto.setJobtype(rs.getString("jobtype"));
                dto.setIsclose(rs.getString("isclose"));

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
}
