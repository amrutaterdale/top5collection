package master_assignment.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import master_assignment.bean.Academy;
import master_assignment.bean.Course;
import master_assignment.bean.Student;
import master_assignment.bean.TestResult;
import master_assignment.bean.Transaction;





public class TestAcademy {
	public static void main(String[] args) {
		
		int max=0;
		int cid=0;
			Set<Integer>k=Academy.studentMap.keySet();
			for(Integer i:k)
			{
				int count=Academy.studentMap.get(i).size();
				
				if(max<count)
				{
					max=count;
					cid=i;
					
				}
			}
			
			for(int i=0;i<Academy.courseList.size();i++)
			{
				if(cid==Academy.courseList.get(i).courseId)
				{
					System.out.println("most favoured course="+Academy.courseList.get(i).course_name);
				}
			}
			
			
			System.out.println("---------------------------------");
			
//			question 2
			
//			Course c1=new Course(1,"java",new Date(2020,3,22),"xyz",10000,"3month");
//			Course c2=new Course(2,"Angular",new Date(2020,3,15),"xyz",10000,"3month");
//			Course c3=new Course(3,"react",new Date(2020,4,25),"xyz",10000,"3month");
//			
			Map<Integer,Student> lhm=new LinkedHashMap<>();
			
			Set<Integer> key=Academy.transactionMap.keySet();
			
			for(Integer a:key)
			{
				for(Transaction ts:Academy.transactionMap.get(a))
				{
					int total=0;
					for(Transaction ts1:Academy.transactionMap.get(a))
					{
						if(ts.studId==ts1.studId)
						{
							total=total+ts1.paidfees;
						}
							
							for(Integer i:k)
							{
								for(int m=0;m<Academy.studentMap.get(i).size();m++)
								{
									if(Academy.studentMap.get(i).get(m).studentId==ts1.studId)
									{
										lhm.put(total,Academy.studentMap.get(i).get(m));
									}
								}
							}
						}
					}
				}
//			Map<Integer,Student>tm=new TreeMap<>(lhm);
			
			
			System.out.println("****************");
			
			//ques3
			
			Set<Integer>k1=Academy.test_map.keySet();
			for(Integer c:k1)
			{
				//int sz=Academy.test_map.get(c).size();
			for(TestResult ll:Academy.test_map.get(c))
			{
				int totalmks=0;
				int count=0;
				int sid=0;
				for(TestResult ll1:Academy.test_map.get(c))
					
				{
					if(ll.studentId==ll1.studentId)
					{
						count++;
						totalmks=totalmks+ll1.marks;
					}
				
				
				if(totalmks/count <40)
				{
					for(Integer i:k)
					{
						List<Student> l=Academy.studentMap.get(i);
						for(int j=0;j<l.size();j++)
						{
							if(ll.studentId==l.get(j).getStudent_id())
							{
								System.out.println(l.get(j));
							}
						}
					}
					
					
				}
				}
			}
			}
			
			
			System.out.println("***************************");
			
			//question 4
			
        
         Map<Student,List<TestResult>>mp=new HashMap<>();
         
         Set<Integer>crid=Academy.test_map.keySet();
         for(Integer tcid:crid)
         {
        	List<Student>ss=Academy.studentMap.get(tcid);
        	 for(int i=0;i<ss.size();i++)
        	 {
        		 for(TestResult tt:Academy.test_map.get(tcid))
        		 {
        			 if(ss.get(i).studentId==tt.studentId)
        			 {
        				 mp.put(ss.get(i),(List<TestResult>) tt);
        			 }
        		 }
        	 }
         }
         List list=new ArrayList(mp.entrySet());
         Collections.sort(list);
         
         Map<Student,List<TestResult>>srtmp=new HashMap<>();
         for(int i=0;i<list.size();i++)
         {
        	 Entry<Student,List<TestResult>>e=(Entry<Student, List<TestResult>>) list.get(i);
        	 Student Key1=e.getKey();
        	 List<TestResult> value1=e.getValue();
        	 srtmp.put(Key1,value1);
         }
        		
      System.out.println(srtmp);

			
			
			
			System.out.println("********************");
			
			//question 5
			Set<Integer>crid1=Academy.transactionMap.keySet();
			//Set<Integer>crid1=Academy.transactionMap.keySet();
			
			for(Integer h:crid1)
			{
				String cr_name=" ";
				Date cr_start=new Date();
				 int no_stud=Academy.studentMap.get(h).size();
				 int proj_rev=0;
				 int amt_till=0;
				 int amt_left=0;
				 float coll=0;
				for(Course cr:Academy.courseList)
				{
					if(h==cr.courseId)
					{
						cr_name=cr.course_name;
						cr_start=cr.startDate;
						proj_rev=no_stud*cr.courseFees;
					}
				}
				for(Transaction tc:Academy.transactionMap.get(h))
				{
					amt_till=amt_till+tc.paidfees;
				}
				amt_left=proj_rev-amt_till;
				coll=(amt_till*100)/proj_rev;
				
				
				System.out.println("course_name="+cr_name+" "+"course_date="+cr_start+" "+"total_student="+no_stud+" "+
				"total_revenue="+proj_rev+" "+"left fees="+amt_left+" "+"rev till date="+amt_till+"perc collection="+coll);
				
				
				
				
				
				
			}
			
			
			
		}

	}


