package master_assignment.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
			
			Course c1=new Course(1,"java",new Date(2020,3,22),"xyz",10000,"3month");
			Course c2=new Course(2,"Angular",new Date(2020,3,15),"xyz",10000,"3month");
			Course c3=new Course(3,"react",new Date(2020,4,25),"xyz",10000,"3month");
			
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
			
			
			
			
//			

			
			
			
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
			
		}

	}


