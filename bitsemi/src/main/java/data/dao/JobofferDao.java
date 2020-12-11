package data.dao;

import data.dto.JobofferDto;
import db.connect.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JobofferDao {
    MysqlConnect db = new MysqlConnect();

    //구인게시판

    //insert - 추가하기
    public void insertJoboffer(JobofferDto dto) {
        String num = dto.getNum();
        String sql = "insert into joboffer (" +
                "id, location, jobtype" +
                ", abletime, introduce, pay" +
                ", writeday, needpeople, applicant" +
                ", xpoint, ypoint, companyname" +
                ", phonenum, term)" +
                "  values (?,?,?, ?,?,?, now() ,?,?,? ,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getId());
            pstmt.setString(2, dto.getLocation());
            pstmt.setString(3, dto.getJobtype());

            pstmt.setString(4, dto.getAbletime());
            pstmt.setString(5, dto.getIntroduce());
            pstmt.setString(6, dto.getPay());

            pstmt.setString(7, dto.getNeedpeople());
            pstmt.setString(8, dto.getApplicant());
            pstmt.setString(9, dto.getXpoint());

            pstmt.setString(10, dto.getYpoint());
            pstmt.setString(11, dto.getCompanyname());
            pstmt.setString(12, dto.getPhonenum());

            pstmt.setString(13, dto.getTerm());

            pstmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt);
        }

    }

    //list - 목록보기 + 페이징처리
    public List<JobofferDto> getAllJoboffer(int start, int perpage) {
        List<JobofferDto> list = new ArrayList<JobofferDto>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from joboffer order by num desc limit ?,?";
        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setInt(1, start);
            pstmt.setInt(2, perpage);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                JobofferDto dto = new JobofferDto();
                dto.setNum(rs.getString("num"));
                dto.setId(rs.getString("id"));
                dto.setCompanyname(rs.getString("companyname"));
                dto.setPhonenum(rs.getString("phonenum"));
                dto.setLocation(rs.getString("location"));

                dto.setJobtype(rs.getString("jobtype"));
                dto.setAbletime(rs.getString("abletime"));
                dto.setIntroduce(rs.getString("introduce"));
                dto.setPay(rs.getString("pay"));
                dto.setWriteday(rs.getString("writeday"));

                dto.setNeedpeople(rs.getString("needpeople"));
                dto.setApplicant(rs.getString("applicant"));
                dto.setXpoint(rs.getString("xpoint"));
                dto.setYpoint(rs.getString("ypoint"));
                dto.setTerm(rs.getString("term"));
                list.add(dto);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt, rs);
        }
        return list;
    }

    //list - 목록보기 + 페이징처리
    public List<JobofferDto> getAllJoboffer(int start, int perpage
            , String jobtype, String term, String abletime) {
        List<JobofferDto> list = new ArrayList<JobofferDto>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = db.getMyConnection();
        int whereCount = 0;

        String sql = "select * from joboffer";

        if ((jobtype != null || term != null || abletime != null)
                && jobtype.length() > 0 || term.length() > 0 || abletime.length() > 0) {
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
        }

        sql += " order by num desc limit ?,?";

        System.out.println("getAllJoboffer sql : " + sql);

        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setInt(1, start);
            pstmt.setInt(2, perpage);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                JobofferDto dto = new JobofferDto();
                dto.setNum(rs.getString("num"));
                dto.setId(rs.getString("id"));
                dto.setCompanyname(rs.getString("companyname"));
                dto.setPhonenum(rs.getString("phonenum"));
                dto.setLocation(rs.getString("location"));

                dto.setJobtype(rs.getString("jobtype"));
                dto.setAbletime(rs.getString("abletime"));
                dto.setIntroduce(rs.getString("introduce"));
                dto.setPay(rs.getString("pay"));
                dto.setWriteday(rs.getString("writeday"));

                dto.setNeedpeople(rs.getString("needpeople"));
                dto.setApplicant(rs.getString("applicant"));
                dto.setXpoint(rs.getString("xpoint"));
                dto.setYpoint(rs.getString("ypoint"));
                dto.setTerm(rs.getString("term"));
                list.add(dto);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt, rs);
        }
        return list;
    }

    //list - 목록보기 + 페이징처리 : only id
    public List<JobofferDto> getAllJoboffer(String id) {
        List<JobofferDto> list = new ArrayList<JobofferDto>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from joboffer where id=? order by num desc";
        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                JobofferDto dto = new JobofferDto();
                dto.setNum(rs.getString("num"));
                dto.setId(rs.getString("id"));
                dto.setCompanyname(rs.getString("companyname"));
                dto.setPhonenum(rs.getString("phonenum"));
                dto.setLocation(rs.getString("location"));

                dto.setJobtype(rs.getString("jobtype"));
                dto.setAbletime(rs.getString("abletime"));
                dto.setIntroduce(rs.getString("introduce"));
                dto.setPay(rs.getString("pay"));
                dto.setWriteday(rs.getString("writeday"));

                dto.setNeedpeople(rs.getString("needpeople"));
                dto.setApplicant(rs.getString("applicant"));
                dto.setXpoint(rs.getString("xpoint"));
                dto.setYpoint(rs.getString("ypoint"));

                list.add(dto);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt, rs);
        }
        return list;
    }


    //delete
    public void deleteJoboffer(String num) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "delete from joboffer where num=?";
        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            pstmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt);
        }
    }

    //내용보기 - num에 해당하는 dto가져오기
    public JobofferDto getData(String num) {
        JobofferDto dto = new JobofferDto();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from joboffer where num=?";

        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                dto.setNum(rs.getString("num"));
                dto.setId(rs.getString("id"));
                dto.setCompanyname(rs.getString("companyname"));
                dto.setPhonenum(rs.getString("phonenum"));
                dto.setLocation(rs.getString("location"));

                dto.setJobtype(rs.getString("jobtype"));
                dto.setAbletime(rs.getString("abletime"));
                dto.setIntroduce(rs.getString("introduce"));
                dto.setPay(rs.getString("pay"));
                dto.setWriteday(rs.getString("writeday"));

                dto.setNeedpeople(rs.getString("needpeople"));
                dto.setApplicant(rs.getString("applicant"));
                dto.setXpoint(rs.getString("xpoint"));
                dto.setYpoint(rs.getString("ypoint"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt, rs);
        }

        return dto;
    }

    //update - 수정하기
    public void updateJoboffer(JobofferDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "update joboffer set companyname=?,phonenum=?,jobtype=?,abletime=?" +
                ",pay=?,needpeople=?,location=?,introduce=?,xpoint=?,ypoint=? where num=?";

        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getCompanyname());
            pstmt.setString(2, dto.getPhonenum());
            pstmt.setString(3, dto.getJobtype());
            pstmt.setString(4, dto.getAbletime());
            pstmt.setString(5, dto.getPay());

            pstmt.setString(6, dto.getNeedpeople());
            pstmt.setString(7, dto.getLocation());
            pstmt.setString(8, dto.getIntroduce());
            pstmt.setString(9, dto.getXpoint());
            pstmt.setString(10, dto.getYpoint());

            pstmt.setString(11, dto.getNum());
            pstmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
        String sql = "select count(*) from joboffer";
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

    public int getTotalCount(String jobtype, String term, String abletime) {
        int tot = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        conn = db.getMyConnection();
        String sql = "select count(*) from joboffer";
        int whereCount = 0;

        if ((jobtype != null || term != null || abletime != null)
                && jobtype.length() > 0 || term.length() > 0 || abletime.length() > 0) {
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
        }

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

    public List<JobofferDto> getSearchJoboffer(String param) {
        List<JobofferDto> list = new ArrayList<JobofferDto>();
        String sql = "select * from joboffer where id like '%" + param + "%'" +
                "or location like '%" + param + "%' or jobtype like '%" + param + "%'" +
                "or abletime like '%" + param + "%' or companyname like '%" + param + "%'" +
                "or phonenum like '%" + param + "%' or term like '%" + param + "%'";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        System.out.println("sql:" + sql);

        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                JobofferDto dto = new JobofferDto();
                dto.setNum(rs.getString("num"));
                dto.setId(rs.getString("id"));
                dto.setLocation(rs.getString("location"));
                dto.setJobtype(rs.getString("jobtype"));
                dto.setAbletime(rs.getString("abletime"));
                dto.setCompanyname(rs.getString("companyname"));
                dto.setPhonenum(rs.getString("phonenum"));
                dto.setTerm(rs.getString("term"));

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

    public List<String> getApplicantList(String num) {
        List<String> list = null;
        String sql = "select applicant from joboffer where num=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String applicant = rs.getString("applicant");
                if (applicant != null) {
                    applicant = applicant.substring(1, applicant.length() - 2).replace(" ", "");
                    System.out.println("applicant : " + applicant);
                    //괄호 제거하고 "," 로 구별하여 배열로 변환 -> 리스트로 변
                    list = new ArrayList<>(Arrays.asList(applicant.split(",")));
                    System.out.println("list : " + list);
                }
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt, rs);
        }

        return list;
    }

    public void setApplicantList(String num, String applicant) {
        String sql = "update joboffer set applicant=? where num=?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, applicant);
            pstmt.setString(2, num);
            pstmt.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt);
        }
    }
}
