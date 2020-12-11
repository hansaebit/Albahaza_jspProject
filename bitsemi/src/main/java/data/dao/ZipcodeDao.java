package data.dao;

import data.dto.ZipcodeDto;
import db.connect.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class ZipcodeDao {
    MysqlConnect db = new MysqlConnect();

    public List<ZipcodeDto> getSearchAddress(String gu) {
        List<ZipcodeDto> list = new Vector<ZipcodeDto>();
        String sql = "select * from zipcode where gusi like ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        conn = db.getMyConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, "%" + gu + "%");
            //실행
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ZipcodeDto dto = new ZipcodeDto();
                dto.setNum(rs.getString("zipcode"));
                dto.setGu(rs.getString("gu"));
                //리스트에 추가
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

    public List<ZipcodeDto> getAllZipcode() {
        List<ZipcodeDto> list = new Vector<ZipcodeDto>();
        String sql = "select * from zipcode order by gu";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        conn = db.getMyConnection();

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ZipcodeDto dto = new ZipcodeDto();
                dto.setNum(rs.getString("num"));
                dto.setGu(rs.getString("gu"));
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
