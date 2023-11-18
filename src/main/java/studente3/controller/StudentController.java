package studente3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import studente3.dao.StudentDao;
import studente3.dto.Student;

@Controller
public class StudentController {

	@Autowired
	private StudentDao studentDao;
	
	@RequestMapping("/register")
	public ModelAndView registerStudent() {
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.addObject("student",new Student());
		modelAndView.setViewName("register.jsp");
		return modelAndView;
	}
	
	
	@RequestMapping("/save")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		ModelAndView modelAndView=new ModelAndView();
		studentDao.saveStudent(student);
		List<Student> list=studentDao.getAllStudents();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("display.jsp");
		return modelAndView;
	}
	
	
	@RequestMapping("/delete")
	public ModelAndView deleteStudent(@RequestParam int id) {
		
		ModelAndView modelAndView=new ModelAndView();
		studentDao.deleteStudentById(id);
		
		List<Student> list=studentDao.getAllStudents();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("display.jsp");
		
		return modelAndView;
		
	}
	
	
	@RequestMapping("/edit")
	
	public ModelAndView editStudent(@RequestParam int id) {
		ModelAndView andView=new ModelAndView();
		
		Student student=studentDao.findStudentById(id);
		andView.addObject("student", student);
		andView.setViewName("edit.jsp");
		return andView;
	}
	
	@RequestMapping("/update")
	
	public ModelAndView updateStudent(@ModelAttribute Student student) {
		ModelAndView modelAndView=new ModelAndView();
		studentDao.updateStudent(student);
		
		
		List<Student> list=studentDao.getAllStudents();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("display.jsp");
		
		
		return modelAndView;
	}
	
	
	
	
	
	
	
	
	
}
