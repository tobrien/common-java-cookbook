<#assign student = enrollment.student >
<#assign course = enrollment.course >
<#assign exams = enrollment.exams >
<#-- This macro assigns a variable named final -->
<@final exams=exams/>	

${student.firstName} ${student.lastName},

Here is a summary of your performance in ${course.dept} ${course.num} ${course.name}.  

Class: 		${course.name}
Professor: 	${course.professor}
Section:		${enrollment.section?string("000")}

Exam, Date, Score, Weight, Grade
-----------------------------------------------
<#list exams as exam>
  <@compress single_line=true>
    <#assign score = exam.score >
    ${exam.name}, 
    ${exam.date?date?string.short}, 
    #{exam.score; m1M1}, 
    #{exam.weight; m2M2},
    <@letter score=score/>		
  </@compress>
  
</#list>

Final Grade:  #{final; m1M1} <@letter score=final/>		
Your final grade has been submitted to the Registrar.

<#macro final exams>
	<#local num = 0>
	<#local dem = 0>
	<#list exams as exam>
		<#local num = num + (exam.score * exam.weight)/>
		<#local dem = dem + exam.weight>
	</#list>
	<#assign final = num / dem>
</#macro> 

<#macro letter score>
	<#if (score >= 90)> A
	<#elseif (score >= 80)> B
	<#elseif (score >= 70)> C
	<#elseif (score >= 60)> D
	 <#else> F
	 </#if>
</#macro>