package data.dao;

import config.ServerConfig;
import data.dto.FavoritesDto;
import db.connect.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavoritesDao {
    MysqlConnect db = new MysqlConnect();

    //insert Favorite
    public FavoritesDto insertFavorites(FavoritesDto dto) {
        String sql = "insert into favorites " +
                "(employeeid, employerid, employeenum, employernum,  createday) " +
                "values (?,?,?,?,now())";
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getEmployeeid());
            pstmt.setString(2, dto.getEmployerid());
            pstmt.setString(3, dto.getEmployeenum());
            pstmt.setString(4, dto.getEmployernum());
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt);
        }

        return getData(dto.getEmployernum(), dto.getEmployeenum());
    }

    public FavoritesDto getData(String jobofferNum, String resumeNum) {
        FavoritesDto dto = new FavoritesDto();
        String sql = "select * from favorites where employernum=? and employeenum=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        conn = db.getMyConnection();

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, jobofferNum);
            pstmt.setString(2, resumeNum);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                dto.setEmployernum(rs.getString("employernum"));
                dto.setEmployerid(rs.getString("employerid"));
                dto.setEmployeenum(rs.getString("employeenum"));
                dto.setEmployeeid(rs.getString("employeeid"));
                dto.setMatchday(rs.getString("matchday"));
                dto.setCreateday(rs.getString("createday"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt, rs);
        }

        return dto;
    }

    public List<FavoritesDto> getAllFavorites() {
        List<FavoritesDto> list = new ArrayList<>();
        String sql = "select * from favorites order by createday desc";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                if (ServerConfig.isTestMode()) {
                    System.out.println(rs.getRow());  //현재 행 넘버 20번쨰에 20.
                }

                FavoritesDto dto = new FavoritesDto();
                dto.setEmployeeid(rs.getString("employeeid"));
                dto.setEmployerid(rs.getString("employerid"));
                dto.setEmployeenum(rs.getString("employeenum"));
                dto.setEmployernum(rs.getString("employernum"));
                dto.setCreateday(rs.getString("createday"));
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

    public List<FavoritesDto> getAllFavorites(String attribute, String param) {
        List<FavoritesDto> list = new ArrayList<>();
        String sql = "select * from favorites where " + attribute + "='" + param + "' order by createday desc";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                if (ServerConfig.isTestMode()) {
                    System.out.println(rs.getRow());  //현재 행 넘버 20번쨰에 20.
                }

                FavoritesDto dto = new FavoritesDto();
                dto.setEmployeeid(rs.getString("employeeid"));
                dto.setEmployerid(rs.getString("employerid"));
                dto.setEmployeenum(rs.getString("employeenum"));
                dto.setEmployernum(rs.getString("employernum"));
                dto.setCreateday(rs.getString("createday"));
                dto.setMatchday(rs.getString("matchday"));
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


    //Favorites 거절/취소
    public void deleteFavorites(String num) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "delete from favorites where num=?";
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

    public void updateMatchday(String joboffernum, String resumenum) {
        String sql = "update favorites set matchday=now() where employeenum=" + resumenum
                + " and employernum=" + joboffernum + "";

        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = db.getMyConnection();

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(conn, pstmt);
        }
    }
}
