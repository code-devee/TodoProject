package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.TodoEntity;

public class TodoDAO {
	private Connection conn;

	public TodoDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addTodo(TodoEntity entity) {
		try {
			String add = "insert into tb_todo(name,todo,status) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(add);
			ps.setString(1, entity.getNameString());
			ps.setString(2, entity.getTodoString());
			ps.setString(3, entity.getStatuString());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public List<TodoEntity> getList() {
		List<TodoEntity> list = new ArrayList<TodoEntity>();
		TodoEntity t = null;
		
		try {
			String data = "SELECT * FROM todo.tb_todo";
			PreparedStatement ps = conn.prepareStatement(data);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				t = new TodoEntity();
				
				t.setId(rs.getInt(1));
				t.setNameString(rs.getString(2));
				t.setTodoString(rs.getString(3));
				t.setStatuString(rs.getString(4));
				
				list.add(t);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public TodoEntity getById(int id) {
		TodoEntity t = null;
		try {
			String sqlString = "SELECT * FROM todo.tb_todo where id=?";
			PreparedStatement ps = conn.prepareStatement(sqlString);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				t = new TodoEntity();
				
				t.setId(rs.getInt(1));
				t.setNameString(rs.getString(2));
				t.setTodoString(rs.getString(3));
				t.setStatuString(rs.getString(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	public boolean editTodo(TodoEntity entity) {
		try {
			String sql = "UPDATE todo.tb_todo SET name = ?,todo = ?,status = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,entity.getNameString());
			ps.setString(2, entity.getTodoString());
			ps.setString(3, entity.getStatuString());
			ps.setInt(4, entity.getId());
			ps.executeUpdate();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteTodo(int id) {
		try {
			String sql = "delete from todo.tb_todo where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
