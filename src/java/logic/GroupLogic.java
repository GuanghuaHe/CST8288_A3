package logic;

import java.util.List;

import dao.GroupDAO;
import dao.GroupDAOImpl;
import dto.Group;


public class GroupLogic {
	private GroupDAO groupDAO = new GroupDAOImpl();
	/**
	 * create a Group and add it into data base
	 * @param group
	 * @return
	 */
	public boolean addGroup(Group group) {
		return groupDAO.add(group) > 0;
	}
	/**
	 * get all group
	 * @return
	 */
	public List<Group> getAllGroup(){
		return groupDAO.getAll();
	}
	
	/**
	 * get a group by id
	 */
	public Group getGroupById(int id) {
		return groupDAO.getById(id);
	}
	
	/**
	 * update a group
	 */
	public boolean updateGroup(Group group) {
		return groupDAO.update(group) > 0;
	}
	
	/**
	 * delete a group
	 */
	public boolean deleteGroup(int id) {
		return groupDAO.delete(id) > 0;
	}
	
	
	
}
