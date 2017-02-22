package service;

import java.util.List;

import po.Announcement;

public interface AnnouncementService {
	public List<Announcement> getAn();
	public Integer updateAn(Announcement an);
	public List<Announcement> selectAnByAcademy( String academy);
}
