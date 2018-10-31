package com.crud.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.crud.bean.UserBean;
//import com.crud.service.ICombatService;
//import com.jcombat.service.IRegisterService;
//import com.jcombat.service.IRetrieveService;
import com.crud.service.ICombatService;
import com.crud.service.IRegisterService;
import com.crud.service.IRetrieveService;

//import net.sf.json.JSONObject;
//import com.jcombat.dao.*;
 
@Controller
public class UserController
{
	@Autowired
	 public IRegisterService registerService;
	@Autowired
	 public ICombatService combatService;
	@Autowired
	public IRetrieveService retrieveService;
	
	//Register
	@RequestMapping(value="/toRegister")//, method = RequestMethod.GET)
	public String toRegister(Model model)
	{
		// Make sure to add model of UserBean in which login 
		// userName and password will be stored from the login form 
		model.addAttribute("userBean", new UserBean());
		// "login" will be resolved to login.jsp
		// where login-form is presented to user
 		return "register";
	}
 
	@RequestMapping(value="/doRegister")
	public RedirectView doRegister(@ModelAttribute @Valid UserBean userBean,BindingResult result)
	{
		ModelAndView view = new ModelAndView("register");
		// If input bean does not have any validation error then proceed
		if(!result.hasFieldErrors())
		{
			if(registerService.insert(userBean) != null)
			{}
				
		}	
		RedirectView rv = new RedirectView();
        rv.setUrl("welcomes");
        return rv;
	}
	
	@RequestMapping(value="/welcomes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView getvalues(HttpServletRequest request, HttpServletResponse response, @ModelAttribute @Valid UserBean userBean,BindingResult result, HttpSession session)
	{
		List<UserBean> users=retrieveService.findAllUsers(userBean);
		
		return new ModelAndView("welcomes","user", users);
		
	}
	
	@RequestMapping(value="/delete/{username}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable String username, HttpServletRequest request, HttpServletResponse response, @ModelAttribute @Valid UserBean userBean,BindingResult result)
	{
		retrieveService.delete(username);
		return new ModelAndView("redirect:/welcomes");
		
	}
	@RequestMapping(value="/update/{username}")
	public ModelAndView getelement(@PathVariable String username, HttpServletRequest request, HttpServletResponse response, @ModelAttribute @Valid UserBean userBean,BindingResult result,HttpSession session)
	{
		UserBean user=retrieveService.getelement(username);
		session.setAttribute("username", username);
		
		return new ModelAndView("editdetails","command",user);
		
	}
	@RequestMapping(value="/editdetail", method = RequestMethod.POST)
	public ModelAndView editdetails(@ModelAttribute("userBean") UserBean userBean, HttpSession session)
	{
		String username = null; 
		username = session.getAttribute("username").toString();
		userBean.setUsername(username);
		retrieveService.updates(userBean);
		return new ModelAndView("redirect:/welcomes");
	}
	
}
	
	
	
/**	
	
	//login
	@RequestMapping(value="/toLogin")//, method = RequestMethod.GET)
	public String toLogin(Model model)
	{
		// Make sure to add model of UserBean in which login 
		// userName and password will be stored from the login form 
		model.addAttribute("userBean", new UserBean());
		// "login" will be resolved to login.jsp
		// where login-form is presented to user
		return "login";
	}
 
	@RequestMapping(value="/doLogin")//, method = RequestMethod.GET)
	public ModelAndView doLogin(@ModelAttribute @Valid UserBean userBean,BindingResult result, HttpServletRequest request, HttpServletResponse response)
	{
		
		ModelAndView view = new ModelAndView("login");
		// If input bean does not have any validation error then proceed
		if(!result.hasFieldErrors())
		{
			// If not a valid user then add error
			// else proceed to user welcome page
			if(combatService.authenticateUser(userBean)) 
			{
				List<UserBean> users=retrieveService.findAllUsers(userBean);
				return new ModelAndView("welcomes","users", users);
				
			} 
		}
		return view;
		}
}
	**/
	/**@RequestMapping(value="/welcomes")
	public ResponseEntity<List<UserBean>> handleRequest(HttpServletRequest request, HttpServletResponse response, @ModelAttribute @Valid UserBean userBean,BindingResult result)
	{
		List<UserBean> users=retrieveService.findAllUsers(userBean);
		if(users.isEmpty())
		{
            return new ResponseEntity<List<UserBean>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
		
        return new ResponseEntity<List<UserBean>>(users, HttpStatus.OK);
	}
}
**/