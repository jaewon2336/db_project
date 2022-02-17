package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// INSERT
public class DBEx06 {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB ����Ϸ�");

			String sql = "INSERT INTO userTbl(id, username, password, gender) VALUES(?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 7); // ����ǥ ����, ��
			pstmt.setString(2, "there");
			pstmt.setString(3, "1234");
			pstmt.setString(4, "��");
// 			ResultSet rs = pstmt.executeQuery(); // SELECT
//			���� -1, ���� row ����, �ƹ� ��ȭ������ 0
//			ex) DELETE -> 7�� ID ���� �� ���� : 0
//			ex) DELETE -> 6�� ID 1�� ���� : 1
//			ex) DELETE -> ���� ���� ��ü �� ���� : 6
//			�ᱹ 0���� ũ�� ������ ����
//			executeUpdate�� ���ο� COMMIT�� �����Ѵ�.
			int result = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE

			if (result > 0) {
				System.out.println("����"); // 1
			} else {
				System.out.println("����"); // 0
			}

		} catch (Exception e) { // -1 �����ϸ� if�� Ÿ���ʰ� �ٷ� catch�� ź��.
			e.printStackTrace();
		}

	}
}