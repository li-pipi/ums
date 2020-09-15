package cn.ekgc.ssm.controller;

import cn.ekgc.ssm.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller("demoController")
public class DemoController {
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/hello")
	public void test01() {
		System.out.println("Hello World");
	}

	@RequestMapping(value = "/hello/miaomiao")
	public void test02() {
		System.out.println("Hello Miao Miao");
	}

	@RequestMapping(value = "/method1", method = RequestMethod.GET)
	public void testMethodGet() throws Exception {
		System.out.println("该方法只能够处理 GET 请求！");
	}

	@RequestMapping(value = "/method1", method = RequestMethod.POST)
	public void testMethodPost() throws Exception {
		System.out.println("该方法只能够处理 POST 请求！");
	}

	@GetMapping("/method02")
	public void testMethodGet02() throws Exception {
		System.out.println("使用 @GetMapping ");
	}

	@PostMapping("/method02")
	public void testMethodPost02() throws Exception {
		System.out.println("使用 @PostMapping ");
	}

	@GetMapping("/param01")
	public void testParameter01(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		System.out.println("name = " + name);
	}

	@GetMapping("/param02")
	public void testParameter02() throws Exception {
		String gender = request.getParameter("gender");
		System.out.println(gender);
	}

	@GetMapping("/param03")
	public void testParameter03(Integer age, boolean flag) throws Exception {
//		String ageStr = request.getParameter("age");
//		// 将 String 转换为 ageStr
//		Integer age = Integer.parseInt(ageStr);
		System.out.println("age = " + age + "\tflag = " + flag);
	}

	@GetMapping("/save01")
	public void saveUser01(String name, String cellphone) throws Exception {
		// 创建 User 对象
		User user = new User();
		user.setName(name);
		user.setCellphone(cellphone);

		System.out.println(user.getName() + "\t" + user.getCellphone());
	}

	@GetMapping("/save02")
	public void saveUser02(User user) throws Exception {
		// 创建 User 对象
//		User user = new User();
//		user.setName(name);
//		user.setCellphone(cellphone);

		System.out.println(user.getName() + "\t" + user.getCellphone());
	}

	@GetMapping("/save03")
	public void saveUser03(User user, boolean flag) throws Exception {
		System.out.println(user.getName() + "\t" + user.getCellphone() + "\tflag" + flag);
	}

	@GetMapping("/forward01")
	public String testForward01() throws Exception {
		return "hello";
	}

	@GetMapping("/forward02")
	public ModelAndView testForward02() throws Exception {
		// ModelAndView 其 Modal 是一个 类似于 Map 集合的结构 ModelMap，其中的数据将会转发到页面
//		ModelMap map = new ModelMap();
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "王仁豪");
		map.put("cellphone", "18691814835");
		return new ModelAndView("hello", map);
	}

	@GetMapping("/forward03")
	public ModelAndView testForward03() throws Exception {
		return new ModelAndView("hello", "name", "王仁豪");
	}

	@GetMapping("/forward04")
	public String testForward04(ModelMap map) throws Exception {
		map.put("name", "王博");
		map.put("cellphone", "18329327519");
		return "hello";
	}

	@GetMapping("/redirect01")
	public ModelAndView testRedirect01() throws Exception {
		// 创建重定向视图对象
		RedirectView view = new RedirectView("forward03");
		return new ModelAndView(view);
	}

	@GetMapping("/redirect02")
	public String testRedirect02() throws Exception {
		return "redirect:forward04";
	}

	@GetMapping("/json")
	@ResponseBody
	public String testJSON() throws Exception {
		return "Happy Ghost Festival For Wang Renhao";
	}
}
