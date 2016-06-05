package com.ankitbansal.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ankitbansal.output.AnalyticsResponseBody;
import com.ankitbansal.output.SubmissionsResponseBody;
import com.ankitbansal.services.CodehubServicesImpl;
import com.ankitbansal.services.ICodehubservices;


@RestController
public class CodeHubController {
 ICodehubservices service=new CodehubServicesImpl();
    @RequestMapping(value="/api/list" ,method=RequestMethod.GET)
    public SubmissionsResponseBody submissionslist( @RequestParam(value="page", defaultValue="1") String page) {
    	System.out.println("resp");
 int pageVal=1;
       SubmissionsResponseBody resp=new SubmissionsResponseBody();
       try{
    	   pageVal=Integer.parseInt(page);
    	   resp.setResult(service.getSubmissions(pageVal));
    	   resp.setCode("200");
    	   resp.setMsg("success");
       } catch (NumberFormatException e) {
    	   resp.setCode("400");
    	   resp.setMsg("Number Format Exception!! Enter only Numeric Values");
       }
       
        return resp;
    }
    
    
    @RequestMapping(value="/api/search" ,method=RequestMethod.GET)
    public SubmissionsResponseBody searchSubmissions( @RequestParam(value="query") String query,@RequestParam(value="page", defaultValue="1") String page) {
    	System.out.println("resp");
 int pageVal=1;
       SubmissionsResponseBody resp=new SubmissionsResponseBody();
       try{
    	   pageVal=Integer.parseInt(page);
    	   resp.setResult(service.getSearchResult(query, pageVal));
    	   resp.setCode("200");
    	   resp.setMsg("success");
       } catch (NumberFormatException e) {
    	   resp.setCode("400");
    	   resp.setMsg("Number Format Exception!! Enter only Numeric Values");
       }
       
        return resp;
    }
    
    
    @RequestMapping(value="/api/analytics" ,method=RequestMethod.GET)
    public AnalyticsResponseBody analytics(){
    	System.out.println("resp");
 
    	AnalyticsResponseBody resp=new AnalyticsResponseBody();
      
    	  resp.setSubmissions_per_level(service.getSubmissionsPerLevel());
    	   resp.setTop_2_submissions_attempted(service.getTop2Submissions());
    	  resp.setTop_5_languages_used(service.getTop5Lang());
    	  resp.setTotal_submissions(service.getTotalSubmissions());
      
       
        return resp;
    }
    
    @RequestMapping(value="/home")
    public SubmissionsResponseBody home() {
    	System.out.println("resp");
    	SubmissionsResponseBody resp=new SubmissionsResponseBody();
    	 resp.setCode("200");
  	   resp.setMsg("good");
     
     
      return resp;
    	
    	}
}