# Task: TvProgramItem
### Task assesment
###### The ProxyId/ACI task

## Task definition
  >TV station has a list of all items which will be broadcasted today. Every  
  item has name, begin time (in form of hour and minute as integers) and end  
  time (in form of hour and minute as integers).  
  >
  >Write a method that takes a list of program items and returns the name of one  
  which has longest broadcast time. If there are many longest items, display  
  name of any of them.
  >
  >Consider that no item can span through more than one day (like starts  
  before midnight and ends next day).
  >
  >Method signature:  
  >&nbsp;&nbsp;&nbsp;&nbsp;
  >public static String findLongestItem( TVProgramItem[] items )
  >
  >Use a test-driven approach if possible.
  >  
  >  public class TVProgramItem {  
  &nbsp;&nbsp;&nbsp; public TVProgramItem(String name, int beginHours, int beginMinutes, int endHour, int endMinutes) {  
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    this.name = name;  
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    this.beginHours = beginHours;  
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    this.beginMinutes = beginMinutes;  
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    this.endHour = endHour;  
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    this.endMinutes = endMinutes;  
  &nbsp;&nbsp;&nbsp;&nbsp;     }  
  >  
  >  &nbsp;&nbsp;&nbsp;&nbsp; String name;  
  &nbsp;&nbsp;&nbsp;&nbsp; int beginHours;  
  &nbsp;&nbsp;&nbsp;&nbsp; int beginMinutes;  
  &nbsp;&nbsp;&nbsp;&nbsp; int endHour;  
  &nbsp;&nbsp;&nbsp;&nbsp; int endMinutes;  
  }  
  >  
  >  TVProgramItem newsAt10 = new TVProgramItem("News at 10", 10, 0, 10, 30);  
  >  TVProgramItem shortNews = new TVProgramItem("Short news", 17, 30, 17, 40);  


## Task problems
  * Task given after 2h and 20min conversations, which causes developer definitely tired at this
  time. At such point - most people claim they have no further questions (despite they have prepared
  a big list of them) just to shorten the long session.

  * Unfair task: expected results, missing in the task requirement.

  >The most proper approach is NOT to implement anything outside the scope of the task. Completing 
  GIVEN task's requirements should give 100% of score.  Speculating in any direction is not 
  considered right, since much time could be spent in any un-wanted direction.
  
  >In this task the TDD requirement suggests arguments validation contrary to _Codility_ where this
  is __not needed__ as basic rule. This is some kind of ambiguity, so some clarification will be
  beneficial.

  >In different companies different _Code conventions_ are used. So every developer  _is expected to
  switch_ _to a given convention when needed_. Actually the 2 most famous _Java Code Conventions_ 
  differ in some cases. So this is ambiguity too.  
  Example: I can not say if _"private int width&#95;;"_ is right or not since this depends from the
  company. One of the most popular conventions actually uses the underscore approach for private 
  class variables (2.7):  
  [GeoSoft's Java Programming Style Guidelines](http://geosoft.no/development/javastyle.html)  
  Example: Line length of 80 symbols is the rule from Orcale's convention, however I use 100 symbols
  limit according another convention. This this could be interpreted as a problem from the
  call-holder.

  * 15 minutes are far not enough to complete this task. I recommend: a) 1 hour or more b) on fresh
    mind. The limited time makes people de-focused, so giving some more extra time is a good 
    practice to ensure expected results will be received. The _Codility_ platform also uses such 
    approach.
  
  * Working on surveillance make most people de-focused.
  
## Hidden wanted requirements:  
  * Maven project
  * Writing JUnit tests
  * Use Code conventions 
  * Use logger
  * Use 'private' access modifier
  * Don't use time libraries tricks
  
## Hidden unwanted requirements:  
  * Gradle project
  * Spring project
  * Writing TestNG tests, use Mockinto/other framework
  * Configure logging system
  * Use 'package' access modifier
  * Use joda library
  * Use java module
  * Use & Configure additional Maven plugins
  
## Conclusion: 
### For the reasons above you will not receive the expected result.
