package service.impl;

import java.util.List;

import mapper.AnnouncementMapper;

import org.springframework.beans.factory.annotation.Autowired;

import po.Announcement;
import po.AnnouncementExample;
import service.AnnouncementService;

public class AnnouncementServiceImpl  implements AnnouncementService{
	@Autowired
	private AnnouncementMapper announcementMapper;
	@Override
	public List<Announcement> getAn() {
		AnnouncementExample example = new AnnouncementExample();
		AnnouncementExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause("AN_CRE_DATE desc");
		criteria.andAnCreDateIsNotNull();
		criteria.andAnCreIdIsNotNull();
		//criteria
		// TODO Auto-generated method stub
		//criteria.andAnCreDateIsNotNull();
		List <Announcement> list = announcementMapper.selectByExample(example);
		System.out.println(list);
		return list;
	}
	@Override
	public Integer updateAn(Announcement an) {
		// TODO Auto-generated method stub
//		AnnouncementExample example = new AnnouncementExample();
//		example.
//		example
		try{
		if (!announcementMapper.selectByPrimaryKey(an.getAnId()).equals(null))
		return announcementMapper.updateByPrimaryKeySelective(an);
		else
			return announcementMapper.insertSelective(an);
		}
		catch (NullPointerException e){
			AnnouncementExample example2 = new AnnouncementExample();
			AnnouncementExample.Criteria criteria3 = example2.createCriteria();
			criteria3.andAnIdIsNotNull();
			criteria3.andAnAcademyEqualTo(an.getAnAcademy());
			int count = announcementMapper.countByExample(example2);
			if (count>=5)
			{
//			if ()
				/**
				 * 还是要知道在数据库里全校是怎么表示的
				 */
			AnnouncementExample example = new AnnouncementExample();
			AnnouncementExample.Criteria criteria = example.createCriteria();
			AnnouncementExample.Criteria criteria2 = example.createCriteria();
			criteria.andAnIdIsNotNull();
			criteria.andAnAcademyEqualTo(an.getAnAcademy());
			example.setOrderByClause("AN_CRE_DATE");
//			 int anId;
			 an.setAnId(announcementMapper.selectByExample(example).get(0).getAnId());
			 return announcementMapper.updateByPrimaryKey(an);
			}
			else
			{
//				an.setAnId(count+1);
				/**
				 * 不知道插入没有Id会不会出错。。
				 */
				return announcementMapper.insertSelective(an);
				
			}
		}
	}
	@Override
	public List<Announcement> selectAnByAcademy(String academy) {
		AnnouncementExample example = new AnnouncementExample();
		AnnouncementExample.Criteria criteria = example.createCriteria();
		criteria.andAnAcademyEqualTo(academy);
		System.out.println(academy);
		return announcementMapper.selectByExample(example);
	}
}
