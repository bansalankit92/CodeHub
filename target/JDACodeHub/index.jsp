<!DOCTYPE html>
<html lang="en">
    <head>
    
        <meta charset="utf-8"/>
        <meta name="author" content="Ankit Bansal"/>
        <meta name="description" content="My Personal Resume Interactive Site"/>
        <meta name="keywords" content=""/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
	<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/8.9.1/styles/github.min.css">
	
	<style>
	
	#navbar{
		color:#003380;
	background-color:#003380;
//	height:70px;
	}
	
	
	</style>
	</head>
	
	
<body ng-app="app" ng-controller="CodehubController">

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">jda.codehub Searching Made Easy..</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                     <a> <span>Ankit Bansal</span> - Mob No: <span>9762907853</span> mailId: <span>bansal.ankit92@gmail.com </span></a>
                    </li>
                   
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <!-- Blog Entries Column -->
            <div class="col-md-8">

                <br/><br/><br/>
 				<div class="well">
                    <h4>Search Submissions </h4>
                    <div class="input-group">
                        <input ng-model="search" type="text" class="form-control" placeholder="Title, Level, Language "  my-enter ="getSearchSub()">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button" ng-click="getSearchSub();">
                                <span class="glyphicon glyphicon-search"></span>
                        </button>
                        </span>
                    </div>
                    <!-- /.input-group -->
                </div>
             <!-- Pager -->
                <ul class="pager" ng-show="pager">
                    <li class="previous">
                        <a><button  style="background  : none; border:none;" ng-click="previous();">&larr; Previous</button></a>
                    </li>
                    <span style="color:red;">Current Page: &nbsp;{{pageval}}</span>
                    <li class="next">
                        <a><button  style="background  : none; border:none;" ng-click="next();">Next &rarr;</button></a>
                    </li>
                </ul>
             <div class="well" ng-init="i=1" ng-repeat="x in submissions">
                 <div >
                    <h4> <strong>{{x.title}}</strong></h4>
                    <span><strong> Language:</strong>&nbsp;{{x.language}}</span> <br/><span><strong>Status:</strong>&nbsp;{{x.status}}</span>
                   <br/><span style="color:red"><strong>Difficulty:</strong>&nbsp;{{x.metadata}}</span>
                  <br> <button type="button" class="btn btn-info" data-toggle="collapse" data-target="{{'#codeCollapse'+$index}}">See Code</button>
  
                    <div id="{{'codeCollapse'+$index}}"  class="collapse" hljs compile="true" language="c">{{x.source}}
                 </div>
                 </div>
             </div>
             
                <hr>

                <!-- Pager -->
                <ul class="pager" ng-show="pager">
                    <li class="previous">
                        <a><button  style="background  : none; border:none;" ng-click="previous();">&larr; Previous</button></a>
                    </li>
                    <span style="color:red;">Current Page: &nbsp;{{pageval}}</span>
                    <li class="next">
                        <a><button  style="background  : none; border:none;" ng-click="next();">Next &rarr;</button></a>
                    </li>
                </ul>

            </div>

            <!-- Blog Sidebar Widgets Column -->
            <div class="col-md-4">
<br><br><br><br>
<h3>Use FIlters</h3>
                <div class="well">
                    <form role="form">
                    
					    <div class="radio">
					      <label><input type="radio"  ng-model="radio" value="Accepted" name="optradio">Accepted</label>
					    </div>
					    <div class="radio">
					      <label><input type="radio" ng-model="radio" value="Skipped" name="optradio">Skipped</label>
					    </div>
					    <div class="radio">
					      <label><input type="radio" ng-model="radio" value="Time" name="optradio">Memory/Time Limit Exceeded</label>
					    </div>
					    <div class="radio">
					      <label><input type="radio" ng-model="radio" value="Compi" name="optradio">Runtime/Compilation Error</label>
					    </div>
					    <div class="radio">
					      <label><input type="radio" ng-model="radio" value="Wrong answer" name="optradio">Wrong Answer</label>
					    </div>
					  </form>
	                    
                </div>

                <h3>Statistical Analysis</h3>
                <div class="well">
                    <h4>Top 5 languages</h4>
	                   <ul>
	                    <li ng-repeat="x in top5lang">
	                    	<strong>{{x.title}} </strong>:<span>{{x.cnt}}</span>
	                    </li>
	                    </ul> 
	                    <br/>
	                    <h4>Top 2 submission Attempted</h4>
	                   <ul>
	                    <li ng-repeat="x in top2Sub">
	                    	<strong>{{x.title}} </strong>:<span>{{x.cnt}}</span>
	                    </li>
	                    </ul> 
	                     <br/>
	                    <h4>Number of Submissions per level</h4>
	                    <strong>Easy </strong>:<span>{{easy}}</span><br/>
	                    <strong>Medium </strong>:<span>{{medium}}</span><br/>
	                    <strong>Hard </strong>:<span>{{hard}}</span><br/>
	                    <br/>
	                    <strong>Total submission </strong>:<span>{{totalCount}}</span>
	                    
                </div>

                <!-- Side Widget Well
                <div class="well">
                    <h4>Side Widget Well</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore, perspiciatis adipisci accusamus laudantium odit aliquam repellat tempore quos aspernatur vero.</p>
                </div>
 -->
            </div>

        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Ankit Bansal 2016</p>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </footer>

    </div>
</body>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.min.js"></script>
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/typed.js/1.1.1/typed.min.js"></script>
    
        <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.6/angular.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.4.0/highlight.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-highlightjs/0.6.1/angular-highlightjs.js"></script>
	<script type="text/javascript">
	
	var app=angular.module("app",['hljs'])
		.controller("CodehubController",function($scope,$http,$location,$interpolate, $window){
			//alert($location.absUrl());
			$scope.top5lang=[];
			 $scope.top2Sub=[];
			$scope.radio="";
			 var page=1;
			 $scope.pageval=page;
			 $scope.pager=false;
			
			 
			$http({
		        method : "GET",
		        url : $location.absUrl()+"api/analytics"
		    }).success(function(resp, status, headers, config) {
		    	//$scope.top5Lang=resp.top_5_languages_used;
		    	//alert(resp);
		    	angular.forEach(resp.top_5_languages_used, function(value, key) {
		    		$scope.top5lang.push({ title:key,cnt:value})
		    	});
		    	angular.forEach(resp.top_2_submissions_attempted, function(value, key) {
		    		$scope.top2Sub.push({ title:key,cnt:value})
		    	});
		    	
                
            $scope.easy=resp.submissions_per_level.Easy;
            $scope.medium=resp.submissions_per_level.Medium;
            $scope.hard=resp.submissions_per_level.Hard;
            $scope.totalCount=resp.total_submissions;
		    }).error(function(data, status, headers, config) {
                alert("Something Went Wrong");
            });
			
			
			
			$scope.getSearchSub=function(){
				//alert($location.absUrl()+"api/search?query="+$scope.search+"&page="+page+"&filter="+$scope.radio);
				$http({
			        method : "GET",
			        url : $location.absUrl()+"api/searchfilter?query="+$scope.search+"&page="+page+"&filter="+$scope.radio
			    }).success(function(resp, status, headers, config) {
			    	//alert(resp);
			    	
	            $scope.submissions=resp.result;
	            $scope.pager=true;
				 
	            
	            
			    }).error(function(data, status, headers, config) {
	                alert("Something Went Wrong");
	            });
				
				//alert("complete");
			}
			
			
			$scope.previous=function(){
				if(page<=1)
					page=1;
				else page--;
				$scope.getSearchSub();
			}
			$scope.next=function(){
				page++;
				$scope.pageval=page;
				$scope.getSearchSub();
			}
			
		}).directive('myEnter', function () {
		    return function (scope, element, attrs) {
		        element.bind("keydown keypress", function (event) {
		            if(event.which === 13) {
		                scope.$apply(function (){
		                    scope.$eval(attrs.myEnter);
		                });

		                event.preventDefault();
		            }
		        });
		    };
		}).directive('highlight', function($interpolate, $window){
	        return {
	            restrict: 'EA',
	            scope: true,
	            compile: function (tElem, tAttrs) {
	              var interpolateFn = $interpolate(tElem.html(), true);
	              tElem.html(''); // disable automatic intepolation bindings
	                            
	              return function(scope, elem, attrs){
	                scope.$watch(interpolateFn, function (value) {
	                  elem.html(hljs.highlight('c',value).value);
	                });
	              }
	              }
	            };	
		});
	
	
	
	</script>
</html>
