package service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.junit.Test;

public interface ExcelService {
	public String write(List list);
}
