package org.dao;

import java.util.List;

import org.model.Cjb;

/**
 * 
 * @ClassName: CjDao
 * @Description: 学生成绩管理功能Dao
 * @author litengbin
 * @date 2017年6月12日
 * 
 */
public interface CjDao {
	/**
	 * 
	 * @Title: getXsCj
	 * @Description: 成绩信息录入
	 * @param @param xh
	 * @param @param kch
	 * @param @return 参数
	 * @return Cjb 返回类型
	 * @throws
	 */
	public Cjb getXsCj(String xh, String kch);// 根据学号和课程号查询学生成绩

	/**
	 * 
	 * @Title: saveorupdateCj
	 * @Description: 录入学生成绩
	 * @param @param cj 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void saveorupdateCj(Cjb cj);// 录入学生成绩

	/**
	 * 
	 * @Title: findAllCj
	 * @Description: 学生成绩查询
	 * @param @param pageNow
	 * @param @param pageSize
	 * @param @return 参数
	 * @return List 返回类型
	 * @throws
	 */
	public List findAllCj(int pageNow, int pageSize);// 分页显示所有学生成绩

	/**
	 * 
	 * @Title: findCjSize
	 * @Description: 成绩记录总数
	 * @param @return 参数
	 * @return int 返回类型
	 * @throws
	 */
	public int findCjSize();// 查询一共多少条成绩记录

	/**
	 * 
	 * @Title: getXsCjList
	 * @Description: 查看某个学生的成绩表
	 * @param @param xh
	 * @param @return 参数
	 * @return List 返回类型
	 * @throws
	 */
	public List getXsCjList(String xh);// 获取某学生的成绩列表

	/**
	 * 
	 * @Title: deleteCj
	 * @Description: 删除学生成绩
	 * @param @param xh
	 * @param @param kch 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteCj(String xh, String kch);// 根据学好和课程号删除学生成绩

	/**
	 * 
	 * @Title: deleteOneXsCj
	 * @Description: 删除学生成绩
	 * @param @param xh 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteOneXsCj(String xh);// 删除某学生的成绩
	/**
	 * 
	    * @Title: updateKcList  
	    * @Description: 更新该课程号的学生获得学分
	    * @param @param kch
	    * @param @param xf    参数  
	    * @return void    返回类型  
	    * @throws
	 */
	public void updateKcList(String kch, int xf);// 更新该课程号的学生获得学分
	/**
	 * 
	    * @Title: getXsCjList1  
	    * @Description: 根据课程号获取学生列表
	    * @param @param kch
	    * @param @return    参数  
	    * @return List    返回类型  
	    * @throws
	 */
	public List getXsCjList1(String kch);
	
	/**
	 * 
	    * @Title: deleteKcList  
	    * @Description: 更新该课程号的学生获得学分
	    * @param @param kch  参数  
	    * @return void    返回类型  
	    * @throws
	 */
	public void deleteKcList(String kch);// 删除该课程号的学生列表的学分
}
