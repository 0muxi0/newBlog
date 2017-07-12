package com.Lee.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.Lee.dao.PlaylistDao;
import com.Lee.domain.Playlist;

public class PlaylistDaoImpl extends HibernateDaoSupport  implements PlaylistDao {

	//添加歌单
	@Override
	public void add(Playlist plist) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(plist);
	}
	
	
//	通过id查找歌单
	@Override
	public Playlist findById(Integer pid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Playlist.class, pid);
	}

	//删除歌单
	@Override
	public void delete(Playlist plist) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(plist);
	}

//查询歌单个数
	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Playlist";
		List<Long> list =this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

//分页查询歌单
/*	@Override
	public List<Playlist> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Playlist.class);
		List<Playlist> list=this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}*/

//查询所有歌单
	@Override
	public List<Playlist> findAll(Playlist plist) {
		// TODO Auto-generated method stub
		List<Playlist> list = this.getHibernateTemplate().loadAll(Playlist.class);
		return list;
	}



//更新歌单
	@Override
	public void update(Playlist plist) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(plist);
	}

}
