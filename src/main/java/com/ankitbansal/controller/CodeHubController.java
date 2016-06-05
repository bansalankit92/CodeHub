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
    	//System.out.println("resp");
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
    	//System.out.println("resp");
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
    
    @RequestMapping(value="/api/searchfilter" ,method=RequestMethod.GET)
    public SubmissionsResponseBody searchSubmissionsByFilter( @RequestParam(value="query") String query,@RequestParam(value="filter") String filter,@RequestParam(value="page", defaultValue="1") String page) {
    	//System.out.println("resp");
    	if(filter==""||filter.isEmpty()||filter==null)
    		return searchSubmissions(query, page);
    	else{
    		
    		if(filter.equals("Time"))
    			return searchSubmissionsByFilterAdv(query, filter, "Memory", page);
    		else if(filter.equals("Compi"))
    			return searchSubmissionsByFilterAdv(query, filter, "Run", page);
    		
 int pageVal=1;
       SubmissionsResponseBody resp=new SubmissionsResponseBody();
       try{
    	   pageVal=Integer.parseInt(page);
    	   resp.setResult(service.getSearchResultsFiltered(query, filter, pageVal));
    	   resp.setCode("200");
    	   resp.setMsg("success");
       } catch (NumberFormatException e) {
    	   resp.setCode("400");
    	   resp.setMsg("Number Format Exception!! Enter only Numeric Values");
       }
       
        return resp;
    }
    } 
    
    @RequestMapping(value="/api/searchfilterAdv" ,method=RequestMethod.GET)
    public SubmissionsResponseBody searchSubmissionsByFilterAdv( @RequestParam(value="query") String query,@RequestParam(value="filter1") String filter1, @RequestParam(value="filter2") String filter2,@RequestParam(value="page", defaultValue="1") String page) {
    	//System.out.println("resp");
    	if(filter1==""||filter1.isEmpty()||filter1==null)
    		return searchSubmissions(query, page);
    	else
    	if(filter2==""||filter2.isEmpty()||filter2==null)
    		return searchSubmissionsByFilter(query, filter1, page);
    	else{
 int pageVal=1;
       SubmissionsResponseBody resp=new SubmissionsResponseBody();
       try{
    	   pageVal=Integer.parseInt(page);
    	   resp.setResult(service.getSearchResultsFilteredAdv(query, filter1, filter2, pageVal));
    	   resp.setCode("200");
    	   resp.setMsg("success");
       } catch (NumberFormatException e) {
    	   resp.setCode("400");
    	   resp.setMsg("Number Format Exception!! Enter only Numeric Values");
       }
       
        return resp;
    }
    } 
    
    @RequestMapping(value="/api/analytics" ,method=RequestMethod.GET)
    public AnalyticsResponseBody analytics(){
    	//System.out.println("resp");
 
    	AnalyticsResponseBody resp=new AnalyticsResponseBody();
      
    	  resp.setSubmissions_per_level(service.getSubmissionsPerLevel());
    	   resp.setTop_2_submissions_attempted(service.getTop2Submissions());
    	  resp.setTop_5_languages_used(service.getTop5Lang());
    	  resp.setTotal_submissions(service.getTotalSubmissions());
      
       
        return resp;
    }
    
    @RequestMapping(value="/home")
    public SubmissionsResponseBody home() {
    	//System.out.println("resp");
    	SubmissionsResponseBody resp=new SubmissionsResponseBody();
    	 resp.setCode("200");
  	   resp.setMsg("good");
     
     
      return resp;
    	
    	}
}