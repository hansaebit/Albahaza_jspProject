package data.dao;

import data.dto.MemberDto;
import db.connect.MysqlConnect;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.Transient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class MemberDaoTest {

    MysqlConnect db = new MysqlConnect();

    @BeforeEach
    void beforeEach() {

    }

    @Test
    void isIdCheck() {
    }

    @Test
    void getSearchAddress() {
    }

    @Test
    void insertMember() {
        for (int i = 0; i < 20; i++) {
            MemberDto dto = new MemberDto(
                    "",
                    "yang" + i,
                    "1234",
                    "yang",
                    String.valueOf((int) Math.random() * 100 + 1),
                    "male",
                    String.format("010-1234-%04d", i),  //공백 채우기.
                    "asdf@gmail.com" + i,
                    "true",
                    String.valueOf((int) Math.random() * 10000),
                    "2020-11-28", //Timestamp.valueOf("2020-11-28"),
                    "0"

            );

            MemberDao dao = new MemberDao();
            dao.insertMember(null);
        }


    }

    @Test
    void getData() {

    }

    @Test
    void getAllData(){
        MemberDao dao = new MemberDao();
        dao.getAllData();
    }

    @Test
    void updateMember() {
    }

    @Test
    void deleteMember() {
    }
}